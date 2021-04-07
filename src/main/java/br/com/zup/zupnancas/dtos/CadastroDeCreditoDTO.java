package br.com.zup.zupnancas.dtos;

import br.com.zup.zupnancas.models.Credito;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class CadastroDeCreditoDTO {
    @NotEmpty
    private String descricao;

    @Positive
    private double valor;

    public CadastroDeCreditoDTO() {
    }

    public CadastroDeCreditoDTO(@NotEmpty String descricao, @Positive double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Credito converterParaCredito() {
        return new Credito(0, descricao, valor, null);
    }
}
