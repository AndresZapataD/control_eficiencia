import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          email,
          password,
        }),
      });

      if (!response.ok) {
        throw new Error("Credenciales incorrectas");
      }

      const data = await response.json();

      console.log("Login correcto", data);

      // ✅ Guardar usuario en localStorage
      localStorage.setItem("user", JSON.stringify(data));

      // ✅ Redirigir al dashboard
      navigate("/dashboard");

    } catch (error) {
      console.error(error);
      alert("Error al iniciar sesión");
    }
  };

  return (
    <div className="login-page">
      <div className="login-card">
        <h2>Iniciar sesión</h2>
        <form onSubmit={handleSubmit}>
          
          <label htmlFor="email">Correo electrónico</label>
          <input
            id="email"
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="correo@ejemplo.com"
            required
          />

          <label htmlFor="password">Contraseña</label>
          <input
            id="password"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="********"
            required
          />

          <button type="submit">Entrar</button>

        </form>
      </div>
    </div>
  );
}

export default Login;