package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.models.Saldo;
import br.com.zup.zupnancas.repositories.SaldoRepository;
import org.springframework.stereotype.Service;

@Service
public class SaldoService {
    private SaldoRepository saldoRepository;

    public SaldoService(SaldoRepository saldoRepository) {
        this.saldoRepository = saldoRepository;
    }

    public Saldo cadastrarSaldo(Saldo saldo) {
        return saldoRepository.save(saldo)
    }

    public Iterable <Saldo> listarTodosOsSaldos() {
        return saldoRepository.findAll();
    }
}
