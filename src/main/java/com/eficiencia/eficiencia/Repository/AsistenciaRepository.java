package com.eficiencia.eficiencia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eficiencia.eficiencia.Model.AsistenciaModel;

public interface AsistenciaRepository extends JpaRepository<AsistenciaModel, Long> {
    
}
