package com.devSystem.SistEstoque.service;


import com.devSystem.SistEstoque.dto.FabricanteDTO;
import com.devSystem.SistEstoque.model.Fabricante;
import com.devSystem.SistEstoque.model.Funcionario;
import com.devSystem.SistEstoque.repository.FabricanteRepository;
import com.devSystem.SistEstoque.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FabricanteService {

    private final FabricanteRepository repositorioFabricante;
    private final FuncionarioRepository repositorioFuncionario;

    @Autowired
    public FabricanteService(FabricanteRepository repositorioFabricante,
                             FuncionarioRepository repositorioFuncionario){
        this.repositorioFabricante = repositorioFabricante;
        this.repositorioFuncionario = repositorioFuncionario;
    }

    public FabricanteDTO cadastrarFabricante(FabricanteDTO fabricanteDTO){
        Fabricante fabricante = converterParaEntity(fabricanteDTO);

        // recuperar o código do funcionário
        Long codFuncionario = fabricanteDTO.getCodFuncionario();
        Funcionario funcionario = repositorioFuncionario.findById(codFuncionario)
          .orElseThrow(()-> new IllegalArgumentException("código do Funcionário não encontrado!"));

        //  Associar o código do funcionário ao fabricante
        fabricante.setFuncionario(funcionario);

        Fabricante fabricanteSalvo = repositorioFabricante.save(fabricante);

        //  Atualizar o DTO com o código do funcionário
        FabricanteDTO fabricanteSalvoDTO = converterParaDTO(fabricanteSalvo);
        fabricanteSalvoDTO.setCodFuncionario(codFuncionario);

        return fabricanteSalvoDTO;
    }

    public List<FabricanteDTO> listarFabricante(){
        List<Fabricante> fabricantes = repositorioFabricante.findAll();
        List<FabricanteDTO> fabricanteDTOS = new ArrayList<>();
        for( Fabricante fabricante: fabricantes){
            FabricanteDTO fabricanteDTO = converterParaDTO(fabricante);
            fabricanteDTOS.add(fabricanteDTO);
        }
        return fabricanteDTOS;
    }

    public FabricanteDTO buscarFabricantePorId(Long id){
        Optional<Fabricante> fabricanteOptional = repositorioFabricante.findById(id);
        if(fabricanteOptional.isPresent()){
            Fabricante fabricante = fabricanteOptional.get();
            return converterParaDTO(fabricante);
        }else{
            throw new IllegalArgumentException("Código do fabricante não encontrado!");
        }
    }

    public FabricanteDTO atualizar(Long id, FabricanteDTO fabricanteDTO){
        // verfica se o fabricante existe
        Optional<Fabricante> fabricanteOptional = repositorioFabricante.findById(id);
        if(fabricanteOptional.isPresent()){
            Fabricante fabricante = fabricanteOptional.get();
            // Atualiza os dados do fabricante com base nos dados DTO recebidos
            fabricante.setNomeFabricante(fabricanteDTO.getNomeFabricante());
            // Recupera e associa o funcionário com o fabricante
            if(fabricanteDTO.getCodFabricante() != null){
                Long codFuncionario = fabricanteDTO.getCodFuncionario();
                Funcionario funcionario = repositorioFuncionario.findById(codFuncionario)
                   .orElseThrow(()-> new IllegalArgumentException("Código do funcionário não encontrado!"));

                fabricante.setFuncionario(funcionario);
            }
            // Salva e retorna o fabricante atualizado
            Fabricante fabricanteAtualizado = repositorioFabricante.save(fabricante);
            return converterParaDTO(fabricanteAtualizado);
        }else{
            throw new IllegalArgumentException("Fabricante não encontrado!");
        }
    }

    public void deletar(Long id){
        // verifica se existe o fabricante
        Optional<Fabricante> fabricanteOptional = repositorioFabricante.findById(id);
        if(fabricanteOptional.isPresent()){
            repositorioFabricante.deleteById(id);
        }else{
            throw new IllegalArgumentException("FAbricante não encontrado!");
        }
    }

    private Fabricante converterParaEntity(FabricanteDTO fabricanteDTO){
        Fabricante fabricante = new Fabricante();
        fabricante.setNomeFabricante(fabricanteDTO.getNomeFabricante());
        return fabricante;
    }

    private FabricanteDTO converterParaDTO(Fabricante fabricante){
        FabricanteDTO fabricanteDTO = new FabricanteDTO();
        fabricanteDTO.setCodFabricante(fabricante.getCodFabricante());
        fabricanteDTO.setNomeFabricante(fabricante.getNomeFabricante());

        // verifica se o funcionário está carregado do banco de dados
        Funcionario funcionario = fabricante.getFuncionario();
        if(funcionario != null){
            fabricanteDTO.setCodFuncionario(funcionario.getCodFuncionario());
        }
        return fabricanteDTO;
    }
}
