package com.devSystem.SistEstoque.service;

import com.devSystem.SistEstoque.dto.ProdutoDTO;
import com.devSystem.SistEstoque.model.*;
import com.devSystem.SistEstoque.repository.DoadorRepository;
import com.devSystem.SistEstoque.repository.FabricanteRepository;
import com.devSystem.SistEstoque.repository.FuncionarioRepository;
import com.devSystem.SistEstoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repositorioProduto;
    private final EstoqueService servicoEstoque;
    private final DoadorRepository repositorioDoador;
    private final FabricanteRepository repositorioFabricante;
    private final FuncionarioRepository repositorioFuncionario;

    @Autowired
    public ProdutoService(ProdutoRepository repositorioProduto,
                          EstoqueService servicoEstoque,
                          DoadorRepository repositorioDoador,
                          FabricanteRepository repositorioFabricante,
                          FuncionarioRepository repositorioFuncionario){

        this.repositorioProduto = repositorioProduto;
        this.servicoEstoque = servicoEstoque;
        this.repositorioDoador = repositorioDoador;
        this.repositorioFabricante = repositorioFabricante;
        this.repositorioFuncionario = repositorioFuncionario;
    }

    @Transactional
    public ProdutoDTO cadastrar(ProdutoDTO novoProdutoDTO){
        Produto produto = converteParaEntity(novoProdutoDTO);

        //Verificando a associação doador e produto
        if(novoProdutoDTO.getDoadorId() != null){
            Doador doador = repositorioDoador.findById(novoProdutoDTO.getDoadorId())
                    .orElseThrow(()-> new IllegalArgumentException("O código do Doador é obrigatório!"));

            produto.setDoador(doador);
        }

        //Verificando a associação fabricante e produto
        if(novoProdutoDTO.getFabricanteId() !=null){
            Fabricante fabricante = repositorioFabricante.findById(novoProdutoDTO.getFabricanteId())
                    .orElseThrow(()-> new IllegalArgumentException("O código do fabricante é obrigatório!"));

            produto.setFabricante(fabricante);
        }

        //Verificando a associação entre funcionário e produto
        if (novoProdutoDTO.getFuncionarioId() != null){
            Funcionario funcionario = repositorioFuncionario.findById(novoProdutoDTO.getFuncionarioId())
                    .orElseThrow(()-> new IllegalArgumentException("O código do funcionário é obrigatório!"));

            produto.setFuncionario(funcionario);
        }

        //Salvar o produto na tabela produtos
        Produto produtoSalvo = repositorioProduto.save(produto);

        //Verificar se o produto existe no estoque pelo nome
        Optional<Estoque> estoqueOptional = servicoEstoque.buscarPorNomeProduto(produtoSalvo.getNomeProduto());
        if(estoqueOptional.isPresent()){
            Estoque estoque = estoqueOptional.get();
            estoque.setQuantidadeProduto(estoque.getQuantidadeProduto() + produtoSalvo.getQuantidadeProduto());
            servicoEstoque.salvar(estoque); // o estoque serviço precisa de um método para salvar o estoque

            //Atualizar o produto com o estoqueId
            produtoSalvo.setEstoque(estoque);

        }else{
            // Criar um novo produto no estoque
            Estoque novoEstoque = new Estoque();
            novoEstoque.setCodProduto(produtoSalvo.getCodProduto());
            novoEstoque.setNomeProduto(produtoSalvo.getNomeProduto());
            novoEstoque.setQuantidadeProduto(produtoSalvo.getQuantidadeProduto());
            Estoque estoqueSalvo = servicoEstoque.salvar(novoEstoque);

            // Atualizar o produto com o estoqueID
            produtoSalvo.setEstoque(estoqueSalvo);
        }
        // Salvar novamente o produto para atualizar o estoqueId
        produtoSalvo = repositorioProduto.save(produtoSalvo);

        return converteParaDTO(produtoSalvo);
    }

    public List<ProdutoDTO> listarProdutos(){
        List<Produto> produtos = repositorioProduto.findAll();
        List<ProdutoDTO> produtoDTOS = new ArrayList<>();
        for (Produto produto: produtos){
            ProdutoDTO produtoDTO = converteParaDTO(produto);
            produtoDTOS.add(produtoDTO);
        }
        return produtoDTOS;
    }

    private Produto converteParaEntity(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setCodProduto(produtoDTO.getCodProduto());
        produto.setNomeProduto(produtoDTO.getNomeProduto());
        produto.setDescricaoProduto(produtoDTO.getDescricaoProduto());
        produto.setValorProduto(produtoDTO.getValorProduto());
        produto.setQuantidadeProduto(produtoDTO.getQuantidadeProduto());
        produto.setValidadeProduto(produtoDTO.getValidadeProduto());
        return produto;
    }

    private ProdutoDTO converteParaDTO(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setCodProduto(produto.getCodProduto());
        produtoDTO.setNomeProduto(produto.getNomeProduto());
        produtoDTO.setDescricaoProduto(produto.getDescricaoProduto());
        produtoDTO.setValorProduto(produto.getValorProduto());
        produtoDTO.setQuantidadeProduto(produto.getQuantidadeProduto());
        produtoDTO.setValidadeProduto(produto.getValidadeProduto());

        if(produto.getDoador() != null){
            produtoDTO.setDoadorId(produto.getDoador().getCodDoador());
        }

        if(produto.getEstoque() != null){
            produtoDTO.setEstoqueId(produto.getEstoque().getCodEstoque());
        }

        if(produto.getFabricante() != null){
            produtoDTO.setFabricanteId(produto.getFabricante().getCodFabricante());
        }

        if(produto.getFuncionario() != null){
            produtoDTO.setFuncionarioId(produto.getFuncionario().getCodFuncionario());
        }

        return produtoDTO;
    }


}
