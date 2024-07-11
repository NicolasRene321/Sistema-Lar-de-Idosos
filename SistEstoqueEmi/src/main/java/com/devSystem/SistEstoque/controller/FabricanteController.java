package com.devSystem.SistEstoque.controller;

import com.devSystem.SistEstoque.dto.FabricanteDTO;
import com.devSystem.SistEstoque.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fabricante")
@CrossOrigin("*")
public class FabricanteController {

    private final FabricanteService servicoFabricante;

    @Autowired
    public FabricanteController(FabricanteService servicoFabricante){
        this.servicoFabricante = servicoFabricante;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarFabricante(@RequestBody FabricanteDTO fabricanteDTO){
        try{
            FabricanteDTO fabricanteSalvo = servicoFabricante.cadastrarFabricante(fabricanteDTO);
            return ResponseEntity.ok(fabricanteSalvo);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<FabricanteDTO>> listarFabricantes(){
        try{
            List<FabricanteDTO> fabricantes = servicoFabricante.listarFabricante();
            return ResponseEntity.ok(fabricantes);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarFabricantePorId(@PathVariable Long id){
        try{
            FabricanteDTO fabricanteDTO = servicoFabricante.buscarFabricantePorId(id);
            return ResponseEntity.ok(fabricanteDTO);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarFabricante(@PathVariable Long id,
                                                 @RequestBody FabricanteDTO fabricanteDTO){
        try{
            FabricanteDTO fabricanteAtualizado = servicoFabricante.atualizar(id, fabricanteDTO);
            return ResponseEntity.ok(fabricanteAtualizado);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarFabricante(@PathVariable Long id){
        try{
            servicoFabricante.deletar(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
