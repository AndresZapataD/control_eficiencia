package com.eficiencia.eficiencia.DTO.Usuario;

import java.time.LocalDateTime;

public class UsuarioResponseDto {

    private Long id;
    private Long empresaId;
    private Long empleadoId;
    private String email;
    private Integer rolId;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UsuarioResponseDto() {
    }

    public UsuarioResponseDto(Long id, Long empresaId, Long empleadoId, String email,
            Integer rolId, Boolean activo, LocalDateTime fechaCreacion,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.empresaId = empresaId;
        this.empleadoId = empleadoId;
        this.email = email;
        this.rolId = rolId;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    public Long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Long empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}