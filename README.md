<h1>
Proyecto: Desafío Foro API con Autenticación JWT
</h1>
<h2>
Descripción
</h2>
Este proyecto implementa una API para un foro utilizando Spring Boot. La seguridad está configurada mediante autenticación basada en JSON Web Tokens (JWT), ofreciendo un sistema seguro y eficiente para el acceso a los recursos de la API.
<h2>
Características principales:
</h2>
- Seguridad con JWT: Autenticación y autorización utilizando JWT.

- Filtros de seguridad personalizados: Implementación de un filtro para la autenticación de peticiones.

- Gestor de usuarios: Validación de usuarios con credenciales codificadas mediante BCrypt.
<h2>
Tecnologías utilizadas
</h2>
- Java 17

- Spring Boot 3

- Spring Security

- Jakarta Servlet API

- JSON Web Tokens (JWT)

- BCrypt

- Maven
<h2>
Estructura del proyecto
</h2>
Paquete principal:

- infra.security

- JWTAuthenticationFilter: Filtro personalizado que valida los tokens JWT en cada petición.

- JwtUtil: Clase para la generación y validación de tokens JWT.

- SecurityConfig: Configuración de seguridad para Spring Security.
<h2>
Configuración y despliegue
</h2>
Requisitos previos

1. Java: Asegúrate de tener JDK 17 instalado.

2. Maven: Instala Maven para gestionar las dependencias.

3. IDE recomendado: IntelliJ IDEA o Eclipse.

Instalación

1. Clona este repositorio:

git clone https://github.com/JLM2129/desafioForo.git

2. Accede al directorio del proyecto:

cd tu_repositorio

3. Compila e instala las dependencias:

mvn clean install
<h2>
Ejecución
</h2>
1. Levanta la aplicación:

- mvn spring-boot:run

2. La API estará disponible en http://localhost:8080.

Endpoints principales

- POST /api/login: Genera un token JWT para usuarios autenticados.

- Otros endpoints protegidos requieren un token JWT válido en el encabezado Authorization (e.g., Bearer <token>).
<h2>
Uso del token JWT
</h2>
1. Autentica con el endpoint /api/login enviando credenciales válidas.

![Autenticar](https://github.com/user-attachments/assets/449ee55a-5bd7-4c05-b0bc-f318723927bb)

2. Copia el token recibido en la respuesta.
   
3. En cada petición subsiguiente, incluye el token en el encabezado Authorization:
   
![AutenticarEndpoint](https://github.com/user-attachments/assets/01ac5308-fa21-40a6-8630-84350deae32c)

Authorization: Bearer <token>
<h2>
Pruebas
</h2>
Utiliza herramientas como Postman o Insomnia.

<h2>
Contribuciones
</h2>
Si deseas contribuir, por favor sigue estos pasos:

1. Haz un fork de este repositorio.

2. Crea una rama nueva para tu función o corrección.

git checkout -b feature/nueva-funcionalidad

3. Realiza tus cambios y haz un commit.

4. Envía un pull request describiendo los cambios realizados.
<h2>
Licencia
</h2>
Este proyecto está licenciado bajo la MIT License.

Contacto

Creador: Juan Locarno
Correo electrónico: locarno777@yahoo.es
