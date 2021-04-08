package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.models.CategoriaConta;
import br.com.zup.zupnancas.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaConta cadastrarCategoria(CategoriaConta categoria) {
        return categoriaRepository.save(categoria);
    }

    public Iterable <CategoriaConta> listarCategorias() {
        return categoriaRepository.findAll();
    }
}
