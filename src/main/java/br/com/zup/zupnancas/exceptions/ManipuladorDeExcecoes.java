package br.com.zup.zupnancas.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ManipuladorDeExcecoes extends ResponseEntityExceptionHandler {
    private List <Erro> criaListaDeErros(MethodArgumentNotValidException excecao) {
        List <Erro> erros = new ArrayList <>();

        for (FieldError erroNoCampo: excecao.getFieldErrors()) {
            erros.add(new Erro(erroNoCampo.getField(), erroNoCampo.getDefaultMessage()));
        }

        return erros;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List <Erro> erros = criaListaDeErros(ex);

        ErroDTO dto = new ErroDTO(status, "validação", erros);

        return ResponseEntity.status(status).body(dto);
    }
}
