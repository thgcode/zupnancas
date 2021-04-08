package br.com.zup.zupnancas.controllers;

import br.com.zup.zupnancas.dtos.CadastroDeContaDTO;
import br.com.zup.zupnancas.models.Conta;
import br.com.zup.zupnancas.services.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ContaController {
    private ContaService contaService;

    private ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta cadastrarConta(@Valid @RequestBody CadastroDeContaDTO dto) {
        return contaService.cadastrarConta(dto.converterParaConta());
    }
}
