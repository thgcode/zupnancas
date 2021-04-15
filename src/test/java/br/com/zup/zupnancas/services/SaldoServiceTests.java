package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.exceptions.SaldoNaoEncontradoException;
import br.com.zup.zupnancas.models.Saldo;
import br.com.zup.zupnancas.repositories.SaldoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void testarListarTodosOsSaldos() {
        List<Saldo> resultados = Arrays.asList(saldoDeTeste);

        Mockito.when(saldoRepository.findAll()).thenReturn(resultados);

        Iterable<Saldo> resultadosDoServico = saldoService.listarTodosOsSaldos();

        int contador = 0;

        for (Saldo saldo : resultadosDoServico) {
            contador++;
        }

        Assertions.assertEquals(1, contador);
    }

    @Test
    public void testarPesquisarPeloCPF() {
        Optional<Saldo> optionalSaldo = Optional.of(saldoDeTeste);
        Mockito.when(saldoRepository.findById(Mockito.anyString())).thenReturn(optionalSaldo);

        Saldo saldoDoServico = saldoService.pesquisarSaldoPeloCpf(saldoDeTeste.getCpf());

        Assertions.assertSame(saldoDeTeste, saldoDoServico);
    }

    @Test
    public void testarPesquisarCPFComErro() {
        Mockito.when(saldoRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());

        Assertions.assertThrows(SaldoNaoEncontradoException.class, () -> {
            saldoService.pesquisarSaldoPeloCpf(saldoDeTeste.getCpf());
        });
    }
}
