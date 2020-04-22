package com.github.fatimascarneiro.vitrinedeservicos.usecases.repository;

import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Publicacao;

public interface PublicacaoDataAccess {
    Publicacao cadastrar(Publicacao publicacao);
}
