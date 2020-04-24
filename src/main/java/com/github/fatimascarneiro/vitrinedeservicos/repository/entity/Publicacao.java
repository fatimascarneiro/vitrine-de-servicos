package com.github.fatimascarneiro.vitrinedeservicos.repository.entity;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="publicacaoKey")
public class Publicacao {

    private Integer publicacaoKey;

    private String descricao;

    private String estado;

    private String cidade;

}
