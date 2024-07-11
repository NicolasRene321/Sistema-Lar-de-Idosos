package com.devSystem.SistEstoque.service;

import com.devSystem.SistEstoque.dto.DoadorDTO;
import com.devSystem.SistEstoque.model.Doador;
import com.devSystem.SistEstoque.model.Funcionario;
import com.devSystem.SistEstoque.repository.DoadorRepository;
import com.devSystem.SistEstoque.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoadorService {
    private final DoadorRepository repositorioDoador;
    private final FuncionarioRepository repositorioFuncionario;

    @Autowired
    public DoadorService( DoadorRepository repositorioDoador,
                          FuncionarioRepository repositorioFuncionario){

        this.repositorioDoador = repositorioDoador;
        this.repositorioFuncionario = repositorioFuncionario;
    }

    public DoadorDTO cadastrar(DoadorDTO doadorDTO){
        Doador doador = converterParaEntity(doadorDTO);

        // verificar se tem o código do funcionário
        Long codFuncionario = doadorDTO.getCodFuncionario();
        Funcionario funcionario = repositorioFuncionario.findById(codFuncionario)
                .orElseThrow(()-> new IllegalArgumentException("O código do funcionário é obrigatório"));

        // Associar o funcionário ao Doador => chave estrangeira
        doador.setFuncionario(funcionario);

        Doador salvo = repositorioDoador.save(doador);

        DoadorDTO doadorSalvoDTO = converterParaDTO(salvo);
        doadorSalvoDTO.setCodFuncionario(codFuncionario);

        return doadorSalvoDTO;
    }

    public List<DoadorDTO> listarDoador(){
        List<Doador> doadores = repositorioDoador.findAll();
        List<DoadorDTO> doadoresDTO = new ArrayList<>();
        for( Doador doador: doadores){
            Funcionario funcionario = doador.getFuncionario();
            DoadorDTO doadorDTO = converterParaDTO(doador);
            doadoresDTO.add(doadorDTO);
        }
        return doadoresDTO;
    }

    public DoadorDTO buscarPorId(Long id) throws Exception {
        Optional<Doador> optionalDoador = repositorioDoador.findById(id);
        if(optionalDoador.isPresent()){
            return converterParaDTO(optionalDoador.get());
        }else {
            throw new Exception("Doador Não encontrado");
        }
    }

    public DoadorDTO atualizar(Long id, DoadorDTO doadorDTO) throws Exception{
        Optional<Doador> doadorOptional = repositorioDoador.findById(id);
        if (doadorOptional.isPresent()){
            Doador doador = doadorOptional.get();
            doador.setNomeDoador(doadorDTO.getNomeDoador());
            doador.setCnpjDoador(doadorDTO.getCnpjDoador());
            doador.setCpfDoador(doadorDTO.getCpfDoador());
            doador.setEnderecoDoador(doadorDTO.getEnderecoDoador());
            doador.setEmailDoador(doadorDTO.getEmailDoador());
            doador.setTelefoneDoador(doadorDTO.getTelefoneDoador());
            doador.setSituacaoDoador(doadorDTO.getSituacaoDoador());

            Long codFuncionario = doadorDTO.getCodFuncionario();
            Funcionario funcionario = repositorioFuncionario.findById(codFuncionario)
                    .orElseThrow(()-> new IllegalArgumentException("Código do funcionário não encontrado!"));

            doador.setFuncionario(funcionario);

            Doador salvo = repositorioDoador.save(doador);
            return converterParaDTO(salvo);

        }else{
            throw new Exception("Doador não encontrado");
        }
    }

    public void deletar(Long id) throws Exception{
        Optional<Doador> optionalDoador = repositorioDoador.findById(id);
        if (optionalDoador.isPresent()){
            repositorioDoador.deleteById(id);
        }else{
            throw new Exception("Doador não encontrado!");
        }
    }

    private Doador converterParaEntity(DoadorDTO doadorDTO){
        Doador doador = new Doador();
        doador.setNomeDoador(doadorDTO.getNomeDoador());
        doador.setCnpjDoador(doadorDTO.getCnpjDoador());
        doador.setCpfDoador(doadorDTO.getCpfDoador());
        doador.setEnderecoDoador(doadorDTO.getEnderecoDoador());
        doador.setEmailDoador(doadorDTO.getEmailDoador());
        doador.setTelefoneDoador(doadorDTO.getTelefoneDoador());
        doador.setSituacaoDoador(doadorDTO.getSituacaoDoador());
        return doador;
    }

    private DoadorDTO converterParaDTO(Doador doador){
        DoadorDTO doadorDTO = new DoadorDTO();
        doadorDTO.setCodDoador(doador.getCodDoador());
        doadorDTO.setNomeDoador(doador.getNomeDoador());
        doadorDTO.setCnpjDoador(doador.getCnpjDoador());
        doadorDTO.setCpfDoador(doador.getCpfDoador());
        doadorDTO.setEnderecoDoador(doador.getEnderecoDoador());
        doadorDTO.setEmailDoador(doador.getEmailDoador());
        doadorDTO.setTelefoneDoador(doador.getTelefoneDoador());
        doadorDTO.setSituacaoDoador(doador.getSituacaoDoador());

        // Verifica se existe funcionário
        Funcionario funcionario = doador.getFuncionario();
        if(funcionario != null){
            doadorDTO.setCodFuncionario(funcionario.getCodFuncionario());
        }

        return doadorDTO;
    }
}
