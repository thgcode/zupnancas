package br.com.zup.zupnancas.exceptions;

import org.springframework.http.HttpStatus;

public class CategoriaNaoEncontradaException extends ErroDoSistema {
    public CategoriaNaoEncontradaException() {
        super(HttpStatus.PRECONDITION_FAILED, "categoria", "Categoria não encontrada");
    }
}
