package com.devSystem.SistEstoque.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private Double valorProduto;
    private Long quantidadeProduto;
    private LocalDate validadeProduto;

    @ManyToOne
    @JoinColumn(name = "doador_id",
            referencedColumnName = "codDoador",
            nullable = false)
    private Doador doador;

    @ManyToOne
    @JoinColumn(name = "fabricante_id",
            referencedColumnName = "codFabricante",
            nullable = false)
    private Fabricante fabricante;

    @ManyToOne
    @JoinColumn(name = "funcionario_id",
            referencedColumnName = "codFuncionario",
            nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "estoque_id",
            referencedColumnName = "codEstoque",
            nullable = true)
    private Estoque estoque;

    public Produto (){}

    public Produto(Long codProduto, String nomeProduto,
                   String descricaoProduto, Double valorProduto,
                   Long quantidadeProduto, LocalDate validadeProduto,
                   Doador doador, Fabricante fabricante,
                   Funcionario funcionario, Estoque estoque) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorProduto = valorProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.validadeProduto = validadeProduto;
        this.doador = doador;
        this.fabricante = fabricante;
        this.funcionario = funcionario;
        this.estoque = estoque;
    }

    public Long getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Long codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Long getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Long quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public LocalDate getValidadeProduto() {
        return validadeProduto;
    }

    public void setValidadeProduto(LocalDate validadeProduto) {
        this.validadeProduto = validadeProduto;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
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
        return "Produto{" +
                "codProduto=" + codProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", descricaoProduto='" + descricaoProduto + '\'' +
                ", valorProduto=" + valorProduto +
                ", quantidadeProduto=" + quantidadeProduto +
                ", validadeProduto=" + validadeProduto +
                ", doador=" + doador +
                ", fabricante=" + fabricante +
                ", funcionario=" + funcionario +
                ", estoque=" + estoque +
                '}';
    }
}
