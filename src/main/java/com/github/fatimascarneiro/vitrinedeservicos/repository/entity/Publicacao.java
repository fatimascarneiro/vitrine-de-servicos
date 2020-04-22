package com.github.fatimascarneiro.vitrinedeservicos.repository.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(of="publicacaoKey")
public class Publicacao {

    private int publicacaoKey;

    private String descricao;

    private String estado;

    private String cidade;

}
