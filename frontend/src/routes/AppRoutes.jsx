import { HashRouter, Routes, Route, Navigate } from "react-router-dom";
import CrearEmpresa from "../pages/empresas/CrearEmpresa";

import ProtectedRoute from "./ProtectedRoute";

import Login from "../pages/Login";
import Dashboard from "../pages/Dashboard";
import Empleados from "../pages/Empleados";
import AdminLayout from "../layout/AdminLayout";

function AppRoutes() {
  return (
    <HashRouter>
      <Routes>

        <Route path="/" element={<Navigate to="/login" replace />} />

        <Route path="/login" element={<Login />} />

        <Route 
          path="/dashboard" 
          element={
            <ProtectedRoute>
              <Dashboard />
            </ProtectedRoute>
          } 
        />

        <Route element={<AdminLayout />}>
          <Route 
            path="/empresas/Crear" 
            element={
                <CrearEmpresa />
            } 
          />
        </Route>

        <Route path="*" element={<Navigate to="/login" replace />} />

      </Routes>
    </HashRouter>
  );
}

export default AppRoutes;