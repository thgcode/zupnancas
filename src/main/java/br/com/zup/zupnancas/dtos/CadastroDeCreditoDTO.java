package br.com.zup.zupnancas.dtos;

import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.models.Saldo;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class CadastroDeCreditoDTO {
    @NotEmpty
    private String descricao;

    @Positive
    private double valor;

    @NotEmpty
    @CPF
    private String cpf;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Credito converterParaCredito() {
        Saldo saldo = new Saldo(cpf, 0.0);
        return new Credito(0, descricao, valor, null, saldo);
    }
}
