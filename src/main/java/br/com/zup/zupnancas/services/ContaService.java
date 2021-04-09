package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.enums.ContaStatusEnum;
import br.com.zup.zupnancas.exceptions.ContaNaoPodeEntrarComoPagaException;
import br.com.zup.zupnancas.models.Conta;
import br.com.zup.zupnancas.models.Saldo;
import br.com.zup.zupnancas.repositories.ContaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ContaService {
    private ContaRepository contaRepository;
    private SaldoService saldoService;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public void acertarStatusParaNovaConta(Conta conta) {
        if (conta.getStatus().equals(ContaStatusEnum.PAGO)) {
            throw new ContaNaoPodeEntrarComoPagaException();
        }

        if (conta.getStatus().equals(ContaStatusEnum.AGUARDANDO) && conta.getDataVencimento().isBefore(LocalDate.now())) {
            conta.setStatus(ContaStatusEnum.ATRASADO);
        }
    }

    public Conta cadastrarConta(Conta conta) {
        saldoService.pesquisarSaldoPeloCpf(conta.getSaldo().getCpf());

        conta.setDataEntrada(LocalDate.now());

        acertarStatusParaNovaConta(conta);
        
        return contaRepository.save(conta);
    }

    public Conta pesquisarContaPeloId(int id) {
        Optional<Conta> optionalConta = contaRepository.findById(id);

        if (optionalConta.isPresent()) {
            return optionalConta.get();
        }

        return null; // Refatorar depois com a exceção
    }

    public Iterable <Conta> listarContasPeloStatus(ContaStatusEnum status) {
        return contaRepository.findAllByStatus(status);
    }

    private Saldo pagarContaSeNecessario(Conta conta) {
        if (conta.getStatus().equals(ContaStatusEnum.PAGO)) {
            return saldoService.pagar(conta.getSaldo().getCpf(), conta);
        }

        return null;
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
            pagarContaSeNecessario(contaDoBanco);
            contaDoBanco.setStatus(conta.getStatus());
        }

        return contaRepository.save(contaDoBanco);
    }

    public Iterable <Conta> listarTodasAsContas() {
        return contaRepository.findAll();
    }
}
