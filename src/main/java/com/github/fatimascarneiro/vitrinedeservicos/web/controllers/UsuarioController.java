package com.github.fatimascarneiro.vitrinedeservicos.web.controllers;

import com.github.fatimascarneiro.vitrinedeservicos.usecases.services.UsuarioService;
import com.github.fatimascarneiro.vitrinedeservicos.web.tos.UsuarioTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> cadastro(@Valid @RequestBody UsuarioTO to) {
        System.out.println(service.cadastrar(to.toEntity()).toString());
        return ResponseEntity.status(201).build();
    }

}
