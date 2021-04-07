package br.com.zup.zupnancas.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "creditos")
public class Credito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;

    private double valor;

    private LocalDate dataDeEntrada;

    public Credito() {
    }

    public Credito(int id, String descricao, double valor, LocalDate dataDeEntrada) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.dataDeEntrada = dataDeEntrada;
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

    public LocalDate getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(LocalDate dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }
}
