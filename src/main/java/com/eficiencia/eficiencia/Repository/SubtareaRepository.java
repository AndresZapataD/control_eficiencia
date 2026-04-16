package com.eficiencia.eficiencia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eficiencia.eficiencia.Model.SubTareaModel;

public interface SubtareaRepository extends JpaRepository<SubTareaModel, Long> {
    
}
