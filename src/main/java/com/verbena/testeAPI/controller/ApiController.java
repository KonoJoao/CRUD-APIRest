package com.verbena.testeAPI.controller;

import com.verbena.testeAPI.model.Usuario;
import com.verbena.testeAPI.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario usuario){
            return new ResponseEntity<>(apiService.cadastrarUsuario(usuario), HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Usuario> listarUsuario(@PathVariable Long id){
        return new ResponseEntity<>(apiService.listarUsuario(id), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return new ResponseEntity<>(apiService.listarUsuarios(), HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id){
        apiService.deletarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return new ResponseEntity<>(apiService.atualizarUsuario(usuario), HttpStatus.OK);
    }

}
