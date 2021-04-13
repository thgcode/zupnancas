package br.com.zup.zupnancas.controllers;

import br.com.zup.zupnancas.dtos.CadastroDeSaldoDTO;
import br.com.zup.zupnancas.models.Saldo;
import br.com.zup.zupnancas.services.SaldoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("saldos/")
public class SaldoController {
    private SaldoService saldoService;

    public SaldoController(SaldoService saldoService) {
        this.saldoService = saldoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Saldo cadastrarSaldo(@Valid @RequestBody CadastroDeSaldoDTO dto) {
        return saldoService.cadastrarSaldo(dto.converterParaSaldo());
    }

    @GetMapping("{cpf}/")
    public Saldo pesquisarSaldoPeloCpf(@PathVariable String cpf) {
        return saldoService.pesquisarSaldoPeloCpf(cpf);
    }
}
