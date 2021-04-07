package br.com.zup.zupnancas.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "saldos")
public class Saldo {
    @Id
    private String cpf;

    private double valor;

    private double limite;

    public Saldo() {
    }

    public Saldo(String cpf, double limite) {
        this.cpf = cpf;
        this.valor = 0.0;
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
}
