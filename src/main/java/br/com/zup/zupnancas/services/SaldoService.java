package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.exceptions.SaldoInsuficienteException;
import br.com.zup.zupnancas.exceptions.SaldoNaoEncontradoException;
import br.com.zup.zupnancas.models.Conta;
import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.models.Saldo;
import br.com.zup.zupnancas.repositories.SaldoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaldoService {
    private SaldoRepository saldoRepository;

    public SaldoService(SaldoRepository saldoRepository) {
        this.saldoRepository = saldoRepository;
    }

    public Saldo cadastrarSaldo(Saldo saldo) {
        return saldoRepository.save(saldo);
    }

    public Iterable <Saldo> listarTodosOsSaldos() {
        return saldoRepository.findAll();
    }

    public Saldo pesquisarSaldoPeloCpf(String cpf) {
        Optional <Saldo> optionalSaldo = saldoRepository.findById(cpf);

        if (optionalSaldo.isPresent()) {
            return optionalSaldo.get();
        }

        throw new SaldoNaoEncontradoException();
    }

    private void validarSePodePagarConta(Conta conta, Saldo saldo) {
        double dinheiroDisponivel = saldo.getValor() + saldo.getLimite();

        if (conta.getValor() > dinheiroDisponivel) {
            throw new SaldoInsuficienteException();
        }
    }

    public Saldo pagar(String cpf, Conta conta) {
        Saldo saldo = pesquisarSaldoPeloCpf(cpf);

        validarSePodePagarConta(conta, saldo);

        saldo.setValor(saldo.getValor() - conta.getValor());

        return saldoRepository.save(saldo);
    }

    public Saldo creditar(String cpf, Credito credito) {
        Saldo saldo = pesquisarSaldoPeloCpf(cpf);

        saldo.setValor(saldo.getValor() + credito.getValor());

        return saldoRepository.save(saldo);
    }
}
