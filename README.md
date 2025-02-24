# API de Usuarios con Spring Boot

Este es un proyecto de API para realizar operaciones CRUD de usuarios, desarrollado con Java y Spring Boot como parte de mi aprendizaje en estas tecnologías.

## Tecnologías utilizadas
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Instalación

1. Clonar el repositorio:
   ```sh
   git clone https://github.com/Lisandro85/api-spring-boot
   cd tu-repo
   ```

2. Configurar el proyecto y sus dependencias:
   ```sh
   mvn clean install
   ```

## Uso

### Levantar el servidor
Para iniciar la API en modo desarrollo, ejecutar:
```sh
mvn spring-boot:run
```

El servidor se ejecutará en `http://localhost:8080` por defecto.

## Endpoints principales
| Método | Endpoint         | Descripción             |
|--------|----------------|-------------------------|
| GET    | /users         | Obtener todos los usuarios |
| GET    | /users/{id}     | Obtener un usuario por ID |
| POST   | /users         | Crear un nuevo usuario |
| PUT    | /users/{id}     | Actualizar un usuario |
| DELETE | /users/{id}     | Eliminar un usuario |

## Notas
- La API usa una base de datos MySQL para almacenar los datos.
- Spring Boot se encarga de la configuración automática del entorno.
- Puedes modificar `application.properties` para cambiar la configuración de la base de datos o el puerto del servidor.

