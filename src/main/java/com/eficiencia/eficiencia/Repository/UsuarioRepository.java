package com.eficiencia.eficiencia.Repository;

import com.eficiencia.eficiencia.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    // LOGIN
    Optional<UsuarioModel> findByEmail(String email);

    // FILTROS
    List<UsuarioModel> findByEmpresa_Id(Long empresaId);

    List<UsuarioModel> findByEmpleado_Id(Long empleadoId);

    List<UsuarioModel> findByActivoTrue();

    List<UsuarioModel> findByRol_Id(Long rolId);
}