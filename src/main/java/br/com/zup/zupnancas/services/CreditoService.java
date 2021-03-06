package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.exceptions.CreditoNaoEncontradoException;
import br.com.zup.zupnancas.models.CategoriaCredito;
import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.repositories.CreditoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CreditoService {
    private CreditoRepository creditoRepository;
    private SaldoService saldoService;
    private CategoriaService categoriaService;

    public CreditoService(CreditoRepository creditoRepository, SaldoService saldoService, CategoriaService categoriaService) {
        this.creditoRepository = creditoRepository;
        this.saldoService = saldoService;
        this.categoriaService = categoriaService;
    }

    public Credito cadastrarCredito(Credito credito) {
        saldoService.pesquisarSaldoPeloCpf(credito.getSaldo().getCpf());

        credito.setDataDeEntrada(LocalDate.now());

        Credito creditoDoBanco = creditoRepository.save(credito);
        saldoService.creditar(creditoDoBanco.getSaldo().getCpf(), creditoDoBanco);
        return creditoDoBanco;
    }

    public Iterable <Credito> listarTodosOsCreditos() {
        return creditoRepository.findAll();
    }

    public Iterable <Credito> listarCreditosPeloIdDaCategoria(int id) {
        return creditoRepository.findAllByCategoriasId(id);
    }

    public Credito pesquisarCreditoPeloId(int id) {
        Optional <Credito> optionalCredito = creditoRepository.findById(id);

        if (optionalCredito.isPresent()) {
            return optionalCredito.get();
        }

        throw new CreditoNaoEncontradoException();
    }

    public Credito adicionarCreditoNaCategoria(Credito credito, CategoriaCredito categoria) {
        CategoriaCredito categoriaDoBanco = categoriaService.pesquisarCategoriaPeloId(categoria.getId());
        Credito creditoDoBanco = pesquisarCreditoPeloId(credito.getId());

        creditoDoBanco.getCategorias().add(categoriaDoBanco);
        return creditoRepository.save(creditoDoBanco);
    }
}
