package br.com.zup.zupnancas.controllers;

import br.com.zup.zupnancas.dtos.AtualizacaoDeContaDTO;
import br.com.zup.zupnancas.dtos.CadastroDeContaDTO;
import br.com.zup.zupnancas.enums.ContaStatusEnum;
import br.com.zup.zupnancas.models.Conta;
import br.com.zup.zupnancas.services.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("contas/")
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

    @GetMapping("{status}/")
    public Iterable <Conta> listarContasPeloStatus(@PathVariable String status) {
        if (status != null || status.isEmpty()) {
            return contaService.listarTodasAsContas();
        } else {
            return contaService.listarContasPeloStatus(ContaStatusEnum.valueOf(status.toUpperCase()));
        }
    }

    @PatchMapping
    public Conta atualizarConta(@Valid @RequestBody AtualizacaoDeContaDTO dto) {
        return contaService.atualizarConta(dto.converterParaConta());
    }
}
