package com.github.fatimascarneiro.vitrinedeservicos.usecases.services;

import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Publicacao;
import com.github.fatimascarneiro.vitrinedeservicos.usecases.repository.PublicacaoDataAccess;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PublicacaoServiceTest {
    
    @InjectMocks
    private PublicacaoService service;
    
    @Mock
    private Publicacao publicacao;

    @Mock
    private PublicacaoDataAccess dataAccess;

    private Exception exception;

    private Set<Publicacao> publicacoes;

    @Test
    public void deveValidarPublicacao() {
        dadoUmaPublicacaoNula();
        deveDarErroAoCadastrar();
        deveRetornarUmaMensagemDeErroCorreta();
    }

    @Test
    public void deveCadastrarUmaPublicacao() {
        dadoUmaPublicacaoValida();
        quandoCadastrarUmaPublicacao();
        deveCadastrarUmaPublicacaoSemEmitirErro();
    }
    
    @Test
    public void deveRetornarUmSetDePublicacoes(){
        dadoUmSetDePublicacoes();
        quandoListarUmaListaDePublicacoes();
        deveRetornarUmaListaComAsPublicacoesCadastradas();
    }

    @Test
    public void deveValidarSeADescricaoNaoEhVazia() {
        dadoUmaPublicacaoComDescricaoVazia();
        quandoValidarSeDescricaoNaoEhVazia();
        deveRetornarUmaMensagemDeDescricaoInvalida();
    }

    private void deveRetornarUmaMensagemDeDescricaoInvalida() {
        exception = assertThrows(IllegalArgumentException.class, () -> service.validarDescricao(publicacao));
    }

    private void quandoValidarSeDescricaoNaoEhVazia() {
        when(publicacao.getDescricao()).thenReturn("");
    }

    private void dadoUmaPublicacaoComDescricaoVazia() {
        publicacao.setDescricao("");
        publicacao.setPublicacaoKey(2);
        publicacao.setCidade("São Paulo");
        publicacao.setEstado("SP");
    }

    private void deveRetornarUmaListaComAsPublicacoesCadastradas() {
        assertEquals(publicacoes, service.listarPublicacoes());
    }

    private void quandoListarUmaListaDePublicacoes() {
        when(service.listarPublicacoes()).thenReturn(publicacoes);
    }

    private void dadoUmSetDePublicacoes() {
        publicacoes = new HashSet<>();

        Publicacao publicacao1 = new Publicacao(1, "Descrição 1", "MG", "Mariana");
        Publicacao publicacao2 = new Publicacao(1, "Descrição 2", "ES", "Vila Velha");

        publicacoes.add(publicacao1);
        publicacoes.add(publicacao2);
    }

    private void deveCadastrarUmaPublicacaoSemEmitirErro() {
        when(service.cadastrar(publicacao)).thenReturn(publicacao);
    }

    private void quandoCadastrarUmaPublicacao() {
        service.cadastrar(publicacao);
    }

    private void dadoUmaPublicacaoValida() {
        publicacao.setEstado("SP");
        publicacao.setCidade("São Paulo");
        publicacao.setDescricao("Teste 1");
        publicacao.setPublicacaoKey(1);
    }

    private void deveRetornarUmaMensagemDeErroCorreta() {
        String expectedMessage = "Não é possível salvar uma publicação nula.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    private void deveDarErroAoCadastrar() {
        exception = assertThrows(NullPointerException.class, () -> service.cadastrar(publicacao));

    }

    private void dadoUmaPublicacaoNula() {
        publicacao = null;
    }

}