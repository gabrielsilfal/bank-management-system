package com.example.banco.demo.service;


import com.example.banco.demo.DTO.TransactionDTO;
import com.example.banco.demo.DTO.TransactionResponseDTO;
import com.example.banco.demo.database.model.ClientEntity;
import com.example.banco.demo.database.model.TransactionEntity;
import com.example.banco.demo.database.repository.ITransactionRepository;
import com.example.banco.demo.enums.TransactionType;
import com.example.banco.demo.exception.InsufficientBalanceException;
import com.example.banco.demo.exception.InvalidTransactionTypeException;
import com.example.banco.demo.exception.TransactionNotFoundException;
import com.example.banco.demo.mapper.toDTO;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Builder
@RequiredArgsConstructor
public class TransactionService {

    private final ITransactionRepository transactionRepository;
    final ClientService clientService;

    public List<TransactionResponseDTO> findAll() {
        toDTO mapper = new toDTO();
        return transactionRepository.findAll()
                .stream()
                .map(mapper::transactionMapper)
                .toList();
    }

    public TransactionResponseDTO findById(long id) {
        toDTO mapper = new toDTO();
        TransactionEntity transactionEntity = transactionRepository.findById(id).orElseThrow(() ->
                new TransactionNotFoundException("Transaction not found " + id));
        return mapper.transactionMapper(transactionEntity);
    }

    @Transactional
    public void createTransaction(TransactionDTO transactionDTO, Long clientId) {

        ClientEntity clientEntity = clientService.findEntityById(clientId);

        if(transactionDTO.getType() == TransactionType.WITHDRAW) {

            if (transactionDTO.getValue().compareTo(
                    clientEntity.getBalance()
            ) > 0) {
                throw new InsufficientBalanceException("Insufficient balance");
            }

            clientEntity.setBalance(
                    clientEntity.getBalance().subtract(transactionDTO.getValue())
            );

        }else if(transactionDTO.getType() == TransactionType.DEPOSIT){

            clientEntity.setBalance(
                    clientEntity.getBalance().add(transactionDTO.getValue())
            );
        }

        TransactionEntity transactionEntity = TransactionEntity.builder()
                .value(transactionDTO.getValue())
                .type(transactionDTO.getType())
                .client(clientEntity)
                .build();
        transactionRepository.save(transactionEntity);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
