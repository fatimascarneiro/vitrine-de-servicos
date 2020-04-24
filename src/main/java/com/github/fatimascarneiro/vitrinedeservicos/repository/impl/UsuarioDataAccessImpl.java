package com.github.fatimascarneiro.vitrinedeservicos.repository.impl;

import com.github.fatimascarneiro.vitrinedeservicos.repository.dao.UsuarioDao;
import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Usuario;
import com.github.fatimascarneiro.vitrinedeservicos.repository.repositories.UsuarioRepository;
import com.github.fatimascarneiro.vitrinedeservicos.usecases.repository.UsuarioDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDataAccessImpl implements UsuarioDataAccess {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioDataAccessImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario cadastrar(Usuario usuario) {
        UsuarioDao dao = UsuarioDao.fromEntity(usuario);
        return repository.save(dao).toEntity();
    }
}
