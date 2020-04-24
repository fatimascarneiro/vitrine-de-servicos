package com.github.fatimascarneiro.vitrinedeservicos.web.tos;

import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioTO {

    @NotEmpty(message = "O usuário precisa ter um nome para ser cadastrado.")
    private String nome;

    @NotEmpty(message = "O usuário precisa um e-mail para ser cadastrado.")
    private String email;

    @NotEmpty(message = "O usuário precisa ter um nome de usuário para ser cadastrado.")
    private String userName;

    @NotEmpty(message = "O usuário precisa ter uma senha para ser cadastrado.")
    private String senha;

    public Usuario toEntity() {
        return Usuario.builder()
                .nome(nome)
                .senha(senha)
                .email(email)
                .build();
    }
}
