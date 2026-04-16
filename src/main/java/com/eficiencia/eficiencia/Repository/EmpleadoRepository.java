package com.eficiencia.eficiencia.Repository;

import com.eficiencia.eficiencia.Model.EmpleadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoModel, Long> {
    Optional<EmpleadoModel> findByCedula(String cedula);
    Optional<EmpleadoModel> findByCodigoBarras(String codigoBarras);
    List<EmpleadoModel> findByEmpresaId(Long empresaId);
    List<EmpleadoModel> findByActivoTrue();
    List<EmpleadoModel> findByNombreContainingIgnoreCase(String nombre);
}
