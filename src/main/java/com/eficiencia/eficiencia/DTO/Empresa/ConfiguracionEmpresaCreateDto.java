package com.eficiencia.eficiencia.DTO.Empresa;

import java.math.BigDecimal;

public class ConfiguracionEmpresaCreateDto {
    private Long empresaId;
    private BigDecimal metaCreditosHora;
    private Integer modoasistenciaId;
    private BigDecimal horasJornada;

    public ConfiguracionEmpresaCreateDto() {
    }

    public ConfiguracionEmpresaCreateDto(Long empresaId, BigDecimal metaCreditosHora, Integer modoasistenciaId, BigDecimal horasJornada) {
        this.empresaId = empresaId;
        this.metaCreditosHora = metaCreditosHora;
        this.modoasistenciaId = modoasistenciaId;
        this.horasJornada = horasJornada;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    public BigDecimal getMetaCreditosHora() {
        return metaCreditosHora;
    }

    public void setMetaCreditosHora(BigDecimal metaCreditosHora) {
        this.metaCreditosHora = metaCreditosHora;
    }

    public Integer getModoasistenciaId() {
        return modoasistenciaId;
    }

    public void setModoasistenciaId(Integer modoasistenciaId) {
        this.modoasistenciaId = modoasistenciaId;
    }

    public BigDecimal getHorasJornada() {
        return horasJornada;
    }

    public void setHorasJornada(BigDecimal horasJornada) {
        this.horasJornada = horasJornada;
    }
}
