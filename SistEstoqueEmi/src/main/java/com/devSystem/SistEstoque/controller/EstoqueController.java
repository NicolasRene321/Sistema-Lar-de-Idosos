package com.devSystem.SistEstoque.controller;

import com.devSystem.SistEstoque.dto.EstoqueDTO;
import com.devSystem.SistEstoque.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estoque")
@CrossOrigin("*")
public class EstoqueController {

    private final EstoqueService servicoEstoque;

    @Autowired
    public EstoqueController( EstoqueService servicoEstoque){
        this.servicoEstoque = servicoEstoque;
    }

    @GetMapping
    public ResponseEntity<List<?>> listarEstoque(){
        try{
            List<EstoqueDTO> estoques = servicoEstoque.listarEstoque();
            return ResponseEntity.ok(estoques);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{nomeProduto}")
    public ResponseEntity<EstoqueDTO> buscarPorNomeProduto(@PathVariable String nomeProduto){
        try{
            Optional<EstoqueDTO> estoqueOptional = servicoEstoque.buscarEstoqueDTOporNomeProduto(nomeProduto);
            if (estoqueOptional.isPresent()){
                return ResponseEntity.ok(estoqueOptional.get());
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
