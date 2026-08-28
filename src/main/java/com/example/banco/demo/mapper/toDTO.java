package com.example.banco.demo.mapper;


import com.example.banco.demo.DTO.ClientResponseDTO;
import com.example.banco.demo.DTO.TransactionResponseDTO;
import com.example.banco.demo.database.model.ClientEntity;
import com.example.banco.demo.database.model.TransactionEntity;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class toDTO {

    public ClientResponseDTO clientMapper(ClientEntity clientEntity) {
        return  ClientResponseDTO.builder()
                .name(clientEntity.getName())
                .transactions(clientEntity.getTransactions())
                .build();
    }

    public TransactionResponseDTO transactionMapper(TransactionEntity transactionEntity) {
        return TransactionResponseDTO.builder()
                .value(transactionEntity.getValue())
                .type(transactionEntity.getType())
                .build();
    }

}
