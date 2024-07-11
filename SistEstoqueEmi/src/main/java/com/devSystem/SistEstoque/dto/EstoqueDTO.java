package com.devSystem.SistEstoque.dto;

public class EstoqueDTO {
    private Long codEstoque;
    private Long codProduto;
    private String nomeProduto;
    private Long quantidadeProduto;

    public EstoqueDTO(){}

    public EstoqueDTO(Long codEstoque, Long codProduto,
                      String nomeProduto, Long quantidadeProduto) {
        this.codEstoque = codEstoque;
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public Long getCodEstoque() {
        return codEstoque;
    }

    public void setCodEstoque(Long codEstoque) {
        this.codEstoque = codEstoque;
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

    public Long getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Long quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    @Override
    public String toString() {
        return "EstoqueDTO{" +
                "codEstoque=" + codEstoque +
                ", codProduto=" + codProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", quantidadeProduto=" + quantidadeProduto +
                '}';
    }
}
