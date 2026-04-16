package com.eficiencia.eficiencia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eficiencia.eficiencia.Model.TipoAsistenciaModel;

public interface TipoAsistenciaRepository extends JpaRepository<TipoAsistenciaModel, Long> {
    
}
