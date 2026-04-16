package com.eficiencia.eficiencia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eficiencia.eficiencia.Model.EmpresaModel;

public interface EmpresaRepository extends JpaRepository<EmpresaModel, Long> {
    
}
