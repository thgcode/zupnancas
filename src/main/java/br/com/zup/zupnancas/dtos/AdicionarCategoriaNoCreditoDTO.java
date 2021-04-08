package br.com.zup.zupnancas.dtos;

import br.com.zup.zupnancas.models.CategoriaCredito;
import br.com.zup.zupnancas.models.Credito;

import javax.validation.constraints.Positive;

public class AdicionarCategoriaNoCreditoDTO {
    @Positive
    private int categoriaId;

    @Positive
    private int creditoId;

    public AdicionarCategoriaNoCreditoDTO() {
    }

    public AdicionarCategoriaNoCreditoDTO(int categoriaId, int creditoId) {
        this.categoriaId = categoriaId;
        this.creditoId = creditoId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getCreditoId() {
        return creditoId;
    }

    public void setCreditoId(int creditoId) {
        this.creditoId = creditoId;
    }

    public Credito converterParaCredito() {
        Credito credito = new Credito();
        credito.setId(creditoId);
        return credito;
    }

    public CategoriaCredito converterParaCategoria() {
        CategoriaCredito categoria = new CategoriaCredito();
        categoria.setId(categoriaId);
        return categoria;
    }
}
