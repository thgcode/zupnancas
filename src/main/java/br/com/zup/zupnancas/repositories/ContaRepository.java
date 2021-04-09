package br.com.zup.zupnancas.repositories;

import br.com.zup.zupnancas.enums.ContaStatusEnum;
import br.com.zup.zupnancas.models.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository <Conta, Integer> {
    public Iterable <Conta> findAllByStatus(ContaStatusEnum status);
}
