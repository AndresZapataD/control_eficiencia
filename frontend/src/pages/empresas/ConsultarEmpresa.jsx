import React, { useEffect, useState } from "react";
import axios from "axios";

/**
 * Vista: ConsultarEmpresa
 * -----------------------------------------
 * Esta vista permite:
 * - Listar todas las empresas
 * - Buscar empresas por nombre, NIT o ID
 * - Activar / desactivar empresas
 * 
 * Usa el DTO: EmpresaResponseDto del backend
 */

const ConsultarEmpresa = () => {

    // 🔹 Estado donde guardamos todas las empresas
    const [empresas, setEmpresas] = useState([]);

    // 🔹 Estado para el input de búsqueda
    const [busqueda, setBusqueda] = useState("");

    // 🔹 Estado de carga (UX)
    const [loading, setLoading] = useState(false);

    /**
     * 🔹 Obtener todas las empresas desde el backend
     */
    const obtenerEmpresas = async () => {
        try {
            setLoading(true);

            const response = await axios.get("http://localhost:8080/empresas");

            setEmpresas(response.data);

        } catch (error) {
            console.error("Error al obtener empresas:", error);
        } finally {
            setLoading(false);
        }
    };

    /**
     * 🔹 Buscar empresas (nombre, nit o id)
     */
    const buscarEmpresas = async () => {
        try {
            setLoading(true);

            const response = await axios.get(
                `http://localhost:8080/empresas/buscar?query=${busqueda}`
            );

            setEmpresas(response.data);

        } catch (error) {
            console.error("Error en búsqueda:", error);
        } finally {
            setLoading(false);
        }
    };

    /**
     * 🔹 Activar o desactivar empresa
     */
    const cambiarEstado = async (id) => {
        try {
            await axios.patch(`http://localhost:8080/api/empresas/${id}/estado`);

            // 🔁 Recargamos la lista después de cambiar estado
            obtenerEmpresas();

        } catch (error) {
            console.error("Error cambiando estado:", error);
        }
    };

    /**
     * 🔹 useEffect
     * Se ejecuta al cargar la vista
     */
    useEffect(() => {
        obtenerEmpresas();
    }, []);

    return (
        <div style={{ padding: "20px" }}>
            <h2>Gestión de Empresas</h2>

            {/* 🔍 Buscador */}
            <div style={{ marginBottom: "20px" }}>
                <input
                    type="text"
                    placeholder="Buscar por nombre, NIT o ID"
                    value={busqueda}
                    onChange={(e) => setBusqueda(e.target.value)}
                    style={{ marginRight: "10px", padding: "5px" }}
                />

                <button onClick={buscarEmpresas}>
                    Buscar
                </button>

                <button onClick={obtenerEmpresas} style={{ marginLeft: "10px" }}>
                    Limpiar
                </button>
            </div>

            {/* ⏳ Loading */}
            {loading && <p>Cargando empresas...</p>}

            {/* 📋 Tabla de empresas */}
            <table border="1" cellPadding="10" style={{ width: "100%" }}>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>NIT</th>
                        <th>Email</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>

                <tbody>
                    {empresas.length === 0 ? (
                        <tr>
                            <td colSpan="6">No hay empresas</td>
                        </tr>
                    ) : (
                        empresas.map((empresa) => (
                            <tr key={empresa.id}>
                                <td>{empresa.id}</td>
                                <td>{empresa.nombre}</td>
                                <td>{empresa.nit}</td>
                                <td>{empresa.email}</td>

                                {/* 🟢 Estado */}
                                <td>
                                    {empresa.activo ? "Activa" : "Inactiva"}
                                </td>

                                {/* ⚙️ Acciones */}
                                <td>
                                    <button
                                        onClick={() => cambiarEstado(empresa.id)}
                                    >
                                        {empresa.activo ? "Desactivar" : "Activar"}
                                    </button>
                                </td>
                            </tr>
                        ))
                    )}
                </tbody>
            </table>
        </div>
    );
};

export default ConsultarEmpresa;