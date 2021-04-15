package br.com.zup.zupnancas.services;

import br.com.zup.zupnancas.models.CategoriaCredito;
import br.com.zup.zupnancas.repositories.CategoriaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CategoriaServiceTests {
    @Autowired
    private CategoriaService categoriaService;

    @MockBean
    private CategoriaRepository categoriaRepository;

    private CategoriaCredito categoria;

    @BeforeEach
    public void setup() {
        CategoriaCredito categoria = new CategoriaCredito(0, "Teste");
    }

    @Test
    public void testarAdicionarCategoria() {
        Mockito.when(categoriaRepository.save(Mockito.any(CategoriaCredito.class))).thenReturn(categoria);

        CategoriaCredito categoriaDoServico = categoriaService.cadastrarCategoria(categoria);

        Assertions.assertEquals(categoria, categoriaDoServico);
    }
}
