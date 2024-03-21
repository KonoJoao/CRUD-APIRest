package com.verbena.testeAPI.controller;

import com.verbena.testeAPI.model.AuthenticationDTO;
import com.verbena.testeAPI.model.RegisterDTO;
import com.verbena.testeAPI.model.Usuario;
import com.verbena.testeAPI.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var login = new UsernamePasswordAuthenticationToken(data.nome(), data.senha());
        var auth = this.authenticationManager.authenticate(login);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody @Valid RegisterDTO data){
        if(this.usuarioRepository.findByNome(data.nome()) != null) return ResponseEntity.badRequest().build();

        String senhaCriptografada = new BCryptPasswordEncoder().encode(data.senha());

        Usuario novoUsuario = new Usuario(data.nome(), senhaCriptografada, data.permissao());

        this.usuarioRepository.save(novoUsuario);

        return ResponseEntity.ok().build();
    }

}
