package com.eficiencia.eficiencia.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "modo_asistencia")
public class ModoAsistenciaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    public ModoAsistenciaModel() {
    }

    public ModoAsistenciaModel(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}