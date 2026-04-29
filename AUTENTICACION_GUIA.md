# 🔐 Guía de Autenticación - Sistema Eficiencia

## ✅ Cambios Implementados

### Backend (Spring Boot)

#### 1. **SecurityConfig.java** - Configuración de Seguridad Mejorada
- ✅ JWT Filter integrado en la cadena de filtros
- ✅ Gestión de sesiones sin estado (Stateless)
- ✅ PasswordEncoder configurado con BCrypt
- ✅ AuthenticationManager bean disponible
- ✅ Rutas públicas configuradas correctamente

#### 2. **JwtService.java** - Servicio JWT Robusto
- ✅ Clave JWT configurada vía variables de entorno
- ✅ Validación mejorada con manejo de excepciones
- ✅ Método para verificar expiración de tokens
- ✅ Soporte para claims adicionales en el token

#### 3. **JwtFilter.java** - Filtro JWT Seguro
- ✅ Validación de token antes de crear autenticación
- ✅ Manejo de errores con try-catch
- ✅ Propiedades de autoridades inicializadas correctamente

#### 4. **AuthService.java** - Servicio de Autenticación Profesional
- ✅ Contraseñas hasheadas con BCrypt
- ✅ Mensajes de error genéricos para seguridad
- ✅ Método register() para nuevo registro de usuarios
- ✅ Inyección de PasswordEncoder

#### 5. **AuthController.java** - Controlador Mejorado
- ✅ Validación de entrada
- ✅ Manejo de excepciones con HTTP status apropiados
- ✅ Endpoint `/validate` para verificar token
- ✅ Endpoint `/logout` para cerrar sesión
- ✅ Respuestas estructuradas con envoltorios de error

#### 6. **application.properties** - Configuración Externa
- ✅ Variables de entorno para credenciales sensibles
- ✅ Configuración JWT externalizada
- ✅ DDL-auto cambiado a `update` (más seguro que `create-drop`)
- ✅ Logging configurado apropiadamente

---

## 🔧 Configuración Requerida

### Variables de Entorno (producción)

```bash
# Base de datos
DB_URL=jdbc:mysql://localhost:33065/sistema_productividad
DB_USERNAME=root
DB_PASSWORD=tu_contraseña_segura

# JWT
JWT_SECRET=tu_clave_muy_larga_y_segura_minimo_32_caracteres_recomendado_64
JWT_EXPIRATION=3600000  # 1 hora en milisegundos
```

### Desarrollo Local

Los valores por defecto en `application.properties` funcionarán durante desarrollo.

---

## 📱 Frontend (React + Vite)

### Nuevos Archivos

#### 1. **api.js** - Cliente HTTP Configurado
- Interceptor para agregar token JWT automáticamente
- Interceptor para manejar errores 401
- Redirección automática a login si el token expira

#### 2. **authService.js** - Servicio de Autenticación
- `loginUser(email, password)` - Autentica usuario
- `validateToken(token)` - Valida token
- `logoutUser()` - Limpia sesión
- Funciones para obtener token y usuario desde localStorage

#### 3. **empresaService.js** - Actualizado
- Usa el cliente HTTP configurado con interceptor
- Todos los endpoints incluyen token automáticamente

---

## 🚀 Pasos de Implementación

### 1. Backend - Compilar y Probar

```bash
cd c:\Proyectos\eficiencia
mvn clean compile
mvn spring-boot:run
```

**Verificar que no hay errores de compilación**

### 2. Backend - Crear Tabla de Usuarios

```sql
-- Asegurarse de que la tabla tiene estos campos:
CREATE TABLE usuario (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,  -- Ahora almacena hash BCrypt
  nombre VARCHAR(255),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 3. Backend - Actualizar Usuario en Base de Datos

Si ya tienes usuarios, debes actualizar las contraseñas a hash BCrypt:

```bash
# Generar hash BCrypt (usar una herramienta online o código):
# Contraseña: 123456 → $2a$10$... (hash BCrypt)
```

### 4. Frontend - Instalar Dependencias

```bash
cd frontend
npm install
```

### 5. Frontend - Implementar Login

Actualizar tu componente `Login.jsx`:

```jsx
import { loginUser } from '../services/authService';
import { useNavigate } from 'react-router-dom';
import { useState } from 'react';

