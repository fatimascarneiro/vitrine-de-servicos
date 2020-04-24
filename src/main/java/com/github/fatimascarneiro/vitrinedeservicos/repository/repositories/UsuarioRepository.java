package com.github.fatimascarneiro.vitrinedeservicos.repository.repositories;

import com.github.fatimascarneiro.vitrinedeservicos.repository.dao.UsuarioDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioDao, Integer> {
}
