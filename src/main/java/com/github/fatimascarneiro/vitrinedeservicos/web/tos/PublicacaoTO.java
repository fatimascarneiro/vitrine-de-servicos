package com.github.fatimascarneiro.vitrinedeservicos.web.tos;

import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Publicacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

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


    public Publicacao toEntity() {
        return Publicacao.builder()
                .descricao(descricao)
                .estado(estado)
                .cidade(cidade)
                .build();
    }
}
