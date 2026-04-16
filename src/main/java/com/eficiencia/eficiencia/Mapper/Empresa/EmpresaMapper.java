package com.eficiencia.eficiencia.Mapper.Empresa;

import com.eficiencia.eficiencia.DTO.Empresa.EmpresaCreateDto;
import com.eficiencia.eficiencia.DTO.Empresa.EmpresaResponseDto;
import com.eficiencia.eficiencia.DTO.Empresa.EmpresaUpdateDto;
import com.eficiencia.eficiencia.Model.EmpresaModel;

public class EmpresaMapper {

    public static EmpresaModel toModel(EmpresaCreateDto dto) {
        EmpresaModel model = new EmpresaModel();
        model.setNombre(dto.getNombre());
        model.setNit(dto.getNit());
        model.setDireccion(dto.getDireccion());
        model.setTelefono(dto.getTelefono());
        model.setEmail(dto.getEmail());
        model.setActivo(true);
        return model;
    }

    public static EmpresaModel toModel(EmpresaUpdateDto dto, EmpresaModel existing) {
        if (dto.getNombre() != null) {
            existing.setNombre(dto.getNombre());
        }
        if (dto.getNit() != null) {
            existing.setNit(dto.getNit());
        }
        if (dto.getDireccion() != null) {
            existing.setDireccion(dto.getDireccion());
        }
        if (dto.getTelefono() != null) {
            existing.setTelefono(dto.getTelefono());
        }
        if (dto.getEmail() != null) {
            existing.setEmail(dto.getEmail());
        }
        if (dto.getActivo() != null) {
            existing.setActivo(dto.getActivo());
        }
        return existing;
    }

    public static EmpresaResponseDto toResponseDto(EmpresaModel model) {
        EmpresaResponseDto dto = new EmpresaResponseDto();
        dto.setId(model.getId());
        dto.setNombre(model.getNombre());
        dto.setNit(model.getNit());
        dto.setDireccion(model.getDireccion());
        dto.setTelefono(model.getTelefono());
        dto.setEmail(model.getEmail());
        dto.setActivo(model.getActivo());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }
}
