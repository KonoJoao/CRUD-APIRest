package com.verbena.testeAPI.repository;

import com.verbena.testeAPI.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    UserDetails findByNome(String nome);
}
