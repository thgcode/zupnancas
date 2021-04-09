package br.com.zup.zupnancas.exceptions;

import org.springframework.http.HttpStatus;

public class SaldoInsuficienteException extends ErroDoSistema {
    public SaldoInsuficienteException() {
        super(HttpStatus.PRECONDITION_FAILED, "saldo", "Saldo insuficiente para pagar a conta");
    }
}
