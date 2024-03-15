package com.verbena.testeAPI.service;

import com.verbena.testeAPI.model.Usuario;
import com.verbena.testeAPI.repository.UsuarioRepository;
import org.antlr.v4.runtime.InputMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public String cadastrarUsuario(Usuario usuario){
        try {
            System.out.println(usuario.toString());
            usuarioRepository.save(usuario);
            return "Usuário cadastrado com sucesso";
        } catch(Exception e){
            e.printStackTrace();
            return "Houve um problema no cadastro do usuário";
        }
        }

    public Usuario listarUsuario(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }


    public void deletarUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario){
        Usuario usuarioAlterado = usuarioRepository.findById(usuario.getId()).get();
        usuarioAlterado.setEmail(usuario.getEmail());
        usuarioAlterado.setNome(usuario.getNome());
        usuarioAlterado.setTelefone(usuario.getTelefone());
        return usuarioRepository.save(usuarioAlterado);
    }
}
