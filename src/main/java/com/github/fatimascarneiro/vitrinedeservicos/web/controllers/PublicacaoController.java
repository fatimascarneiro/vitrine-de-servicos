package com.github.fatimascarneiro.vitrinedeservicos.web.controllers;

import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Publicacao;
import com.github.fatimascarneiro.vitrinedeservicos.usecases.services.PublicacaoService;
import com.github.fatimascarneiro.vitrinedeservicos.web.tos.PublicacoesTO;
import com.github.fatimascarneiro.vitrinedeservicos.web.tos.PublicacaoTO;
import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/publicacao")
public class PublicacaoController {

    private final PublicacaoService service;

    @Autowired
    public PublicacaoController(PublicacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastro(@Valid @RequestBody PublicacaoTO to) {
        System.out.println(service.cadastrar(to.toEntity()).toString());
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public @ResponseBody ResponseEntity<PublicacoesTO> listarPublicacoes() {
        Set<Publicacao> publicacoes = service.listarPublicacoes();
        PublicacoesTO response = new PublicacoesTO(PublicacaoTO.fromEntity(publicacoes));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{estado}")
    public @ResponseBody ResponseEntity<PublicacoesTO> listarPublicacoesPorEstado(@PathVariable String estado) {
        Set<Publicacao> publicacoes = service.listarPublicacoesPorEstado(estado);
        PublicacoesTO response = new PublicacoesTO(PublicacaoTO.fromEntity(publicacoes));
        return ResponseEntity.ok(response);
    }

}
