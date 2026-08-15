package com.example.banco.demo.controller;


import com.example.banco.demo.DTO.ClientDTO;
import com.example.banco.demo.database.model.ClientEntity;
import com.example.banco.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveClient(@RequestBody ClientDTO clientDTO) {
        clientService.saveClient(clientDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientEntity> findAllClients() {
        return clientService.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateClient(@RequestBody ClientDTO clientDTO, @PathVariable Long id) {
        clientService.updateClient(clientDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}
