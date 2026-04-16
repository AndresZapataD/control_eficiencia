package com.eficiencia.eficiencia.DTO.Usuario;

public class UsuarioCreateDto {

    private Long empresaId;
    private Long empleadoId;
    private String email;
    private String password;
    private Integer rolId;
    private Boolean activo;

    public UsuarioCreateDto() {
    }

    public UsuarioCreateDto(Long empresaId, Long empleadoId, String email, String password,
            Integer rolId, Boolean activo) {
        this.empresaId = empresaId;
        this.empleadoId = empleadoId;
        this.email = email;
        this.password = password;
        this.rolId = rolId;
        this.activo = activo;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    public Long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Long empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}