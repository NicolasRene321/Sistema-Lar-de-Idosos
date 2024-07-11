package com.devSystem.SistEstoque.controller;

import com.devSystem.SistEstoque.dto.FuncionarioDTO;
import com.devSystem.SistEstoque.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@CrossOrigin("*")
public class FuncionarioController {

    @Autowired
    private FuncionarioService serviceFuncionario;

    @PostMapping
    public ResponseEntity<?> cadastrarFuncionario(@RequestBody FuncionarioDTO novoFuncionario){
        try{
            FuncionarioDTO funcionario = serviceFuncionario.cadastrar(novoFuncionario);
            return ResponseEntity.ok(funcionario);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<?>> listarFuncionarios(){
        try {
            List<FuncionarioDTO> funcionarios  = serviceFuncionario.listarFuncionario();
            return ResponseEntity.ok(funcionarios);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarFuncionarioPorId(@PathVariable Long id){
        try{
            FuncionarioDTO funcionarioDTO = serviceFuncionario.buscarFuncionarioPorId(id);
            return ResponseEntity.ok(funcionarioDTO);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarFuncionarioPorId(@PathVariable Long id,
                                                       @RequestBody FuncionarioDTO funcionarioDTO){
        try{
            FuncionarioDTO funcionarioAtualizado = serviceFuncionario.atualizarFuncionarioPorId(id,
                    funcionarioDTO);
            return ResponseEntity.ok(funcionarioAtualizado);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarFuncionarioPorId(@PathVariable Long id){
        try{
            serviceFuncionario.deletarFuncionario(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
