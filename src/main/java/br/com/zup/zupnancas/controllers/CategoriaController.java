package br.com.zup.zupnancas.controllers;

import br.com.zup.zupnancas.dtos.CadastrarCategoriaDTO;
import br.com.zup.zupnancas.models.CategoriaConta;
import br.com.zup.zupnancas.services.CategoriaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categorias/")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public CategoriaConta cadastrarCategoria(CadastrarCategoriaDTO dto) {
        return categoriaService.cadastrarCategoria(dto.converterParaCategoriaConta());
    }
}
