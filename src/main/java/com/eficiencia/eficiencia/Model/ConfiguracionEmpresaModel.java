package com.eficiencia.eficiencia.Model;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "configuracion_empresa")
public class ConfiguracionEmpresaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private EmpresaModel empresa;

    private Double metaCreditosHora;

    @ManyToOne
    @JoinColumn(name = "modo_asistencia_id")
    private ModoAsistenciaModel modoAsistencia;

    private Double horasJornada;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public ConfiguracionEmpresaModel() {
    }

    public ConfiguracionEmpresaModel(Long id, EmpresaModel empresa, Double metaCreditosHora, ModoAsistenciaModel modoAsistencia, Double horasJornada, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.empresa = empresa;
        this.metaCreditosHora = metaCreditosHora;
        this.modoAsistencia = modoAsistencia;
        this.horasJornada = horasJornada;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmpresaModel getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaModel empresa) {
        this.empresa = empresa;
    }

    public Double getMetaCreditosHora() {
        return metaCreditosHora;
    }

    public void setMetaCreditosHora(Double metaCreditosHora) {
        this.metaCreditosHora = metaCreditosHora;
    }

    public ModoAsistenciaModel getModoAsistencia() {
        return modoAsistencia;
    }

    public void setModoAsistencia(ModoAsistenciaModel modoAsistencia) {
        this.modoAsistencia = modoAsistencia;
    }

    public Double getHorasJornada() {
        return horasJornada;
    }

    public void setHorasJornada(Double horasJornada) {
        this.horasJornada = horasJornada;
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
