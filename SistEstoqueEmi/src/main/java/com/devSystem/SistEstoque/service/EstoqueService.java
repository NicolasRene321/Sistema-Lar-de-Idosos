package com.devSystem.SistEstoque.service;


import com.devSystem.SistEstoque.dto.EstoqueDTO;
import com.devSystem.SistEstoque.model.Estoque;
import com.devSystem.SistEstoque.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    private final EstoqueRepository repositorioEstoque;

    @Autowired
    public EstoqueService( EstoqueRepository repositorioEstoque){
        this.repositorioEstoque = repositorioEstoque;
    }

    public List<EstoqueDTO> listarEstoque(){
        List<Estoque> estoques =repositorioEstoque.findAll();
        List<EstoqueDTO> estoqueDTOS = new ArrayList<>();
        for (Estoque estoque: estoques){
            EstoqueDTO estoqueDTO = converterParaDTO(estoque);
            estoqueDTOS.add(estoqueDTO);
        }
        return estoqueDTOS;
    }

    public Optional<EstoqueDTO> buscarEstoqueDTOporNomeProduto(String nomeProduto){
        Optional<Estoque> estoqueOptional = repositorioEstoque.findByNomeProduto(nomeProduto);
        if(estoqueOptional.isPresent()){
            EstoqueDTO estoqueDTO = converterParaDTO(estoqueOptional.get());
            return Optional.of(estoqueDTO);
        }else{
            return Optional.empty();
        }
    }

    public Optional<Estoque> buscarPorNomeProduto(String nomeProduto){
        return repositorioEstoque.findByNomeProduto(nomeProduto);
    }

    public Estoque salvar(Estoque estoque){
        return repositorioEstoque.save(estoque);
    }

    private EstoqueDTO converterParaDTO(Estoque estoque){
        EstoqueDTO estoqueDTO = new EstoqueDTO();
        estoqueDTO.setCodEstoque(estoque.getCodEstoque());
        estoqueDTO.setCodProduto(estoque.getCodProduto());
        estoqueDTO.setNomeProduto(estoque.getNomeProduto());
        estoqueDTO.setQuantidadeProduto(estoque.getQuantidadeProduto());

        return estoqueDTO;
    }
}
