package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.models.Conta;
import br.com.zup.zupnancas.repositories.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaService {
    private ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta cadastrarConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public Conta pesquisarContaPeloId(int id) {
        Optional<Conta> optionalConta = contaRepository.findById(id);

        if (optionalConta.isPresent()) {
            return optionalConta.get();
        }

        return null; // Refatorar depois com a exceção
    }

    public Conta atualizarConta(Conta conta) {
        Conta contaDoBanco = pesquisarContaPeloId(conta.getId());

        if (conta.getDescricao() != null) {
            contaDoBanco.setDescricao(conta.getDescricao());
        }

        if (conta.getValor() > 0) {
            contaDoBanco.setValor(conta.getValor());
        }

        if (conta.getDataVencimento() != null) {
            contaDoBanco.setDataVencimento(conta.getDataVencimento());
        }

        if (conta.getStatus() != null) {
            contaDoBanco.setStatus(conta.getStatus());
        }

        return contaRepository.save(contaDoBanco);
    }
    public Iterable <Conta> listarTodasAsContas() {
        return contaRepository.findAll();
    }
}
