package com.github.fatimascarneiro.vitrinedeservicos.repository.dao;

import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static org.springframework.util.StringUtils.isEmpty;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name="user_generator", sequenceName = "user_seq")
    private Integer usuarioKey;

    private String nome;

    private String email;

    private String senha;

    public static UsuarioDao fromEntity(Usuario usuario) {
        return builder()
                .usuarioKey(isEmpty(usuario.getUsuarioKey()) ? null : usuario.getUsuarioKey() )
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .build();
    }

    public Usuario toEntity() {
        return Usuario.builder()
                .email(email)
                .nome(nome)
                .senha(senha)
                .usuarioKey(usuarioKey)
                .build();
    }
}
