package com.github.fatimascarneiro.vitrinedeservicos.web.tos;

import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Publicacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicacaoTO {

    @NotEmpty(message = "É necessário adicionar uma descrição à publicação.")
    private String descricao;

    @NotEmpty(message = "É necessário adicionar um estado à publicação.")
    private String estado;

    @NotEmpty(message = "É necessário adicionar uma cidade à publicação.")
    private String cidade;

    public static Set<PublicacaoTO> fromEntity(Set<Publicacao> publicacoes) {
        return publicacoes
                .stream()
                .map(PublicacaoTO::fromEntity)
                .collect(toSet());
    }

    public static PublicacaoTO fromEntity(Publicacao publicacao) {
        return builder()
                .descricao(publicacao.getDescricao())
                .estado(publicacao.getEstado())
                .cidade(publicacao.getCidade())
                .build();
    }


    public Publicacao toEntity() {
        return Publicacao.builder()
                .descricao(descricao)
                .estado(estado)
                .cidade(cidade)
                .build();
    }
}
