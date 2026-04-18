    package com.eficiencia.eficiencia.DTO.Empleado;

import java.time.LocalDateTime;

public class EmpleadoCreateDto {
    private Long empresaId;
    private String codigoBarras;
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String cargo;
    private String email;
    private String direccion;
    private LocalDateTime fechaNacimiento;

    public EmpleadoCreateDto() {
    }

    public EmpleadoCreateDto(Long empresaId, String codigoBarras, String cedula, String nombre,
            String apellido, String telefono, String cargo, String email, String direccion,
            LocalDateTime fechaNacimiento) {
        this.empresaId = empresaId;
        this.codigoBarras = codigoBarras;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.cargo = cargo;
        this.email = email;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

