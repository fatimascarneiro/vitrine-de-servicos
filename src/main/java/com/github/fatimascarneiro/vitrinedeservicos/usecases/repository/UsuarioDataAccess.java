package com.github.fatimascarneiro.vitrinedeservicos.usecases.repository;

import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Usuario;

public interface UsuarioDataAccess {
    Usuario cadastrar(Usuario usuario);
}
