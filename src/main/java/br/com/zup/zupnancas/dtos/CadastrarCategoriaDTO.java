package br.com.zup.zupnancas.dtos;

import br.com.zup.zupnancas.models.CategoriaConta;

import javax.validation.constraints.NotEmpty;

public class CadastrarCategoriaDTO {
    @NotEmpty
    private String nome;

    public cadastrarCategoriaDTO() {
    }

    public CadastrarCategoriaDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaConta converterParaCategoriaConta() {
        return new CategoriaConta(0, nome);
    }
}
