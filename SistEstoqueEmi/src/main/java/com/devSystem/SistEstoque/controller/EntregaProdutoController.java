package com.devSystem.SistEstoque.controller;

import com.devSystem.SistEstoque.dto.EntregaProdutoDTO;
import com.devSystem.SistEstoque.service.EntregaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entrega")
@CrossOrigin("*")
public class EntregaProdutoController {

    private final EntregaProdutoService servicoEntregaProduto;

    @Autowired
    public EntregaProdutoController( EntregaProdutoService servicoEntregaProduto){
        this.servicoEntregaProduto = servicoEntregaProduto;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarEntrega(@RequestBody EntregaProdutoDTO novaEntrega){
        try{
            EntregaProdutoDTO entregaDTO = servicoEntregaProduto.registrarEntrega(novaEntrega);
            return ResponseEntity.ok(entregaDTO);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<?>> listarEntregas(){
        try{
            List<EntregaProdutoDTO> entregas = servicoEntregaProduto.listarEntregas();
            return ResponseEntity.ok(entregas);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{codEntrega}")
    public ResponseEntity<EntregaProdutoDTO> buscarPorCodigo(@PathVariable Long codEntrega){
        try{
            Optional<EntregaProdutoDTO> entregaOptional = servicoEntregaProduto.buscarEntregaPorCodigo(codEntrega);
            if (entregaOptional.isPresent()){
                return ResponseEntity.ok(entregaOptional.get());
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
