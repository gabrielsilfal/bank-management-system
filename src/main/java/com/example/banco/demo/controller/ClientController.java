package com.example.banco.demo.controller;


import com.example.banco.demo.DTO.ClientDTO;
import com.example.banco.demo.DTO.ClientResponseDTO;
import com.example.banco.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@Valid @RequestBody ClientDTO clientDTO) {
        clientService.createClient(clientDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientResponseDTO> getClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponseDTO getClient(@PathVariable Long id) {
        return  clientService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateClient(@Valid @RequestBody ClientDTO clientDTO, @PathVariable Long id) {
        clientService.updateClient(clientDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}
