package com.devSystem.SistEstoque.controller;

import com.devSystem.SistEstoque.dto.ProdutoDTO;
import com.devSystem.SistEstoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

    private final ProdutoService servicoProduto;

    @Autowired
    public ProdutoController( ProdutoService servicoProduto){
        this.servicoProduto = servicoProduto;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoDTO novoProdutoDTO){
        try{
            ProdutoDTO produtoDTO = servicoProduto.cadastrar(novoProdutoDTO);
            return ResponseEntity.ok(produtoDTO);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<?>> listarProdutos(){
        try{
            List<ProdutoDTO> produtos = servicoProduto.listarProdutos();
            return ResponseEntity.ok(produtos);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
