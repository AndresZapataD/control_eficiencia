import { HashRouter, Routes, Route, Navigate } from "react-router-dom";

import CrearEmpresa from "../pages/empresas/CrearEmpresa";
import ConsultarEmpresa from "../pages/empresas/ConsultarEmpresa";

import ProtectedRoute from "./ProtectedRoute";

import Login from "../pages/Login";
import Dashboard from "../pages/Dashboard";
import Empleados from "../pages/Empleados";
import AdminLayout from "../layout/AdminLayout";

function AppRoutes() {
  return (
    <HashRouter>
      <Routes>

        {/* 🔹 Redirección inicial */}
        <Route path="/" element={<Navigate to="/login" replace />} />

        {/* 🔹 Login */}
        <Route path="/login" element={<Login />} />

        {/* 🔹 Rutas protegidas */}
        <Route
          element={
            <ProtectedRoute>
              <AdminLayout />
            </ProtectedRoute>
          }
        >

          {/* Dashboard */}
          <Route path="/dashboard" element={<Dashboard />} />

          {/* Empresas */}
          <Route path="/empresas" element={<ConsultarEmpresa />} />
          <Route path="/empresas/crear" element={<CrearEmpresa />} />

          {/* (Opcional futuro) */}
          <Route path="/empleados" element={<Empleados />} />

        </Route>

        {/* 🔹 Ruta fallback */}
        <Route path="*" element={<Navigate to="/login" replace />} />

      </Routes>
    </HashRouter>
  );
}

export default AppRoutes;