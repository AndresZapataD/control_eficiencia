package com.eficiencia.eficiencia.DTO.Empresa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmpresaCreateDto {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El NIT es obligatorio")
    private String nit;
    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;
    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;
    @Email(message = "El email debe ser válido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    public EmpresaCreateDto() {
    }

    public EmpresaCreateDto(String nombre, String nit, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
