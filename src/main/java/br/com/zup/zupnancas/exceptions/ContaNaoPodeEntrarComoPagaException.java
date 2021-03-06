package br.com.zup.zupnancas.exceptions;

import org.springframework.http.HttpStatus;

public class ContaNaoPodeEntrarComoPagaException extends ErroDoSistema {
    public ContaNaoPodeEntrarComoPagaException() {
        super(HttpStatus.PRECONDITION_FAILED, "conta", "Conta não pode entrar como paga no sistema");
    }
}
