package br.com.finguest.financeiro.controller;

import br.com.finguest.financeiro.model.Lancamento;
import br.com.finguest.financeiro.service.FluxoCaixaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/financeiro")
@AllArgsConstructor
public class FluxoCaixaController {

    private final FluxoCaixaService fluxoCaixaService;

    @GetMapping
    public List<Lancamento> obterLancamento() {
        return fluxoCaixaService.obterLancamentos();
    }

    @GetMapping("/{id}")
    public Lancamento obterMovimentacaoPorId(@PathVariable Long id) {
        return fluxoCaixaService.obterLancamentoPorId(id);
    }

    @GetMapping("/consolidado")
    public BigDecimal obterConsolidadoDiario(@RequestParam LocalDate data) {
        return fluxoCaixaService.obterSaldoConsolidadoDiario(data);
    }

    @PostMapping
    public Lancamento inserirLancamento(@RequestBody Lancamento lancamento) {
        return fluxoCaixaService.inserirLancamento(lancamento);
    }

    @PutMapping
    public Lancamento atualizarLancamento(@RequestBody Lancamento lancamento) {
        return fluxoCaixaService.atualizarLancamento(lancamento);
    }

    @DeleteMapping
    public void removerLancamentoo(@RequestParam Long id) {
        fluxoCaixaService.removerLancamento(id);
    }
}
