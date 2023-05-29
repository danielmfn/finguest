package br.com.finguest.financeiro.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB001_LANCAMENTO")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String tipo;

    @Column
    private BigDecimal valor;

    @Column
    private String descricao;

    @Column(name = "ULTIMA_ATUALIZACAO")
    private Timestamp ultimaAtualizacao;
}
