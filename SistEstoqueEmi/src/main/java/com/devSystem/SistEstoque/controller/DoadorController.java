package com.devSystem.SistEstoque.controller;

import com.devSystem.SistEstoque.dto.DoadorDTO;
import com.devSystem.SistEstoque.service.DoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doador")
@CrossOrigin("*")
public class DoadorController {

    private final DoadorService servicoDoador;

    @Autowired
    public DoadorController(DoadorService servicoDoador){
        this.servicoDoador = servicoDoador;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarDoador(@RequestBody DoadorDTO novoDoador){
        try{
            DoadorDTO doadorDTO = servicoDoador.cadastrar(novoDoador);
            return ResponseEntity.ok(doadorDTO);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<?>> listarDoadores(){
        try{
            List<DoadorDTO> doadores = servicoDoador.listarDoador();
            return ResponseEntity.ok(doadores);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDoadorPorId(@PathVariable Long id){
        try{
            DoadorDTO doadorDTO = servicoDoador.buscarPorId(id);
            return ResponseEntity.ok(doadorDTO);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarDoador(@PathVariable Long id, @RequestBody DoadorDTO doadorDTO){
        try{
            DoadorDTO doadorAtualizado = servicoDoador.atualizar(id, doadorDTO);
            return ResponseEntity.ok(doadorAtualizado);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDoador(@PathVariable Long id){
        try{
            servicoDoador.deletar(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
