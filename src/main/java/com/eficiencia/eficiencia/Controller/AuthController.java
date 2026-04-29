package com.eficiencia.eficiencia.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eficiencia.eficiencia.DTO.Login.LoginRequestDto;
import com.eficiencia.eficiencia.Model.UsuarioModel;
import com.eficiencia.eficiencia.Service.AuthService;
import com.eficiencia.eficiencia.security.JwtService;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto request) {

        // 🔐 Validar usuario
        UsuarioModel usuario = authService.login(
                request.getEmail(),
                request.getPassword()
        );

        if (usuario == null) {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }

        // 🔥 Generar token
        String token = jwtService.generateToken(usuario.getEmail());

        // 📦 Respuesta estructurada
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", usuario);

        return ResponseEntity.ok(response);
    }
}