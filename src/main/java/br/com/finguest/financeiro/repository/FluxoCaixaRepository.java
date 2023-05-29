package br.com.finguest.financeiro.repository;

import br.com.finguest.financeiro.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface FluxoCaixaRepository extends JpaRepository<Lancamento, Long> {
    List<Lancamento> findAllByUltimaAtualizacaoBetween(Timestamp dataInicio,Timestamp dataFim);
}
