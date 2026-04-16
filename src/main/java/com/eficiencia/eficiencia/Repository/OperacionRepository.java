package com.eficiencia.eficiencia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eficiencia.eficiencia.Model.OperacionModel;

public interface OperacionRepository extends JpaRepository<OperacionModel, Long> {
    
}
