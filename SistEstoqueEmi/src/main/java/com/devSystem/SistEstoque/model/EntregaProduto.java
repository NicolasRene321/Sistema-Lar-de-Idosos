package com.devSystem.SistEstoque.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "entregas")
public class EntregaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codEntrega;
    private LocalDate dataEntrega;

    private String nomeProdutoEntrega;

    private Long quantidadeEntrega;
    private String responsavelEntrega;

    @ManyToOne
    @JoinColumn(name = "funcionario_id",
            referencedColumnName = "codFuncionario",
            nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "estoque_id",
            referencedColumnName = "codEstoque",
            nullable = false)
    private Estoque estoque;

    public EntregaProduto (){}

    public EntregaProduto(Long codEntrega, LocalDate dataEntrega,
                          String nomeProdutoEntrega, Long quantidadeEntrega,
                          String responsavelEntrega, Funcionario funcionario,
                          Estoque estoque) {

        this.codEntrega = codEntrega;
        this.dataEntrega = dataEntrega;
        this.nomeProdutoEntrega = nomeProdutoEntrega;
        this.quantidadeEntrega = quantidadeEntrega;
        this.responsavelEntrega = responsavelEntrega;
        this.funcionario = funcionario;
        this.estoque = estoque;
    }

    public Long getCodEntrega() {
        return codEntrega;
    }

    public void setCodEntrega(Long codEntrega) {
        this.codEntrega = codEntrega;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getNomeProdutoEntrega() {
        return nomeProdutoEntrega;
    }

    public void setNomeProdutoEntrega(String nomeProdutoEntrega) {
        this.nomeProdutoEntrega = nomeProdutoEntrega;
    }

    public Long getQuantidadeEntrega() {
        return quantidadeEntrega;
    }

    public void setQuantidadeEntrega(Long quantidadeEntrega) {
        this.quantidadeEntrega = quantidadeEntrega;
    }

    public String getResponsavelEntrega() {
        return responsavelEntrega;
    }

    public void setResponsavelEntrega(String responsavelEntrega) {
        this.responsavelEntrega = responsavelEntrega;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "EntregaProduto{" +
                "codEntrega=" + codEntrega +
                ", dataEntrega=" + dataEntrega +
                ", nomeProdutoEntrega='" + nomeProdutoEntrega + '\'' +
                ", quantidadeEntrega=" + quantidadeEntrega +
                ", responsavelEntrega='" + responsavelEntrega + '\'' +
                ", funcionario=" + funcionario +
                ", estoque=" + estoque +
                '}';
    }
}
