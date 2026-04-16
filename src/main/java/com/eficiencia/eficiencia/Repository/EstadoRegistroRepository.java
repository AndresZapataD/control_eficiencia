package com.eficiencia.eficiencia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eficiencia.eficiencia.Model.EstadoRegistroModel;

public interface EstadoRegistroRepository extends JpaRepository<EstadoRegistroModel, Long> {
    
}
