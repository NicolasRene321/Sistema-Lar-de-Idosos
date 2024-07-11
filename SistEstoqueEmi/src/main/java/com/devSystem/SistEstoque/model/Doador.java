package com.devSystem.SistEstoque.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doadores")
public class Doador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codDoador;
    private String nomeDoador;
    private String cnpjDoador;
    private String cpfDoador;
    private String enderecoDoador;
    private String emailDoador;
    private String telefoneDoador;
    private String situacaoDoador;

    @ManyToOne
    @JoinColumn(name = "funcionario_id",
            referencedColumnName = "codFuncionario",
            nullable = false)
    private Funcionario funcionario;

    @OneToMany(mappedBy = "doador",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Produto> produtos;

    public Doador(){}

    public Doador(Long codDoador, String nomeDoador,
                  String cnpjDoador, String cpfDoador,
                  String enderecoDoador, String emailDoador,
                  String telefoneDoador, String situacaoDoador,
                  Funcionario funcionario, List<Produto> produtos) {
        this.codDoador = codDoador;
        this.nomeDoador = nomeDoador;
        this.cnpjDoador = cnpjDoador;
        this.cpfDoador = cpfDoador;
        this.enderecoDoador = enderecoDoador;
        this.emailDoador = emailDoador;
        this.telefoneDoador = telefoneDoador;
        this.situacaoDoador = situacaoDoador;
        this.funcionario = funcionario;
        this.produtos = produtos;
    }

    public Long getCodDoador() {
        return codDoador;
    }

    public void setCodDoador(Long codDoador) {
        this.codDoador = codDoador;
    }

    public String getNomeDoador() {
        return nomeDoador;
    }

    public void setNomeDoador(String nomeDoador) {
        this.nomeDoador = nomeDoador;
    }

    public String getCnpjDoador() {
        return cnpjDoador;
    }

    public void setCnpjDoador(String cnpjDoador) {
        this.cnpjDoador = cnpjDoador;
    }

    public String getCpfDoador() {
        return cpfDoador;
    }

    public void setCpfDoador(String cpfDoador) {
        this.cpfDoador = cpfDoador;
    }

    public String getEnderecoDoador() {
        return enderecoDoador;
    }

    public void setEnderecoDoador(String enderecoDoador) {
        this.enderecoDoador = enderecoDoador;
    }

    public String getEmailDoador() {
        return emailDoador;
    }

    public void setEmailDoador(String emailDoador) {
        this.emailDoador = emailDoador;
    }

    public String getTelefoneDoador() {
        return telefoneDoador;
    }

    public void setTelefoneDoador(String telefoneDoador) {
        this.telefoneDoador = telefoneDoador;
    }

    public String getSituacaoDoador() {
        return situacaoDoador;
    }

    public void setSituacaoDoador(String situacaoDoador) {
        this.situacaoDoador = situacaoDoador;
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
        return "Doador{" +
                "codDoador=" + codDoador +
                ", nomeDoador='" + nomeDoador + '\'' +
                ", cnpjDoador='" + cnpjDoador + '\'' +
                ", cpfDoador='" + cpfDoador + '\'' +
                ", enderecoDoador='" + enderecoDoador + '\'' +
                ", emailDoador='" + emailDoador + '\'' +
                ", telefoneDoador='" + telefoneDoador + '\'' +
                ", situacaoDoador='" + situacaoDoador + '\'' +
                ", funcionario=" + funcionario +
                ", produtos=" + produtos +
                '}';
    }
}
