package com.devSystem.SistEstoque.dto;

import java.time.LocalDate;

public class ProdutoDTO {
    private Long codProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private Double valorProduto;
    private Long quantidadeProduto;
    private LocalDate validadeProduto;
    private Long doadorId;
    private Long fabricanteId;
    private Long funcionarioId;
    private Long estoqueId;

    public ProdutoDTO(){}

    public ProdutoDTO(Long codProduto, String nomeProduto,
              String descricaoProduto, Double valorProduto,
              Long quantidadeProduto, LocalDate validadeProduto,
              Long doadorId, Long fabricanteId,
              Long funcionarioId, Long estoqueId) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorProduto = valorProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.validadeProduto = validadeProduto;
        this.doadorId = doadorId;
        this.fabricanteId = fabricanteId;
        this.funcionarioId = funcionarioId;
        this.estoqueId = estoqueId;
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

    public Long getDoadorId() {
        return doadorId;
    }

    public void setDoadorId(Long doadorId) {
        this.doadorId = doadorId;
    }

    public Long getFabricanteId() {
        return fabricanteId;
    }

    public void setFabricanteId(Long fabricanteId) {
        this.fabricanteId = fabricanteId;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Long getEstoqueId() {
        return estoqueId;
    }

    public void setEstoqueId(Long estoqueId) {
        this.estoqueId = estoqueId;
    }

    @Override
    public String   toString() {
        return "ProdutoDTO{" +
                "codProduto=" + codProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", descricaoProduto='" + descricaoProduto + '\'' +
                ", valorProduto=" + valorProduto +
                ", quantidadeProduto=" + quantidadeProduto +
                ", validadeProduto=" + validadeProduto +
                ", doadorId=" + doadorId +
                ", fabricanteId=" + fabricanteId +
                ", funcionarioId=" + funcionarioId +
                ", estoqueId=" + estoqueId +
                '}';
    }
}
