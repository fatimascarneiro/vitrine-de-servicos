package com.github.fatimascarneiro.vitrinedeservicos.repository.entity;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="usuarioKey")
public class Usuario {

    private String nome;

    private Integer usuarioKey;

    private String email;

    private String senha;

}
