package com.eficiencia.eficiencia.Mapper.Empleado;

import com.eficiencia.eficiencia.DTO.Empleado.EmpleadoCreateDto;
import com.eficiencia.eficiencia.DTO.Empleado.EmpleadoResponseDto;
import com.eficiencia.eficiencia.DTO.Empleado.EmpleadoUpdateDto;
import com.eficiencia.eficiencia.Model.EmpleadoModel;
import com.eficiencia.eficiencia.Model.EmpresaModel;

public class EmpleadoMapper {

    public static EmpleadoModel toModel(EmpleadoCreateDto dto) {
        EmpleadoModel model = new EmpleadoModel();
        model.setCodigoBarras(dto.getCodigoBarras());
        model.setCedula(dto.getCedula());
        model.setNombre(dto.getNombre());
        model.setApellido(dto.getApellido());
        model.setTelefono(dto.getTelefono());
        model.setCargo(dto.getCargo());
        model.setEmail(dto.getEmail());
        model.setDireccion(dto.getDireccion());
        model.setFechaNacimiento(dto.getFechaNacimiento());
        model.setActivo(true);
        
        // Set empresa if provided
        if (dto.getEmpresaId() != null) {
            EmpresaModel empresa = new EmpresaModel();
            empresa.setId(dto.getEmpresaId());
            model.setEmpresa(empresa);
        }
        
        return model;
    }

    public static EmpleadoModel toModel(EmpleadoUpdateDto dto, EmpleadoModel existing) {
        if (dto.getCodigoBarras() != null) {
            existing.setCodigoBarras(dto.getCodigoBarras());
        }
        if (dto.getCedula() != null) {
            existing.setCedula(dto.getCedula());
        }
        if (dto.getNombre() != null) {
            existing.setNombre(dto.getNombre());
        }
        if (dto.getApellido() != null) {
            existing.setApellido(dto.getApellido());
        }
        if (dto.getTelefono() != null) {
            existing.setTelefono(dto.getTelefono());
        }
        if (dto.getCargo() != null) {
            existing.setCargo(dto.getCargo());
        }
        if (dto.getEmail() != null) {
            existing.setEmail(dto.getEmail());
        }
        if (dto.getDireccion() != null) {
            existing.setDireccion(dto.getDireccion());
        }
        if (dto.getFechaNacimiento() != null) {
            existing.setFechaNacimiento(dto.getFechaNacimiento());
        }
        if (dto.getActivo() != null) {
            existing.setActivo(dto.getActivo());
        }
        if (dto.getEmpresaId() != null) {
            EmpresaModel empresa = new EmpresaModel();
            empresa.setId(dto.getEmpresaId());
            existing.setEmpresa(empresa);
        }
        
        return existing;
    }

    public static EmpleadoResponseDto toResponseDto(EmpleadoModel model) {
        EmpleadoResponseDto dto = new EmpleadoResponseDto();
        dto.setId(model.getId());
        dto.setCodigoBarras(model.getCodigoBarras());
        dto.setCedula(model.getCedula());
        dto.setNombre(model.getNombre());
        dto.setApellido(model.getApellido());
        dto.setTelefono(model.getTelefono());
        dto.setCargo(model.getCargo());
        dto.setEmail(model.getEmail());
        dto.setDireccion(model.getDireccion());
        dto.setFechaNacimiento(model.getFechaNacimiento());
        dto.setActivo(model.getActivo());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        
        if (model.getEmpresa() != null) {
            dto.setEmpresaId(model.getEmpresa().getId());
        }
        
        return dto;
    }
}
