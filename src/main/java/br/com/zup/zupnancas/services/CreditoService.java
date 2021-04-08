package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.models.CategoriaCredito;
import br.com.zup.zupnancas.models.Credito;
import br.com.zup.zupnancas.repositories.CreditoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CreditoService {
    private CreditoRepository creditoRepository;
    private CategoriaService categoriaService;

    public CreditoService(CreditoRepository creditoRepository, CategoriaService categoriaService) {
        this.creditoRepository = creditoRepository;
        this.categoriaService = categoriaService;
    }

    public Credito cadastrarCredito(Credito credito) {
        credito.setDataDeEntrada(LocalDate.now());
        return creditoRepository.save(credito);
    }

    public Iterable <Credito> listarTodosOsCreditos() {
        return creditoRepository.findAll();
    }

    public Credito pesquisarCreditoPeloId(int id) {
        Optional <Credito> optionalCredito = creditoRepository.findById(id);

        if (optionalCredito.isPresent()) {
            return optionalCredito.get();
        }

        return null; // Gerar exceção
    }

    public Credito adicionarCreditoNaCategoria(Credito credito, CategoriaCredito categoria) {
        CategoriaCredito categoriaDoBanco = categoriaService.pesquisarCategoriaPeloId(categoria.getId());
        Credito creditoDoBanco = pesquisarCreditoPeloId(credito.getId());

        creditoDoBanco.getCategorias().add(categoriaDoBanco);
        return creditoRepository.save(creditoDoBanco);
    }
}
