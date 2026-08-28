package com.example.banco.demo.DTO;


import com.example.banco.demo.database.model.TransactionEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {
    private String name;
    private List<TransactionEntity> transactions;
}
