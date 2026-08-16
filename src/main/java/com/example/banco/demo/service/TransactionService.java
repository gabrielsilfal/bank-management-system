package com.example.banco.demo.service;


import com.example.banco.demo.DTO.TransactionDTO;
import com.example.banco.demo.database.model.TransactionEntity;
import com.example.banco.demo.database.repository.ITransactionRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Builder
@RequiredArgsConstructor
public class TransactionService {

    private final ITransactionRepository transactionRepository;
    final ClientService clientService;

    public List<TransactionEntity> findAll() {
        return transactionRepository.findAll();
    }

    public TransactionEntity findById(long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public void createTransaction(TransactionDTO transactionDTO, Long clientId) {
        TransactionEntity transactionEntity = TransactionEntity.builder()
                .value(transactionDTO.getValue())
                .client(clientService.findById(clientId))
                .build();
        transactionRepository.save(transactionEntity);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
