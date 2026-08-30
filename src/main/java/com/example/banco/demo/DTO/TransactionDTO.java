package com.example.banco.demo.DTO;


import com.example.banco.demo.enums.TransactionType;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

   @NotNull
   private BigDecimal value;
   @NotNull
   private TransactionType type;
}
