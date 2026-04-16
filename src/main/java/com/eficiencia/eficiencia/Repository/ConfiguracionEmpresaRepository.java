package com.eficiencia.eficiencia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eficiencia.eficiencia.Model.ConfiguracionEmpresaModel;
import com.eficiencia.eficiencia.Model.EmpresaModel;

public interface ConfiguracionEmpresaRepository 
        extends JpaRepository<ConfiguracionEmpresaModel, Long> {

    boolean existsByEmpresa(EmpresaModel empresa);
}
