package com.example.banco.demo.exception;

public class InvalidTransactionTypeException extends RuntimeException {

    public InvalidTransactionTypeException(String message) {
        super(message);
    }
}
