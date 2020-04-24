package com.github.fatimascarneiro.vitrinedeservicos.repository.repositories;

import com.github.fatimascarneiro.vitrinedeservicos.repository.dao.PublicacaoDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacaoRepository extends JpaRepository<PublicacaoDao, Integer>{

}
