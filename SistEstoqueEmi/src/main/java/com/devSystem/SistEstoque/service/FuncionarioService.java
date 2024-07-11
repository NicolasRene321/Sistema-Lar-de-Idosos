package com.devSystem.SistEstoque.service;

import com.devSystem.SistEstoque.dto.FuncionarioDTO;
import com.devSystem.SistEstoque.model.Funcionario;
import com.devSystem.SistEstoque.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private FuncionarioRepository repositorioFuncionario;

    @Autowired
    public FuncionarioService(FuncionarioRepository repositorioFuncionario){
        this.repositorioFuncionario = repositorioFuncionario;
    }

    public FuncionarioDTO cadastrar(FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = converterParaEntity(funcionarioDTO);
        Funcionario salvaFuncionario = repositorioFuncionario.save(funcionario);
        return converterParaDTO(salvaFuncionario);
    }

    public List<FuncionarioDTO> listarFuncionario(){
        List<Funcionario> funcionarios = repositorioFuncionario.findAll();
        List<FuncionarioDTO> funcionarioDTOS = new ArrayList<>();
        for (Funcionario funcionario : funcionarios){
            FuncionarioDTO funcionarioDTO = converterParaDTO(funcionario);
            funcionarioDTOS.add(funcionarioDTO);
        }
        return funcionarioDTOS;
    }

    public FuncionarioDTO buscarFuncionarioPorId(Long id) throws Exception {
        Optional<Funcionario> optionalFuncionario = repositorioFuncionario.findById(id);
        if (optionalFuncionario.isPresent()){
            return converterParaDTO(optionalFuncionario.get());
        }else {
            throw new Exception("Funcionário não encontrado!");
        }
    }

    public FuncionarioDTO atualizarFuncionarioPorId(Long id, FuncionarioDTO funcionarioDTO) throws Exception{
        Optional<Funcionario> optionalFuncionario = repositorioFuncionario.findById(id);
        if (optionalFuncionario.isPresent()){
            Funcionario funcionario = optionalFuncionario.get();
            funcionario.setNomeFuncionario(funcionarioDTO.getNomeFuncionario());
            funcionario.setCargoFuncionario(funcionarioDTO.getCargoFuncionario());
            funcionario.setCpfFuncionario(funcionarioDTO.getCpfFuncionario());
            funcionario.setTelefoneFuncionario(funcionario.getTelefoneFuncionario());
            funcionario.setSituacaoFuncionario(funcionario.getSituacaoFuncionario());

            Funcionario salvaFuncionario = repositorioFuncionario.save(funcionario);
            return converterParaDTO(salvaFuncionario);
        }else{
            throw new Exception("Funcionário não encotrado!");
        }
    }

    public void deletarFuncionario(Long id) throws Exception{
        Optional<Funcionario> optionalFuncionario = repositorioFuncionario.findById(id);
        if (optionalFuncionario.isPresent()){
            repositorioFuncionario.deleteById(id);
        }else {
            throw new Exception("Funcionário não encontrado!");
        }

    }

    private Funcionario converterParaEntity(FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = new Funcionario();
        funcionario.setNomeFuncionario(funcionarioDTO.getNomeFuncionario());
        funcionario.setCargoFuncionario(funcionarioDTO.getCargoFuncionario());
        funcionario.setCpfFuncionario(funcionarioDTO.getCpfFuncionario());
        funcionario.setTelefoneFuncionario(funcionarioDTO.getTelefoneFuncionario());
        funcionario.setSituacaoFuncionario(funcionarioDTO.getSituacaoFuncionario());
        return funcionario;
    }

    private FuncionarioDTO converterParaDTO(Funcionario funcionario){
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setCodFuncionario(funcionario.getCodFuncionario());
        funcionarioDTO.setNomeFuncionario(funcionario.getNomeFuncionario());
        funcionarioDTO.setCargoFuncionario(funcionario.getCargoFuncionario());
        funcionarioDTO.setCpfFuncionario(funcionario.getCpfFuncionario());
        funcionarioDTO.setTelefoneFuncionario(funcionario.getTelefoneFuncionario());
        funcionarioDTO.setSituacaoFuncionario(funcionario.getSituacaoFuncionario());
        return funcionarioDTO;
    }
}
