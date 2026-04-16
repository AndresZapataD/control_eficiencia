package com.eficiencia.eficiencia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eficiencia.eficiencia.Model.RegistroTrabajoModel;

public interface RegistroTrabajoRepository extends JpaRepository<RegistroTrabajoModel, Long> {
    
}
