package br.com.zup.zupnancas.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "creditos")
public class Credito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String descricao;

    private double valor;

    @Column(nullable = false)
    private LocalDate dataDeEntrada;

    @ManyToMany
    private List <CategoriaCredito> categorias;

    @ManyToOne
    private Saldo saldo;

    public Credito() {
    }

    public Credito(int id, String descricao, double valor, LocalDate dataDeEntrada, Saldo saldo) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.dataDeEntrada = dataDeEntrada;
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

    public LocalDate getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(LocalDate dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public List<CategoriaCredito> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaCredito> categorias) {
        this.categorias = categorias;
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }
}
