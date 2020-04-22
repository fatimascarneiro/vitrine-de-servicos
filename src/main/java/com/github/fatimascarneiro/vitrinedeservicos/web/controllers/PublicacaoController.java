package com.github.fatimascarneiro.vitrinedeservicos.web.controllers;

import com.github.fatimascarneiro.vitrinedeservicos.web.tos.PublicacaoTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/publicacao")
public class PublicacaoController {

    @PostMapping
    public ResponseEntity<?> cadastro(@Valid @RequestBody PublicacaoTO to) {
        System.out.println(to.toEntity().toString());
            return ResponseEntity.status(201).build();
    }

}
