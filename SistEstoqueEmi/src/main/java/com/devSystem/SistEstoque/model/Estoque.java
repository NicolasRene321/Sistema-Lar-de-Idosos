package com.devSystem.SistEstoque.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "estoques")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codEstoque;
    @Column(unique = true)   // garante que seja único para cada produto
    private Long codProduto;
    private String nomeProduto;
    private Long quantidadeProduto;

    @OneToMany(mappedBy = "estoque",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<EntregaProduto> entregas;

    @OneToMany(mappedBy = "estoque",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Produto> produtos;

    public Estoque(){}

    public Estoque(Long codEstoque, Long codProduto,
                   String nomeProduto, Long quantidadeProduto,
                   List<EntregaProduto> entregas, List<Produto> produtos) {
        this.codEstoque = codEstoque;
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.entregas = entregas;
        this.produtos = produtos;
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

    public List<EntregaProduto> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<EntregaProduto> entregas) {
        this.entregas = entregas;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "codEstoque=" + codEstoque +
                ", codProduto=" + codProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", quantidadeProduto=" + quantidadeProduto +
                ", entregas=" + entregas +
                ", produtos=" + produtos +
                '}';
    }
}
