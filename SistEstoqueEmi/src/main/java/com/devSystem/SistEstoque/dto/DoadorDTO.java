package com.devSystem.SistEstoque.dto;

public class DoadorDTO {
    private Long codDoador;
    private String nomeDoador;
    private String cnpjDoador;
    private String cpfDoador;
    private String enderecoDoador;
    private String emailDoador;
    private String telefoneDoador;
    private String situacaoDoador;
    private Long codFuncionario;

    public DoadorDTO(){}

    public DoadorDTO(Long codDoador, String nomeDoador,
                     String cnpjDoador, String cpfDoador,
                     String enderecoDoador, String emailDoador,
                     String telefoneDoador, String situacaoDoador,
                     Long codFuncionario) {
        this.codDoador = codDoador;
        this.nomeDoador = nomeDoador;
        this.cnpjDoador = cnpjDoador;
        this.cpfDoador = cpfDoador;
        this.enderecoDoador = enderecoDoador;
        this.emailDoador = emailDoador;
        this.telefoneDoador = telefoneDoador;
        this.situacaoDoador = situacaoDoador;
        this.codFuncionario = codFuncionario;
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

    public Long getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Long codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    @Override
    public String toString() {
        return "DoadorDTO{" +
                "codDoador=" + codDoador +
                ", nomeDoador='" + nomeDoador + '\'' +
                ", cnpjDoador='" + cnpjDoador + '\'' +
                ", cpfDoador='" + cpfDoador + '\'' +
                ", enderecoDoador='" + enderecoDoador + '\'' +
                ", emailDoador='" + emailDoador + '\'' +
                ", telefoneDoador='" + telefoneDoador + '\'' +
                ", situacaoDoador='" + situacaoDoador + '\'' +
                ", codFuncionario=" + codFuncionario +
                '}';
    }

}
