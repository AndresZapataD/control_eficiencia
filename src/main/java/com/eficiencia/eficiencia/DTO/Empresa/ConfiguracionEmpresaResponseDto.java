package com.eficiencia.eficiencia.DTO.Empresa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ConfiguracionEmpresaResponseDto {
    private Long id;
    private Long empresaId;
    private BigDecimal metaCreditosHora;
    private Integer modoasistenciaId;
    private BigDecimal horasJornada;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
