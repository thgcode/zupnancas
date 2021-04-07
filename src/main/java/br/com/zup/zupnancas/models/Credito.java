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

    private LocalDate dataDeEntrada;

    public Credito() {
    }

    public Credito(int id, String descricao, LocalDate dataDeEntrada) {
        this.id = id;
        this.descricao = descricao;
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

    public LocalDate getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(LocalDate dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }
}
