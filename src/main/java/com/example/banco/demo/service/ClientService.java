package com.example.banco.demo.service;


import com.example.banco.demo.DTO.ClientDTO;
import com.example.banco.demo.database.model.ClientEntity;
import com.example.banco.demo.database.repository.IClientRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Builder
public class ClientService {

    private final IClientRepository clientRepository;

    public List<ClientEntity> findAll() {
        return clientRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public ClientEntity findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }


    public void createClient(ClientDTO clientDTO) {
        ClientEntity clientEntity = ClientEntity.builder()
                .name(clientDTO.getName())
                .build();
        clientRepository.save(clientEntity);
    }

    public void updateClient(ClientDTO clientDTO, Long id) {
        ClientEntity clientEntity = clientRepository.findById(id).orElseThrow();;
        clientEntity.setName(clientDTO.getName());
        clientRepository.save(clientEntity);
    }

    public void deleteClient(Long id) {
        ClientEntity clientEntity = clientRepository.findById(id).orElse(null);
        clientRepository.delete(clientEntity);
    }
}
