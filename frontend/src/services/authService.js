import apiClient from './api';

const AUTH_URL = '/auth';

export const loginUser = async (email, password) => {
  try {
    const response = await apiClient.post(`${AUTH_URL}/login`, { email, password });
    if (response.data.token) {
      localStorage.setItem('token', response.data.token);
      localStorage.setItem('user', JSON.stringify(response.data.user));
    }
    return response.data;
  } catch (error) {
    throw error.response?.data || { error: 'Error en la autenticación' };
  }
};

export const validateToken = async (token) => {
  try {
    const response = await apiClient.get(`${AUTH_URL}/validate`, {
      headers: { Authorization: `Bearer ${token}` },
    });
    return response.data.valid;
  } catch (error) {
    return false;
  }
};

export const logoutUser = () => {
  localStorage.removeItem('token');
  localStorage.removeItem('user');
};

export const getStoredToken = () => localStorage.getItem('token');
export const getStoredUser = () => {
  const user = localStorage.getItem('user');
  return user ? JSON.parse(user) : null;
};
