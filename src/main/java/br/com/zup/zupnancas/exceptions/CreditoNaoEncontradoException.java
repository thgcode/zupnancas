package br.com.zup.zupnancas.exceptions;

import org.springframework.http.HttpStatus;

public class CreditoNaoEncontradoException extends ErroDoSistema{
    public CreditoNaoEncontradoException() {
        super(HttpStatus.PRECONDITION_FAILED, "crédito", "Crédito não encontrado");
    }
}
