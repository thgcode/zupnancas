package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.repositories.CreditoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreditoService {
    private CreditoRepository creditoRepository;

    public CreditoService(CreditoRepository creditoRepository) {
        this.creditoRepository = creditoRepository;
    }

    public Credito cadastrarCredito(Credito credito) {
        credito.setDataDeEntrada(LocalDate.now());
        return creditoRepository.save(credito);
    }

    public Iterable <Credito> listarTodosOsCreditos() {
        return creditoRepository.findAll();
    }
}
