package br.com.zup.zupnancas.controllers;

import br.com.zup.zupnancas.dtos.AdicionarCategoriaNoCreditoDTO;
import br.com.zup.zupnancas.dtos.CadastroDeCreditoDTO;
import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.services.CreditoService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("creditos/")
public class CreditoController {
    private CreditoService creditoService;

    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @PostMapping
    public Credito cadastrarCredito(@RequestBody @Valid CadastroDeCreditoDTO dto) {
        return creditoService.cadastrarCredito(dto.converterParaCredito());
    }

    @GetMapping
    public Iterable <Credito> listarTodosOsCreditos() {
        return creditoService.listarTodosOsCreditos();
    }

    @PostMapping("categorias/")
    public Credito adicionarCreditoNaCategoria(@Valid @RequestBody AdicionarCategoriaNoCreditoDTO dto) {
        return creditoService.adicionarCreditoNaCategoria(dto.converterParaCredito(), dto.converterParaCategoria());
    }
}
