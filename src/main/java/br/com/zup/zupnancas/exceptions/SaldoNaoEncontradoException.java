package br.com.zup.zupnancas.exceptions;

import org.springframework.http.HttpStatus;

public class SaldoNaoEncontradoException extends ErroDoSistema{
    public SaldoNaoEncontradoException() {
        super(HttpStatus.PRECONDITION_FAILED, "saldo", "Saldo não encontrado");
    }
}
