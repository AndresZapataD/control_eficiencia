package com.eficiencia.eficiencia.Service;

import org.springframework.stereotype.Service;

import com.eficiencia.eficiencia.Model.UsuarioModel;
import com.eficiencia.eficiencia.Repository.UsuarioRepository;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioModel login(String email, String password) {

    System.out.println("LOGIN REQUEST: " + email + " / " + password);

    UsuarioModel usuario = usuarioRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    System.out.println("USER BD: " + usuario.getEmail() + " / " + usuario.getPassword());

    if (!usuario.getPassword().equals(password)) {
        throw new RuntimeException("Contraseña incorrecta");
    }

    return usuario;
}
}