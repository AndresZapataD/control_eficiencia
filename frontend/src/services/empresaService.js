import axios from "axios";

const API_URL = "http://localhost:8080/api/empresas";

export const crearEmpresa = (empresa) => {
  return axios.post(API_URL, empresa);
};