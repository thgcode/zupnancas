package br.com.zup.zupnancas.dtos;

import br.com.zup.zupnancas.enums.ContaStatusEnum;
import br.com.zup.zupnancas.models.Conta;

import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class AtualizacaoDeContaDTO {
    @Positive
    private int id;

    private String descricao;

    private double valor;

    private LocalDate dataDeVencimento;

    private ContaStatusEnum status;

    public AtualizacaoDeContaDTO() {
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
        return new Conta(id, descricao, valor, null, dataDeVencimento, status, null);
    }
}
