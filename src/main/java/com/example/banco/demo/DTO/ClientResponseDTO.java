package com.example.banco.demo.DTO;


import com.example.banco.demo.database.model.TransactionEntity;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {
    private String name;
    private BigDecimal balance;
    private List<TransactionEntity> transactions;
}
