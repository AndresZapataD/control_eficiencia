import apiClient from './api';

const EMPRESAS_URL = '/empresas';

export const crearEmpresa = (empresa) => {
  return apiClient.post(EMPRESAS_URL, empresa);
};

export const obtenerEmpresas = () => {
  return apiClient.get(EMPRESAS_URL);
};

export const obtenerEmpresaPorId = (id) => {
  return apiClient.get(`${EMPRESAS_URL}/${id}`);
};

export const actualizarEmpresa = (id, empresa) => {
  return apiClient.put(`${EMPRESAS_URL}/${id}`, empresa);
};

export const eliminarEmpresa = (id) => {
  return apiClient.delete(`${EMPRESAS_URL}/${id}`);
};
