package com.example.banco.demo.database.repository;

import com.example.banco.demo.database.model.ClientEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClientRepository extends JpaRepository<ClientEntity, Long> {
    List<ClientEntity> findAll(Sort sort);
}
