package br.com.zup.zupnancas.dtos;

import br.com.zup.zupnancas.models.CategoriaCredito;

import javax.validation.constraints.NotEmpty;

public class CadastrarCategoriaDTO {
    @NotEmpty
    private String nome;

    public CadastrarCategoriaDTO() {
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

    public CategoriaCredito converterParaCategoriaConta() {
        return new CategoriaCredito(0, nome);
    }
}
