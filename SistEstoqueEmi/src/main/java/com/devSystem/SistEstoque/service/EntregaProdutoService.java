package com.devSystem.SistEstoque.service;


import com.devSystem.SistEstoque.dto.EntregaProdutoDTO;
import com.devSystem.SistEstoque.model.EntregaProduto;
import com.devSystem.SistEstoque.model.Estoque;
import com.devSystem.SistEstoque.model.Funcionario;
import com.devSystem.SistEstoque.repository.EntregaProdutoRepository;
import com.devSystem.SistEstoque.repository.EstoqueRepository;
import com.devSystem.SistEstoque.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EntregaProdutoService {

    private final EntregaProdutoRepository repositorioEntregaProduto;
    private final EstoqueRepository repositorioEstoque;
    private final FuncionarioRepository repositorioFuncionario;

    @Autowired
    public EntregaProdutoService(EntregaProdutoRepository repositorioEntregaProduto,
                                 EstoqueRepository repositorioEstoque,
                                 FuncionarioRepository repositorioFuncionario){

        this.repositorioEntregaProduto = repositorioEntregaProduto;
        this.repositorioEstoque = repositorioEstoque;
        this.repositorioFuncionario = repositorioFuncionario;
    }

    @Transactional
    public EntregaProdutoDTO registrarEntrega(EntregaProdutoDTO entregaProdutoDTO){
        // verificação do funcionário
        Funcionario funcionario = repositorioFuncionario.findById(entregaProdutoDTO.getFuncionarioId())
                .orElseThrow(()-> new IllegalArgumentException("Código do funcionário é obrigatório!"));

        // verificação do estoque
        Estoque estoque = repositorioEstoque.findById(entregaProdutoDTO.getEstoqueId())
                .orElseThrow(()-> new IllegalArgumentException("Código do estoque é obrigatório!"));

        // verificar se a quantidade a ser entregue está disponível no estoque
        if(estoque.getQuantidadeProduto() < entregaProdutoDTO.getQuantidadeEntrega()){
            throw new IllegalArgumentException("Quantidade desejada indisponível no estoque");
        }

        // Atualizar quantidade no estoque
        estoque.setQuantidadeProduto(estoque.getQuantidadeProduto() - entregaProdutoDTO.getQuantidadeEntrega());
        repositorioEstoque.save(estoque);

        // Registrar a entrega
        EntregaProduto entregaProduto = converterParaEntity(entregaProdutoDTO, funcionario, estoque);
        EntregaProduto entregaSalva = repositorioEntregaProduto.save(entregaProduto);

        return converterParaDTO(entregaSalva);
    }

    public List<EntregaProdutoDTO> listarEntregas(){
        List<EntregaProduto> entregas = repositorioEntregaProduto.findAll();
        List<EntregaProdutoDTO> entregaDTOS = new ArrayList<>();
        for(EntregaProduto entrega : entregas){
            entregaDTOS.add(converterParaDTO(entrega));
        }

        return entregaDTOS;
    }

    public Optional<EntregaProdutoDTO> buscarEntregaPorCodigo(Long codEntrega){
        Optional<EntregaProduto> entregaOptional = repositorioEntregaProduto.findById(codEntrega);
        if (entregaOptional.isPresent()){
            return Optional.of(converterParaDTO(entregaOptional.get()));
        }else{
            return Optional.empty();
        }
    }

    private EntregaProduto converterParaEntity(EntregaProdutoDTO entregaProdutoDTO,
                                               Funcionario funcionario, Estoque estoque){

        EntregaProduto entregaProduto = new EntregaProduto();
        entregaProduto.setDataEntrega(entregaProdutoDTO.getDataEntrega());
        entregaProduto.setNomeProdutoEntrega(entregaProdutoDTO.getNomeProdutoEntrega());
        entregaProduto.setResponsavelEntrega(entregaProdutoDTO.getResponsavelEntrega());
        entregaProduto.setQuantidadeEntrega(entregaProdutoDTO.getQuantidadeEntrega());
        entregaProduto.setFuncionario(funcionario);
        entregaProduto.setEstoque(estoque);

        return entregaProduto;
    }

    private EntregaProdutoDTO converterParaDTO(EntregaProduto entregaProduto){
        EntregaProdutoDTO entregaProdutoDTO = new EntregaProdutoDTO();
        entregaProdutoDTO.setCodEntrega(entregaProduto.getCodEntrega());
        entregaProdutoDTO.setDataEntrega(entregaProduto.getDataEntrega());
        entregaProdutoDTO.setNomeProdutoEntrega(entregaProduto.getNomeProdutoEntrega());
        entregaProdutoDTO.setResponsavelEntrega(entregaProduto.getResponsavelEntrega());
        entregaProdutoDTO.setFuncionarioId(entregaProduto.getFuncionario().getCodFuncionario());
        entregaProdutoDTO.setEstoqueId(entregaProduto.getEstoque().getCodEstoque());
        entregaProdutoDTO.setQuantidadeEntrega(entregaProduto.getQuantidadeEntrega());

        return entregaProdutoDTO;
    }
}
