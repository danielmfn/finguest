package br.com.finguest.financeiro.enums;

public enum TipoLancamentoEnum {
    DEBITO("DÉBITO"),
    CREDITO("CRÉDITO");

    private final String tipo;

    TipoLancamentoEnum(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
