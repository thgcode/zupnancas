package br.com.zup.zupnancas.models;

import br.com.zup.zupnancas.enums.ContaStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;

    private double valor;

    @Column(nullable = false)
    private LocalDate dataEntrada;

    @Column(nullable = false)
    private LocalDate dataVencimento;

    @Column(nullable = false)
    private ContaStatusEnum status;

    @JsonIgnore
    @ManyToOne
    private Saldo saldo;

    public Conta() {
    }

    public Conta(int id, String descricao, double valor, LocalDate dataEntrada, LocalDate dataVencimento, ContaStatusEnum status, Saldo saldo) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.dataEntrada = dataEntrada;
        this.dataVencimento = dataVencimento;
        this.status = status;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public ContaStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ContaStatusEnum status) {
        this.status = status;
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }
}
