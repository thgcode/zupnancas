package br.com.zup.zupnancas.dtos;

import br.com.zup.zupnancas.models.Conta;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class CadastroDeContaDTO {
    @NotEmpty
    private String descricao;

    @Positive
    private double valor;

    @NotNull
    private LocalDate dataDeVencimento;

    public  CadastroDeContaDTO() {
    }

    public CadastroDeContaDTO(@NotEmpty String descricao, @Positive double valor, @NotNull LocalDate dataDeVencimento) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataDeVencimento = dataDeVencimento;
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

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public Conta converterParaConta() {
        return new Conta(0, descricao, 0.0, null, dataDeVencimento, null);
    }
}
