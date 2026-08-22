package com.example.banco.demo.DTO;

import com.example.banco.demo.enums.TransactionType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDTO {
    private BigDecimal value;
    private TransactionType type;
}
