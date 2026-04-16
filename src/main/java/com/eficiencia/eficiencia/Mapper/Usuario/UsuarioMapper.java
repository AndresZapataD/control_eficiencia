package com.eficiencia.eficiencia.Mapper.Usuario;

import com.eficiencia.eficiencia.DTO.Usuario.UsuarioCreateDto;
import com.eficiencia.eficiencia.DTO.Usuario.UsuarioResponseDto;
import com.eficiencia.eficiencia.DTO.Usuario.UsuarioUpdateDto;
import com.eficiencia.eficiencia.Model.UsuarioModel;

import java.time.LocalDateTime;

public class UsuarioMapper {

    public static UsuarioModel toModel(UsuarioCreateDto dto) {
        UsuarioModel model = new UsuarioModel();

        model.setEmail(dto.getEmail());
        model.setPassword(dto.getPassword());
        model.setActivo(dto.getActivo() != null ? dto.getActivo() : true);
        model.setFechaCreacion(LocalDateTime.now());
        model.setCreatedAt(LocalDateTime.now());

        // Las relaciones (empresa, empleado, rol)
        // se asignan en el servicio usando los IDs del DTO

        return model;
    }

    public static UsuarioModel toModel(UsuarioUpdateDto dto, UsuarioModel existing) {

        if (dto.getEmail() != null && !dto.getEmail().isEmpty()) {
            existing.setEmail(dto.getEmail());
        }

        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            existing.setPassword(dto.getPassword());
        }

        if (dto.getActivo() != null) {
            existing.setActivo(dto.getActivo());
        }

        existing.setUpdatedAt(LocalDateTime.now());

        // Las relaciones se actualizan en el servicio si es necesario

        return existing;
    }

    public static UsuarioResponseDto toResponseDto(UsuarioModel model) {

        UsuarioResponseDto dto = new UsuarioResponseDto();

        dto.setId(model.getId());
        dto.setEmail(model.getEmail());
        dto.setActivo(model.getActivo());
        dto.setFechaCreacion(model.getFechaCreacion());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());

        // Mapear relaciones por ID

        if (model.getEmpresa() != null) {
            dto.setEmpresaId(model.getEmpresa().getId());
        }

        if (model.getEmpleado() != null) {
            dto.setEmpleadoId(model.getEmpleado().getId());
        }

        if (model.getRol() != null) {
            dto.setRolId(model.getRol().getId());
        }

        return dto;
    }
}