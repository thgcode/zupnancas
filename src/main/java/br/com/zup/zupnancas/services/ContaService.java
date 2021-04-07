package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.models.Conta;
import br.com.zup.zupnancas.repositories.ContaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    public ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta cadastrarConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public Iterable <Conta> listarTodasAsContas() {
        return contaRepository.findAll();
    }
}
