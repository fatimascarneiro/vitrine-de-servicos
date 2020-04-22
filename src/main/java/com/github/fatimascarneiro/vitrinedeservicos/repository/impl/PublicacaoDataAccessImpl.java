package com.github.fatimascarneiro.vitrinedeservicos.repository.impl;

import com.github.fatimascarneiro.vitrinedeservicos.repository.dao.PublicacaoDao;
import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Publicacao;
import com.github.fatimascarneiro.vitrinedeservicos.repository.repositories.PublicacaoRepository;
import com.github.fatimascarneiro.vitrinedeservicos.usecases.repository.PublicacaoDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
