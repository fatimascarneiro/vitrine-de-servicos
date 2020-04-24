package com.github.fatimascarneiro.vitrinedeservicos.repository.dao;

import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Publicacao;
import lombok.*;

import javax.persistence.*;

import static org.springframework.util.StringUtils.isEmpty;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PublicacaoDao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publi_generator")
    @SequenceGenerator(name="publi_generator", sequenceName = "publi_seq")
    private Integer publicacaoKey;

    private String descricao;

    private String estado;

    private String cidade;

    public static PublicacaoDao fromEntity(Publicacao publicacao) {
            return builder()
                    .publicacaoKey(isEmpty(publicacao.getPublicacaoKey()) ? null : publicacao.getPublicacaoKey() )
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
                .publicacaoKey(publicacaoKey)
                .build();
    }
}