export default function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const data = await loginUser(email, password);
      console.log('Login exitoso:', data.user);
      navigate('/dashboard');
    } catch (err) {
      setError(err.error || 'Error en la autenticación');
    }
  };

  return (
    <form onSubmit={handleLogin}>
      <input
        type="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        placeholder="Email"
      />
      <input
        type="password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        placeholder="Contraseña"
      />
      {error && <p style={{ color: 'red' }}>{error}</p>}
      <button type="submit">Iniciar Sesión</button>
    </form>
  );
}
```

### 6. Frontend - Actualizar ProtectedRoute.jsx

```jsx
import { Navigate } from 'react-router-dom';
import { getStoredToken } from '../services/authService';

export default function ProtectedRoute({ children }) {
  const token = getStoredToken();

  if (!token) {
    return <Navigate to="/login" replace />;
  }

  return children;
}
```

### 7. Frontend - Actualizar AppRoutes.jsx

```jsx
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from '../pages/Login';
import Dashboard from '../pages/Dashboard';
import ProtectedRoute from './ProtectedRoute';

export default function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route
          path="/dashboard"
          element={
            <ProtectedRoute>
              <Dashboard />
            </ProtectedRoute>
          }
        />
        {/* Redirigir raíz a dashboard o login */}
        <Route path="/" element={<Navigate to="/dashboard" />} />
      </Routes>
    </BrowserRouter>
  );
}
```

---

## 🧪 Testing de la Autenticación

### 1. Probar Login con cURL

```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"admin@ejemplo.com","password":"123456"}'

# Respuesta esperada:
# {
#   "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
#   "user": {
#     "id": 1,
#     "email": "admin@ejemplo.com",
#     "nombre": "Administrador"
#   }
# }
```

### 2. Probar Endpoint Protegido

```bash
curl -X GET http://localhost:8080/api/empresas \
  -H "Authorization: Bearer tu_token_aqui"
```

### 3. Probar Token Expirado

El token expira en 1 hora. Para probar, cambiar `JWT_EXPIRATION` a un valor bajo:
```properties
jwt.expiration=5000  # 5 segundos
```

---

## 🛡️ Mejoras de Seguridad Implementadas

| Problema | Solución |
|----------|----------|
| ❌ Contraseñas en texto plano | ✅ BCrypt password hashing |
| ❌ JWT Filter no registrado | ✅ Integrado en SecurityFilterChain |
| ❌ Clave JWT en código | ✅ Variables de entorno |
| ❌ Sin validación de entrada | ✅ Validación en controlador |
| ❌ Mensajes de error descriptivos | ✅ Mensajes genéricos por seguridad |
| ❌ Sin manejo de excepciones | ✅ Try-catch en JwtFilter |
| ❌ Credenciales en properties | ✅ Variables de entorno |
| ❌ Sin interceptor en frontend | ✅ Interceptor automático |
| ❌ Sin validación de token expiracia | ✅ Método isTokenExpired() |

---

## 📝 Próximos Pasos Recomendados

1. **Implementar Roles y Permisos**
   - Agregar roles a tokens JWT
   - Usar `@PreAuthorize` en controladores

2. **Refresh Token**
   - Implementar refresh token para renovar sesión

3. **Rate Limiting**
   - Limitar intentos de login fallidos

4. **HTTPS en Producción**
   - Configurar SSL/TLS

5. **Audit Logging**
   - Registrar intentos de login (éxito y fallo)

---

## ❓ Preguntas Frecuentes

**P: ¿Debo resetear la base de datos?**
R: Sí, recomendable ejecutar `mvn clean` y dejar que Hibernate recree las tablas.

**P: ¿El token en localStorage es seguro?**
R: Para producción, considerar usar cookies HttpOnly. Para desarrollo está bien.

**P: ¿Cómo cambio la duración del token?**
R: Actualiza `jwt.expiration` en `application.properties`.

**P: ¿Qué pasa si alguien obtiene el token?**
R: Por eso usar HTTPS en producción y expiración corta (1 hora recomendado).

---

## 📞 Contacto

Si hay problemas, verifica:
- ✅ Servidor Spring Boot corriendo en puerto 8080
- ✅ Base de datos MySQL accesible
- ✅ Variables de entorno correctas
- ✅ Frontend corriendo en puerto 5173
- ✅ CORS habilitado para localhost:5173
