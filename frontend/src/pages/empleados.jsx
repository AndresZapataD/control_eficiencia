import React, { useEffect, useState } from "react";

import {
  Box,
  Typography,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Button
} from "@mui/material";

const Empleados = () => {

  const [empleados, setEmpleados] = useState([]);

  useEffect(() => {

    const user = JSON.parse(localStorage.getItem("user"));
    const empresaId = user?.empresaId;

    fetch(`http://localhost:8080/api/empleados/empresa/${empresaId}`)
      .then(res => res.json())
      .then(data => setEmpleados(data))
      .catch(error => console.error(error));

  }, []);

  return (
    <Box>

      <Box 
        sx={{ 
          display: "flex", 
          justifyContent: "space-between",
          mb: 3
        }}
      >
        <Typography variant="h4">
          Empleados
        </Typography>

        <Button 
          variant="contained"
          color="primary"
        >
          Crear Empleado
        </Button>
      </Box>

      <TableContainer component={Paper}>
        <Table>

          <TableHead>
            <TableRow>
              <TableCell>Nombre</TableCell>
              <TableCell>Email</TableCell>
              <TableCell>Cargo</TableCell>
              <TableCell>Acciones</TableCell>
            </TableRow>
          </TableHead>

          <TableBody>
            {empleados.map((empleado) => (
              <TableRow key={empleado.id}>

                <TableCell>
                  {empleado.nombre}
                </TableCell>

                <TableCell>
                  {empleado.email}
                </TableCell>

                <TableCell>
                  {empleado.cargo}
                </TableCell>

                <TableCell>
                  <Button size="small">
                    Editar
                  </Button>
                </TableCell>

              </TableRow>
            ))}
          </TableBody>

        </Table>
      </TableContainer>

    </Box>
  );
};

export default Empleados;