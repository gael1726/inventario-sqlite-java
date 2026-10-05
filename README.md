# Gestor de inventario con SQLite y JDBC

Programa en Java de consola que administra un inventario de productos en una base de datos SQLite mediante JDBC. Crea automáticamente la base y la tabla `productos` (id, nombre y precio) si no existen, e implementa las cuatro operaciones básicas: insertar, consultar, actualizar y eliminar. Todas usan consultas parametrizadas, lo que evita la inyección SQL, y recursos que cierran las conexiones automáticamente. La consulta imprime el inventario en consola con formato de columnas.

## Tecnologías

Java 22 · Maven · SQLite · JDBC (`org.xerial:sqlite-jdbc`)

## Cómo ejecutarlo

1. Clona el repositorio y compílalo con `mvn compile`.
2. Desde el `main` de `BASE_DATOS` llama a los métodos de `InventarioBD` (`CrearTabla()`, `InsertarProducto()`, `ConsultarProducto()`, etc.).
3. Ejecuta con `mvn exec:java` o desde NetBeans.

La base de datos se crea sola en la carpeta del proyecto.

## Imágenes

![Código de InventarioBD en NetBeans](img/inventariobd.png)

