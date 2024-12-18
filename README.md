# App Minimarket

Una aplicación para gestionar un minimarket, desarrollada con Java y Spring Boot, enfocada en la administración de inventarios, ventas y clientes.

---

## Descripción

**App Minimarket** es una solución backend diseñada para:

- Administrar el inventario de productos.
- Gestionar las ventas y el historial de transacciones.
- Registrar y consultar información de clientes.
- Proporcionar un API REST para la interacción con sistemas externos.

El proyecto está optimizado para facilitar la gestión de operaciones en un minimarket, permitiendo integraciones futuras y expansiones.

---

## Tecnologías Utilizadas

- **Backend**: Java 17 con Spring Boot (Spring Data JPA, Spring Security, Spring Web).
- **Base de Datos**: PostgreSQL o MySQL.
- **Cliente de API**: Postman.
- **Gestor de Dependencias**: Maven.

---

## Características Principales

- **Gestión de Productos**: CRUD para administrar el inventario.
- **Gestión de Ventas**: Registro de ventas y cálculo de totales.
- **Gestión de Clientes**: Almacenamiento y consulta de datos de clientes.
- **Autenticación y Autorización**: Seguridad integrada con Spring Security.
- **API REST**: Documentación disponible para facilitar el consumo del servicio.

---

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener:

- **Java 17 o superior**.
- **Maven** instalado para gestionar dependencias.
- **PostgreSQL** o **MySQL** configurado.
- **Postman** (opcional, para probar la API).

---

## Instalación y Ejecución

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/OravlaYor/app-minimarket.git
   cd app-minimarket
   ```

2. **Configurar la base de datos**:

   - Crea una base de datos en PostgreSQL o MySQL.
   - Edita el archivo `application.properties` en `src/main/resources` con los detalles de tu base de datos:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_base_datos
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_password
     ```

3. **Compilar y ejecutar la aplicación**:

   ```bash
   mvn spring-boot:run
   ```

4. **Acceder a la API**:

   - Por defecto, la API estará disponible en `http://localhost:8080`.

---

## Endpoints Principales

### Gestión de Productos

- **GET** `/productos`: Obtiene la lista de productos.
- **POST** `/productos`: Agrega un nuevo producto al inventario.
  ```json
  {
    "nombre": "Leche",
    "precio": 1.50,
    "cantidad": 100
  }
  ```
- **PUT** `/productos/{id}`: Actualiza un producto existente.
- **DELETE** `/productos/{id}`: Elimina un producto.

### Gestión de Ventas

- **GET** `/ventas`: Consulta el historial de ventas.
- **POST** `/ventas`: Registra una nueva venta.
  ```json
  {
    "productos": [
      { "id": 1, "cantidad": 2 },
      { "id": 2, "cantidad": 1 }
    ],
    "clienteId": 3
  }
  ```

### Gestión de Clientes

- **GET** `/clientes`: Obtiene la lista de clientes.
- **POST** `/clientes`: Registra un nuevo cliente.
  ```json
  {
    "nombre": "Juan Perez",
    "email": "juan.perez@email.com"
  }
  ```

---

## Pruebas

Si has implementado pruebas, ejecuta:

```bash
mvn test
```

---

## Mejoras Futuras

- Implementar una interfaz gráfica amigable para administradores.
- Añadir integración con sistemas de pagos.
- Notificaciones automáticas para inventarios bajos.
- Soporte para reportes analíticos y gráficos.

---

## Autor

**Roy Alvarado**\
[GitHub](https://github.com/OravlaYor) | [LinkedIn](https://www.linkedin.com/in/royalvarodr/)

---

