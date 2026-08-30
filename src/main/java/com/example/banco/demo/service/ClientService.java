package com.example.banco.demo.service;


import com.example.banco.demo.DTO.ClientDTO;
import com.example.banco.demo.DTO.ClientResponseDTO;
import com.example.banco.demo.database.model.ClientEntity;
import com.example.banco.demo.database.repository.IClientRepository;
import com.example.banco.demo.exception.ClientNotFoundException;
import com.example.banco.demo.mapper.toDTO;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Builder
public class ClientService {

    private final IClientRepository clientRepository;

    public List<ClientResponseDTO> findAll() {
        toDTO mapper = new toDTO();
        return clientRepository.findAll()
                .stream()
                .map(mapper::clientMapper)
                .toList();
    }

    public ClientResponseDTO findById(Long id) {
        toDTO mapper = new toDTO();
        ClientEntity clientEntity = clientRepository.findById(id).orElseThrow(()->
                new ClientNotFoundException("Client not found " + id));
        return mapper.clientMapper(clientEntity);
    }

    public ClientEntity findEntityById(Long id) {
        return clientRepository.findById(id).orElseThrow(()->
                new ClientNotFoundException("Client not found " + id));
    }


    public void createClient(ClientDTO clientDTO) {
        ClientEntity clientEntity = ClientEntity.builder()
                .name(clientDTO.getName())
                .build();
        clientRepository.save(clientEntity);
    }

    public void updateClient(ClientDTO clientDTO, Long id) {
        ClientEntity clientEntity = clientRepository.findById(id).orElseThrow(()->
                new ClientNotFoundException("Client not found "+ id));;
        clientEntity.setName(clientDTO.getName());
        clientEntity.setBalance(clientDTO.getBalance());
        clientRepository.save(clientEntity);
    }

    public void deleteClient(Long id) {
        ClientEntity clientEntity = clientRepository.findById(id).orElse(null);
        clientRepository.delete(clientEntity);
    }

}
