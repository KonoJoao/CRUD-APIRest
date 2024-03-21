package com.verbena.testeAPI.service;

import com.verbena.testeAPI.model.Usuario;
import com.verbena.testeAPI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService {
    @Autowired
    private UsuarioRepository usuarioRepository;
//    public String cadastrarUsuario(Usuario usuario){
//        try {
//            System.out.println(usuario.toString());
//            usuarioRepository.save(usuario);
//            return "Usuário cadastrado com sucesso";
//        } catch(Exception e){
//            e.printStackTrace();
//            return "Houve um problema no cadastro do usuário";
//        }
//        }

    public Usuario listarUsuario(String id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }


    public void deletarUsuario(String id){
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario){
        Usuario usuarioAlterado = usuarioRepository.findById(usuario.getId()).get();
        usuarioAlterado.setSenha(usuario.getSenha());
        usuarioAlterado.setNome(usuario.getNome());
        usuarioAlterado.setPermissao(usuario.getPermissao());
        return usuarioRepository.save(usuarioAlterado);
    }
}
