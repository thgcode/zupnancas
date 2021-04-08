package br.com.zup.zupnancas.models;

import javax.persistence.*;

@Entity
@Table(name = "credito_categorias")
public class CategoriaConta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    public CategoriaConta() {
    }

    public CategoriaConta(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
