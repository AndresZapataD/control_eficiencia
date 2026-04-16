package com.eficiencia.eficiencia.Repository;

import com.eficiencia.eficiencia.Model.RolUsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuarioModel, Integer> {
    Optional<RolUsuarioModel> findByNombre(String nombre);
    List<RolUsuarioModel> findByActivoTrue();
}
