package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.models.CategoriaCredito;
import br.com.zup.zupnancas.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaCredito cadastrarCategoria(CategoriaCredito categoria) {
        return categoriaRepository.save(categoria);
    }

    public Iterable <CategoriaCredito> listarCategorias() {
        return categoriaRepository.findAll();
    }
}
