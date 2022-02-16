package com.github.fatimascarneiro.vitrinedeservicos.usecases.services;

import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Publicacao;
import com.github.fatimascarneiro.vitrinedeservicos.usecases.repository.PublicacaoDataAccess;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PublicacaoService {

    private final PublicacaoDataAccess dataAccess;

    public PublicacaoService(PublicacaoDataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public Publicacao cadastrar(Publicacao publicacao) {
        validarPublicacao(publicacao);
        return dataAccess.cadastrar(publicacao);
    }

    private void teste() {

    }

    private void validarPublicacao(Publicacao publicacao) {
        if (publicacao == null) {
            throw new NullPointerException("Não é possível salvar uma publicação nula.");
        }
    }

    public Set<Publicacao> listarPublicacoes() {
        return dataAccess.listarPublicacoes();
    }

    public void validarDescricao(Publicacao publicacao) {
        if (publicacao.getDescricao().equals("")) {
            throw new IllegalArgumentException("Não é possível salvar uma publicação com descric.");
        }
    }
}
