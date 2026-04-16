package com.eficiencia.eficiencia.Mapper.Rol;

import com.eficiencia.eficiencia.DTO.Rol.RolCreateDto;
import com.eficiencia.eficiencia.DTO.Rol.RolResponseDto;
import com.eficiencia.eficiencia.DTO.Rol.RolUpdateDto;
import com.eficiencia.eficiencia.Model.RolUsuarioModel;

public class RolMapper {

    public static RolUsuarioModel toModel(RolCreateDto dto) {
        RolUsuarioModel model = new RolUsuarioModel();
        model.setNombre(dto.getNombre());
        model.setDescripcion(dto.getDescripcion());
        model.setActivo(true);
        return model;
    }

    public static RolUsuarioModel toModel(RolUpdateDto dto, RolUsuarioModel existing) {
        if (dto.getNombre() != null) {
            existing.setNombre(dto.getNombre());
        }
        if (dto.getDescripcion() != null) {
            existing.setDescripcion(dto.getDescripcion());
        }
        if (dto.getActivo() != null) {
            existing.setActivo(dto.getActivo());
        }
        return existing;
    }

    public static RolResponseDto toResponseDto(RolUsuarioModel model) {
        RolResponseDto dto = new RolResponseDto();
        dto.setId(model.getId());
        dto.setNombre(model.getNombre());
        dto.setDescripcion(model.getDescripcion());
        dto.setActivo(model.getActivo());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }
}
