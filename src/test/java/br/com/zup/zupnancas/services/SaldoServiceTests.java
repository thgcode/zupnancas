package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.models.Saldo;
import br.com.zup.zupnancas.repositories.SaldoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class SaldoServiceTests {
    @Autowired
    private SaldoService saldoService;

    @MockBean
    private SaldoRepository saldoRepository;

    private Saldo saldoDeTeste;

    @BeforeEach
    public void setup() {
        saldoDeTeste = new Saldo("559.719.370-81", 1000.0);
    }

    @Test
    public void testarCadastroDeSaldo() {
        Mockito.when(saldoRepository.save(Mockito.any(Saldo.class))).thenReturn(saldoDeTeste);

        Saldo saldoDoServico = saldoService.cadastrarSaldo(saldoDeTeste);

        Assertions.assertEquals(saldoDoServico, saldoDoServico);
    }
    }
