package br.com.finguest.financeiro.service;

import br.com.finguest.financeiro.enums.TipoLancamentoEnum;
import br.com.finguest.financeiro.model.Lancamento;
import br.com.finguest.financeiro.repository.FluxoCaixaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FluxoCaixaService {

    private final FluxoCaixaRepository fluxoCaixaRepository;

    public List<Lancamento> obterLancamentos() {
        return fluxoCaixaRepository.findAll();
    }

    public Lancamento obterLancamentoPorId(Long id) {
        return fluxoCaixaRepository.findById(id).get();
    }

    public Lancamento inserirLancamento(Lancamento lancamento) {
        lancamento.setUltimaAtualizacao(Timestamp.valueOf(LocalDateTime.now()));
        return fluxoCaixaRepository.save(lancamento);
    }

    public Lancamento atualizarLancamento(Lancamento lancamento) {
        lancamento.setUltimaAtualizacao(Timestamp.valueOf(LocalDateTime.now()));
        return fluxoCaixaRepository.save(lancamento);
    }

    public void removerLancamento(Long id) {
        fluxoCaixaRepository.deleteById(id);
    }

    public BigDecimal obterSaldoConsolidadoDiario(LocalDate data) {
        List<Lancamento> lancamentos = fluxoCaixaRepository.findAllByUltimaAtualizacaoBetween(
                Timestamp.valueOf(data.atStartOfDay()), Timestamp.valueOf(data.atTime(LocalTime.MAX)));

        BigDecimal valorCredito = lancamentos.stream().filter(l ->
                        TipoLancamentoEnum.CREDITO.getTipo().equalsIgnoreCase(l.getTipo()))
                .map(Lancamento::getValor)
                .reduce(BigDecimal::add).get();

        BigDecimal valorDebito = lancamentos.stream().filter(l ->
                        TipoLancamentoEnum.DEBITO.getTipo().equalsIgnoreCase(l.getTipo()))
                .map(Lancamento::getValor)
                .reduce(BigDecimal::add).get();

        return valorCredito.subtract(valorDebito);
    }
}
