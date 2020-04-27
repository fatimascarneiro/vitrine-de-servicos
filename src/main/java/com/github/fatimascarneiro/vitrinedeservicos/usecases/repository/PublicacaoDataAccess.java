package com.github.fatimascarneiro.vitrinedeservicos.usecases.repository;

import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Publicacao;

import java.util.Set;

public interface PublicacaoDataAccess {
    Publicacao cadastrar(Publicacao publicacao);

    Set<Publicacao> listarPublicacoes();

    Set<Publicacao> listarPublicacoesPorEstado(String estado);
}
