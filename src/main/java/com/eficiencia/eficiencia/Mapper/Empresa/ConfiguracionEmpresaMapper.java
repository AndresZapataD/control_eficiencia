package com.eficiencia.eficiencia.Mapper.Empresa;

import com.eficiencia.eficiencia.DTO.Empresa.ConfiguracionEmpresaCreateDto;
import com.eficiencia.eficiencia.DTO.Empresa.ConfiguracionEmpresaUpdateDto;
import com.eficiencia.eficiencia.Model.ConfiguracionEmpresaModel;

public class ConfiguracionEmpresaMapper {

    public static ConfiguracionEmpresaModel toModel(ConfiguracionEmpresaCreateDto dto) {
        ConfiguracionEmpresaModel model = new ConfiguracionEmpresaModel();
        if (dto.getMetaCreditosHora() != null) {
            model.setMetaCreditosHora(dto.getMetaCreditosHora().doubleValue());
        }
        if (dto.getHorasJornada() != null) {
            model.setHorasJornada(dto.getHorasJornada().doubleValue());
        }
        return model;
    }

    public static ConfiguracionEmpresaModel toModel(ConfiguracionEmpresaUpdateDto dto, ConfiguracionEmpresaModel existing) {
        if (dto.getMetaCreditosHora() != null) {
            existing.setMetaCreditosHora(dto.getMetaCreditosHora().doubleValue());
        }
        if (dto.getHorasJornada() != null) {
            existing.setHorasJornada(dto.getHorasJornada().doubleValue());
        }
        return existing;
    }
}
