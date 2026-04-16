package com.eficiencia.eficiencia.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asistencia")
public class AsistenciaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private EmpleadoModel empleado;

    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name="tipo_id")
    private TipoAsistenciaModel tipo;
    
    @ManyToOne
    @JoinColumn(name = "registrado_por")
    private UsuarioModel registradoPor;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AsistenciaModel() {
    }

    public AsistenciaModel(Long id, EmpleadoModel empleado, LocalDateTime fechaHora, TipoAsistenciaModel tipo, UsuarioModel registradoPor, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.empleado = empleado;
        this.fechaHora = fechaHora;
        this.tipo = tipo;
        this.registradoPor = registradoPor;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmpleadoModel getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoModel empleado) {
        this.empleado = empleado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public TipoAsistenciaModel getTipo() {
        return tipo;
    }

    public void setTipo(TipoAsistenciaModel tipo) {
        this.tipo = tipo;
    }

    public UsuarioModel getRegistradoPor() {
        return registradoPor;
    }

    public void setRegistradoPor(UsuarioModel registradoPor) {
        this.registradoPor = registradoPor;
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
