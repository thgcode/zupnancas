package br.com.zup.zupnancas.controllers;

import br.com.zup.zupnancas.dtos.CadastroDeSaldoDTO;
import br.com.zup.zupnancas.models.Saldo;
import br.com.zup.zupnancas.services.SaldoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("saldos/")
public class SaldoController {
    private SaldoService saldoService;

    public SaldoController(SaldoService saldoService) {
        this.saldoService = saldoService;
    }

    @PostMapping
    public Saldo cadastrarSaldo(@Valid @RequestBody CadastroDeSaldoDTO dto) {
        return saldoService.cadastrarSaldo(dto.converterParaSaldo());
    }
}
