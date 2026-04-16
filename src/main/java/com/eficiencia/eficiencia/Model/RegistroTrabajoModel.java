package com.eficiencia.eficiencia.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro_trabajo")
public class RegistroTrabajoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private EmpleadoModel empleado;

    @ManyToOne
    @JoinColumn(name = "subtarea_id")
    private SubTareaModel subtarea;

    private LocalDate fecha;

    private Integer cantidad;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoRegistroModel estado;

    @ManyToOne
    @JoinColumn(name = "validado_por")
    private UsuarioModel validadoPor;

    private LocalDateTime fechaValidacion;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public RegistroTrabajoModel() {
    }

    public RegistroTrabajoModel(Long id, EmpleadoModel empleado, SubTareaModel subtarea, LocalDate fecha, Integer cantidad, String observaciones, EstadoRegistroModel estado, UsuarioModel validadoPor, LocalDateTime fechaValidacion, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.empleado = empleado;
        this.subtarea = subtarea;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
        this.estado = estado;
        this.validadoPor = validadoPor;
        this.fechaValidacion = fechaValidacion;
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

    public SubTareaModel getSubtarea() {
        return subtarea;
    }

    public void setSubtarea(SubTareaModel subtarea) {
        this.subtarea = subtarea;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstadoRegistroModel getEstado() {
        return estado;
    }

    public void setEstado(EstadoRegistroModel estado) {
        this.estado = estado;
    }

    public UsuarioModel getValidadoPor() {
        return validadoPor;
    }

    public void setValidadoPor(UsuarioModel validadoPor) {
        this.validadoPor = validadoPor;
    }

    public LocalDateTime getFechaValidacion() {
        return fechaValidacion;
    }

    public void setFechaValidacion(LocalDateTime fechaValidacion) {
        this.fechaValidacion = fechaValidacion;
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
