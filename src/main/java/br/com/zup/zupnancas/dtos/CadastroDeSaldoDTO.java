package br.com.zup.zupnancas.dtos;

import br.com.zup.zupnancas.models.Saldo;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class CadastroDeSaldoDTO {
    @CPF
    @NotNull
    private String cpf;

    private double valor;

    @PositiveOrZero
    private double limite;

    public CadastroDeSaldoDTO() {
    }

    public CadastroDeSaldoDTO(@CPF @NotNull String cpf, double valor, @PositiveOrZero double limite) {
        this.cpf = cpf;
        this.valor = valor;
        this.limite = limite;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public Saldo converterParaSaldo() {
        return new Saldo(cpf, valor, limite);
    }
}
