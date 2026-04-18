import { HashRouter, Routes, Route, Navigate } from "react-router-dom";

import ProtectedRoute from "./ProtectedRoute";

import Login from "../pages/Login";
import Dashboard from "../pages/Dashboard";
import Empleados from "../pages/Empleados";

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

        <Route 
          path="/empleados" 
          element={
            <ProtectedRoute>
              <Empleados />
            </ProtectedRoute>
          } 
        />

        <Route path="*" element={<Navigate to="/login" replace />} />

      </Routes>
    </HashRouter>
  );
}

export default AppRoutes;