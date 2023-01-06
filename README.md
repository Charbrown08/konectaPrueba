# konectaPrueba
Prueba de Conecta
Prueba Java
Se debe crear una solución que permita:
- Consultar e insertar información en la tabla Empleado.
- Consultar e insertar información de la tabla Solicitud. Cuando se muestren 
los datos de la tabla solicitud se debe mostrar el nombre del empleado y 
no el id_empleado.
Diagrama de base de datos:
Empleado
Nombre Tipo
ID NUMBER pk
FECHA_INGRESO DATE
NOMBRE VARCHAR(50)
SALARIO NUMBER


Solicitud
Nombre Tipo
ID NUMBER pk
CODIGO VARCHAR(50)
DESCRIPCION VARCHAR(50)
RESUMEN VARCHAR(50)
ID_EMPLEADO NUMBER fk

 
Para la solución tener en cuenta:
- Usar java 8
- Usar Spring MVC o Spring Boot.
- En la capa de acceso a datos preferiblemente utilizar JPA/Hibernate.
- En el front puedes usar lo que desees, preferiblemente usar jsp, thymeleaf
o react.
- Base de datos: MySQL, Oracle, PostgreSQL, HSQLDB, H2.
- Se debe usar Maven.
La solución se debe dejar en un repositorio, con los scripts requeridos. Enviar 
documento de despliegue si se requiere.
Tener en cuenta que para la prueba se dispondrá de 5 horas.
Restricciones:
- No usar generadores de código. Sólo se puede usar spring initializr
