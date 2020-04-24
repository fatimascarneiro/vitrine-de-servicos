package com.github.fatimascarneiro.vitrinedeservicos.web.tos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
public class PublicacoesTO {

    @Getter
    private Set<PublicacaoTO> publicacoes;
}
