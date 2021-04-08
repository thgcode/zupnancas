package br.com.zup.zupnancas.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ErroDTO {
    private HttpStatus status;
    private String tipo;
    private List <Erro> erros;

    public ErroDTO(HttpStatus status, String tipo, String mensagem) {
        this(status, tipo, Arrays.asList(new Erro(mensagem)));
    }

    public ErroDTO(HttpStatus status, String tipo, List<Erro> erros) {
        this.status = status;
        this.tipo = tipo;
        this.erros = erros;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Erro> getErros() {
        return erros;
    }

    public void setErros(List<Erro> erros) {
        this.erros = erros;
    }
}
