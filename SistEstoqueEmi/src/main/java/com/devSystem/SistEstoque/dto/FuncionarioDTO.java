package com.devSystem.SistEstoque.dto;

public class FuncionarioDTO {
    private Long codFuncionario;
    private String nomeFuncionario;
    private String cargoFuncionario;
    private String cpfFuncionario;
    private String telefoneFuncionario;
    private String situacaoFuncionario;

    public FuncionarioDTO(){}

    public FuncionarioDTO(Long codFuncionario, String nomeFuncionario,
                          String cargoFuncionario, String cpfFuncionario,
                          String telefoneFuncionario, String situacaoFuncionario) {
        this.codFuncionario = codFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cargoFuncionario = cargoFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.situacaoFuncionario = situacaoFuncionario;
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

    @Override
    public String toString() {
        return "FuncionarioDTO{" +
                "codFuncionario=" + codFuncionario +
                ", nomeFuncionario='" + nomeFuncionario + '\'' +
                ", cargoFuncionario='" + cargoFuncionario + '\'' +
                ", cpfFuncionario='" + cpfFuncionario + '\'' +
                ", telefoneFuncionario='" + telefoneFuncionario + '\'' +
                ", situacaoFuncionario='" + situacaoFuncionario + '\'' +
                '}';
    }
}
