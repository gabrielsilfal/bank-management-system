package com.example.banco.demo.controller;


import com.example.banco.demo.DTO.TransactionDTO;
import com.example.banco.demo.DTO.TransactionResponseDTO;
import com.example.banco.demo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("clients/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/{clientId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@Valid @RequestBody TransactionDTO transactionDTO, @PathVariable Long clientId) {
            transactionService.createTransaction(transactionDTO, clientId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionResponseDTO> getTransactions() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionResponseDTO getTransaction(@PathVariable Long id) {
        return  transactionService.findById(id);
    }

    @DeleteMapping("/{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTransaction(@PathVariable Long clientId) {
        transactionService.deleteTransaction(clientId);
    }
}
