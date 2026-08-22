package com.example.banco.demo.enums;

import com.example.banco.demo.exception.InvalidTransactionTypeException;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TransactionType {
    DEPOSIT,
    WITHDRAW;


    public static TransactionType fromString(String type) {
        return Arrays.stream(TransactionType.values())
                .filter(t -> t.name().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new InvalidTransactionTypeException(
                        "Invalid transaction type: " + type
                ));
    }
}
