package com.github.fatimascarneiro.vitrinedeservicos.repository.impl;

import com.github.fatimascarneiro.vitrinedeservicos.repository.dao.PublicacaoDao;
import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Publicacao;
import com.github.fatimascarneiro.vitrinedeservicos.repository.repositories.PublicacaoRepository;
import com.github.fatimascarneiro.vitrinedeservicos.usecases.repository.PublicacaoDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PublicacaoDataAccessImpl implements PublicacaoDataAccess {

    private final PublicacaoRepository repository;

    @Autowired
    public PublicacaoDataAccessImpl(PublicacaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Publicacao cadastrar(Publicacao publicacao) {
        PublicacaoDao dao = PublicacaoDao.fromEntity(publicacao);
        return repository.save(dao).toEntity();
    }

    @Override
    public Set<Publicacao> listarPublicacoes() {
        return repository.findAll()
                .stream()
                .map(PublicacaoDao::toEntity)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Publicacao> listarPublicacoesPorEstado(String estado) {
        return repository.findAll()
                .stream()
                .filter(publicacaoDao -> publicacaoDao.getEstado().equals(estado))
                .map(PublicacaoDao::toEntity)
                .collect(Collectors.toSet());
    }

}
