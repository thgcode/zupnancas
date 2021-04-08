package br.com.zup.zupnancas.controllers;

import br.com.zup.zupnancas.dtos.CadastrarCategoriaDTO;
import br.com.zup.zupnancas.models.CategoriaConta;
import br.com.zup.zupnancas.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("categorias/")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaConta cadastrarCategoria(@Valid @RequestBody CadastrarCategoriaDTO dto) {
        return categoriaService.cadastrarCategoria(dto.converterParaCategoriaConta());
    }

    @GetMapping
    public Iterable <CategoriaConta> visualizarCategoriasCadastradas() {
        return categoriaService.listarCategorias();
    }
}
