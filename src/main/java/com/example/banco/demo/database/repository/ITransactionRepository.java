package com.example.banco.demo.database.repository;

import com.example.banco.demo.database.model.ClientEntity;
import com.example.banco.demo.database.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
