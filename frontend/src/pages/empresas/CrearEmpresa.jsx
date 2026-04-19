import {
  Container,
  Box,
  TextField,
  Button,
  Typography
} from "@mui/material";
import { useState } from "react";
import axios from "axios";

function CrearEmpresa() {
  const [empresa, setEmpresa] = useState({
    nombre: "",
    nit: "",
    direccion: "",
    telefono: "",
    email: ""
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEmpresa({ ...empresa, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    console.log("DTO a enviar:", empresa);

    // aquí llamas tu API:
    // axios.post("/api/empresas", empresa)
  };

  return (
    <Container maxWidth="sm">
      <Box sx={{ mt: 4 }}>
        <Typography variant="h4" textAlign="center" gutterBottom>
          Crear Empresa
        </Typography>

        <Box component="form" onSubmit={handleSubmit} sx={{ mt: 3 }}>
          
          <TextField
            fullWidth
            label="Nombre"
            name="nombre"
            value={empresa.nombre}
            onChange={handleChange}
            margin="normal"
          />

          <TextField
            fullWidth
            label="NIT"
            name="nit"
            value={empresa.nit}
            onChange={handleChange}
            margin="normal"
          />

          <TextField
            fullWidth
            label="Dirección"
            name="direccion"
            value={empresa.direccion}
            onChange={handleChange}
            margin="normal"
          />

          <TextField
            fullWidth
            label="Teléfono"
            name="telefono"
            value={empresa.telefono}
            onChange={handleChange}
            margin="normal"
          />

          <TextField
            fullWidth
            label="Email"
            name="email"
            value={empresa.email}
            onChange={handleChange}
            margin="normal"
          />

          <Button
            type="submit"
            variant="contained"
            fullWidth
            sx={{ mt: 3 }}
          >
            Guardar Empresa
          </Button>

        </Box>
      </Box>
    </Container>
  );
}

export default CrearEmpresa;