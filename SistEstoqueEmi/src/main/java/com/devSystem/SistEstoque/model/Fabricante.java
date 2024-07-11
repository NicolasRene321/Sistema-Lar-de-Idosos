package com.devSystem.SistEstoque.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fabricantes")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codFabricante;
    private String nomeFabricante;

    @ManyToOne
    @JoinColumn(name = "funcionario_id",
            referencedColumnName = "codFuncionario",
            nullable = false)
    private Funcionario funcionario;

    @OneToMany(mappedBy = "fabricante",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Produto> produtos;

    public Fabricante(){}

    public Fabricante(Long codFabricante, String nomeFabricante,
                      Funcionario funcionario, List<Produto> produtos) {
        this.codFabricante = codFabricante;
        this.nomeFabricante = nomeFabricante;
        this.funcionario = funcionario;
        this.produtos = produtos;
    }

    public Long getCodFabricante() {
        return codFabricante;
    }

    public void setCodFabricante(Long codFabricante) {
        this.codFabricante = codFabricante;
    }

    public String getNomeFabricante() {
        return nomeFabricante;
    }

    public void setNomeFabricante(String nomeFabricante) {
        this.nomeFabricante = nomeFabricante;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Fabricante{" +
                "codFabricante=" + codFabricante +
                ", nomeFabricante='" + nomeFabricante + '\'' +
                ", funcionario=" + funcionario +
                ", produtos=" + produtos +
                '}';
    }
}
