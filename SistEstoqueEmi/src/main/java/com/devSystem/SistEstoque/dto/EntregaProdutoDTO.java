package com.devSystem.SistEstoque.dto;

import java.time.LocalDate;

public class EntregaProdutoDTO {
    private Long codEntrega;
    private LocalDate dataEntrega;
    private String nomeProdutoEntrega;
    private String responsavelEntrega;
    private Long quantidadeEntrega;
    private Long funcionarioId;
    private Long estoqueId;

    public EntregaProdutoDTO(){}

    public EntregaProdutoDTO(Long codEntrega, LocalDate dataEntrega,
                             String nomeProdutoEntrega, String responsavelEntrega,
                             Long quantidadeEntrega, Long funcionarioId, Long estoqueId) {

        this.codEntrega = codEntrega;
        this.dataEntrega = dataEntrega;
        this.nomeProdutoEntrega = nomeProdutoEntrega;
        this.responsavelEntrega = responsavelEntrega;
        this.quantidadeEntrega = quantidadeEntrega;
        this.funcionarioId = funcionarioId;
        this.estoqueId = estoqueId;
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

    public String getResponsavelEntrega() {
        return responsavelEntrega;
    }

    public void setResponsavelEntrega(String responsavelEntrega) {
        this.responsavelEntrega = responsavelEntrega;
    }

    public Long getQuantidadeEntrega() {
        return quantidadeEntrega;
    }

    public void setQuantidadeEntrega(Long quantidadeEntrega) {
        this.quantidadeEntrega = quantidadeEntrega;
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
    public String toString() {
        return "EntregaProdutoDTO{" +
                "codEntrega=" + codEntrega +
                ", dataEntrega=" + dataEntrega +
                ", nomeProdutoEntrega='" + nomeProdutoEntrega + '\'' +
                ", responsavelEntrega='" + responsavelEntrega + '\'' +
                ", quantidadeEntrega=" + quantidadeEntrega +
                ", funcionarioId=" + funcionarioId +
                ", estoqueId=" + estoqueId +
                '}';
    }
}
