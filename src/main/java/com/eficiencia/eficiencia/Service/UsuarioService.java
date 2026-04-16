package com.eficiencia.eficiencia.Service;

import com.eficiencia.eficiencia.DTO.Usuario.UsuarioCreateDto;
import com.eficiencia.eficiencia.DTO.Usuario.UsuarioResponseDto;
import com.eficiencia.eficiencia.DTO.Usuario.UsuarioUpdateDto;
import com.eficiencia.eficiencia.Mapper.Usuario.UsuarioMapper;
import com.eficiencia.eficiencia.Model.EmpresaModel;
import com.eficiencia.eficiencia.Model.EmpleadoModel;
import com.eficiencia.eficiencia.Model.RolUsuarioModel;
import com.eficiencia.eficiencia.Model.UsuarioModel;
import com.eficiencia.eficiencia.Repository.EmpresaRepository;
import com.eficiencia.eficiencia.Repository.EmpleadoRepository;
import com.eficiencia.eficiencia.Repository.RolUsuarioRepository;
import com.eficiencia.eficiencia.Repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private RolUsuarioRepository rolUsuarioRepository;

    public UsuarioResponseDto create(UsuarioCreateDto dto) {

        // Validaciones básicas
        if (dto.getEmail() == null || dto.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede ser nulo o vacío");
        }

        if (dto.getPassword() == null || dto.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía");
        }

        // Buscar entidades relacionadas
        EmpresaModel empresa = null;
        if (dto.getEmpresaId() != null) {
            empresa = empresaRepository.findById(dto.getEmpresaId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Empresa no encontrada con ID: " + dto.getEmpresaId()));
        }

        EmpleadoModel empleado = null;
        if (dto.getEmpleadoId() != null) {
            empleado = empleadoRepository.findById(dto.getEmpleadoId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Empleado no encontrado con ID: " + dto.getEmpleadoId()));
        }

        RolUsuarioModel rol = null;
        if (dto.getRolId() != null) {
            rol = rolUsuarioRepository.findById(dto.getRolId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Rol no encontrado con ID: " + dto.getRolId()));
        }

        // Mapear DTO a modelo
        UsuarioModel model = UsuarioMapper.toModel(dto);
        model.setEmpresa(empresa);
        model.setEmpleado(empleado);
        model.setRol(rol);

        // Guardar
        UsuarioModel saved = usuarioRepository.save(model);

        // Retornar respuesta
        return UsuarioMapper.toResponseDto(saved);
    }

    public UsuarioResponseDto update(Long id, UsuarioUpdateDto dto) {

        UsuarioModel existing = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Usuario no encontrado con ID: " + id));

        // Validaciones
        if (dto.getEmail() != null && dto.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede ser vacío");
        }

        if (dto.getPassword() != null && dto.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser vacía");
        }

        // Relaciones
        if (dto.getEmpresaId() != null) {
            EmpresaModel empresa = empresaRepository.findById(dto.getEmpresaId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Empresa no encontrada con ID: " + dto.getEmpresaId()));
            existing.setEmpresa(empresa);
        }

        if (dto.getEmpleadoId() != null) {
            EmpleadoModel empleado = empleadoRepository.findById(dto.getEmpleadoId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Empleado no encontrado con ID: " + dto.getEmpleadoId()));
            existing.setEmpleado(empleado);
        }

        if (dto.getRolId() != null) {
            RolUsuarioModel rol = rolUsuarioRepository.findById(dto.getRolId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Rol no encontrado con ID: " + dto.getRolId()));
            existing.setRol(rol);
        }

        UsuarioModel updated = UsuarioMapper.toModel(dto, existing);

        UsuarioModel saved = usuarioRepository.save(updated);

        return UsuarioMapper.toResponseDto(saved);
    }

    public UsuarioResponseDto findById(Long id) {
        UsuarioModel model = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Usuario no encontrado con ID: " + id));

        return UsuarioMapper.toResponseDto(model);
    }

    public List<UsuarioResponseDto> findAll() {
        List<UsuarioModel> models = usuarioRepository.findAll();

        return models.stream()
                .map(UsuarioMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {

        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException(
                    "Usuario no encontrado con ID: " + id);
        }

        usuarioRepository.deleteById(id);
    }
}