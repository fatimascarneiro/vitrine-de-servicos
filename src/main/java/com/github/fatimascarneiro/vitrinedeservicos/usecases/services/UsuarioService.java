package com.github.fatimascarneiro.vitrinedeservicos.usecases.services;

import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Usuario;
import com.github.fatimascarneiro.vitrinedeservicos.usecases.repository.UsuarioDataAccess;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioDataAccess dataAccess;

    public UsuarioService(UsuarioDataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public Usuario cadastrar(Usuario usuario) {
        return dataAccess.cadastrar(usuario);
    }

}
