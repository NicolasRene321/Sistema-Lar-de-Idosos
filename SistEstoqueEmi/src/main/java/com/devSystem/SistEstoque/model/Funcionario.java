package com.devSystem.SistEstoque.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codFuncionario;
    private String nomeFuncionario;
    private String cargoFuncionario;
    private String cpfFuncionario;
    private String telefoneFuncionario;
    private String situacaoFuncionario;

    @OneToMany(mappedBy = "funcionario",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Doador> doadores;

    @OneToMany(mappedBy = "funcionario",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Fabricante> fabricantes;

    @OneToMany(mappedBy = "funcionario",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<EntregaProduto> entregas;

    public Funcionario(){}

    public Funcionario(Long codFuncionario, String nomeFuncionario,
                       String cargoFuncionario, String cpfFuncionario,
                       String telefoneFuncionario, String situacaoFuncionario,
                       List<Doador> doadores, List<Fabricante> fabricantes,
                       List<EntregaProduto> entregas) {
        this.codFuncionario = codFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cargoFuncionario = cargoFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.situacaoFuncionario = situacaoFuncionario;
        this.doadores = doadores;
        this.fabricantes = fabricantes;
        this.entregas = entregas;
    }

    public Long getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Long codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public String getSituacaoFuncionario() {
        return situacaoFuncionario;
    }

    public void setSituacaoFuncionario(String situacaoFuncionario) {
        this.situacaoFuncionario = situacaoFuncionario;
    }

    public List<Doador> getDoadores() {
        return doadores;
    }

    public void setDoadores(List<Doador> doadores) {
        this.doadores = doadores;
    }

    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }

    public List<EntregaProduto> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<EntregaProduto> entregas) {
        this.entregas = entregas;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "codFuncionario=" + codFuncionario +
                ", nomeFuncionario='" + nomeFuncionario + '\'' +
                ", cargoFuncionario='" + cargoFuncionario + '\'' +
                ", cpfFuncionario='" + cpfFuncionario + '\'' +
                ", telefoneFuncionario='" + telefoneFuncionario + '\'' +
                ", situacaoFuncionario='" + situacaoFuncionario + '\'' +
                ", doadores=" + doadores +
                ", fabricantes=" + fabricantes +
                ", entregas=" + entregas +
                '}';
    }
}
