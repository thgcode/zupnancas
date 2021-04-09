package br.com.zup.zupnancas.controllers;

import br.com.zup.zupnancas.dtos.CadastrarCategoriaDTO;
import br.com.zup.zupnancas.models.CategoriaCredito;
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
    public CategoriaCredito cadastrarCategoria(@Valid @RequestBody CadastrarCategoriaDTO dto) {
        return categoriaService.cadastrarCategoria(dto.converterParaCategoriaConta());
    }

    @GetMapping
    public Iterable <CategoriaCredito> visualizarCategoriasCadastradas() {
        return categoriaService.listarCategorias();
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCategoriaPeloId(@PathVariable int id) {
        categoriaService.removerCategoriaPeloId(id);
    }

    @GetMapping("{id}/")
    public void pesquisarCategoriaPeloId(@PathVariable int id) {
        categoriaService.pesquisarCategoriaPeloId(id);
    }
}
