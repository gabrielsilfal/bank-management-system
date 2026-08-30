package com.example.banco.demo.handler;


import com.example.banco.demo.exception.ClientNotFoundException;
import com.example.banco.demo.exception.InsufficientBalanceException;
import com.example.banco.demo.exception.InvalidTransactionTypeException;
import com.example.banco.demo.exception.TransactionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<String> handleClientNotFoundException(ClientNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<String> handleTransactionNotFoundException(TransactionNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(InvalidTransactionTypeException.class)
    public ResponseEntity<String> handleInvalidTransactionTypeException(InvalidTransactionTypeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleInsufficientBalanceException(InsufficientBalanceException e){
     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
