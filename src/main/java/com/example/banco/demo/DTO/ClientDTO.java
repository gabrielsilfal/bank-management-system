package com.example.banco.demo.DTO;


import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    @NotNull
    private String name;
    @NotNull
    private BigDecimal balance;
}
