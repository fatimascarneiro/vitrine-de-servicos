package com.github.fatimascarneiro.vitrinedeservicos.usecases.services;

import com.github.fatimascarneiro.vitrinedeservicos.repository.entity.Publicacao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
class PublicacaoServiceTest {
    
    @InjectMocks
    private PublicacaoService service;
    
    @Mock
    private Publicacao publicacao;

    private Exception exception;

    @Test
    public void deveValidarPublicacao() {
        dadoUmaPublicacaoNula();
        deveDarErroAoCadastrar();
        deveRetornarUmaMensagemDeErroCorreta();
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