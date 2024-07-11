package com.devSystem.SistEstoque.dto;

public class FabricanteDTO {
    private Long codFabricante;
    private String nomeFabricante;
    private Long codFuncionario;

    public FabricanteDTO(){}

    public FabricanteDTO(Long codFabricante,
                         String nomeFabricante,
                         Long codFuncionario) {
        this.codFabricante = codFabricante;
        this.nomeFabricante = nomeFabricante;
        this.codFuncionario = codFuncionario;
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

    public Long getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Long codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    @Override
    public String toString() {
        return "FabricanteDTO{" +
                "codFabricante=" + codFabricante +
                ", nomeFabricante='" + nomeFabricante + '\'' +
                ", codFuncionario=" + codFuncionario +
                '}';
    }
}
