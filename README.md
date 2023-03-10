# nisum-apiusers
## API Usuarios
## Los Diagramas de la solución se encuentran en la carpeta *Diagramas*.
### La aplicación fué construída con SpringBoot, utilizando la versión 17 de Java.
### No es necesario ejecutar el Script de Base de datos dado que se desarrolló con la tecnología *Liquibase* la cual permite pre cargar la base de datos en *H2* y que se usen los servicios rest los cuales serán detallados más adelante.
### Para ejecutar la aplicación, se debe ingresar por una consola hasta la carpeta *apiusuarios* (carpeta dentro de la cual se encuentra el microservicio construído).
### Una vez se encuentre dentro de la carpeta por consola se debe ejecutar el comando ***mvn clean*** para hacer limpieza del Target.
### Posterior a la ejecución del clean, se procede a ejecutar el comando ***mvn install*** para hacer la instalación de las librerías que se requieran.
### Una vez se tengan las dependencias instaladas en el entorno de ejecución se debe ejecutar el comando ***./mvnw spring-boot:run*** para que la aplicación inicie su ejecución desde la consola.
### Para ingresar a la base de datos H2, se debe hacer por un navegador web en el enlace http://127.0.0.1:8080/h2-console/
### Cabe recordar que la base de datos ya tiene 3 tablas, y una fila dentro de la tabla parámetros.
### Al traer la información pre-cargada no es necesario ejecutar el Script de creación de la base de datos. Sin embargo el Script se encuentra en la raíz con el nombre **ScriptDB.sql**
### Para ingresar a la base de datos en memoria *H2* se deben ingresar los siguientes datos:
```
Saved Settings: Generic H2 (Embedded)
Setting Name: Generic H2 (Embedded)
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
``` 
### Se debe dejar el Password vacío puesto que no se puso contraseña para esta configuración de Base de datos para facilidad de la prueba.
### 1. Servicio de creación de usuarios
#### Se recomienda hacer la prueba en Postman.
#### Tipo POST, URL: http://127.0.0.1:8080/users
#### El JSON para ejecutar la prueba de creación de usuarios es el siguiente:
```
{
  "name": "Juan Rodriguez",
  "email": "juan@rodriguez.org",
  "password": "hunter2",
  "phones": [
      {
          "number":"1234567",
          "citycode":"1",
          "countrycode":"57"
        }
  ]
}
```
### 2. Servicio de modificación de Parámetros
#### Se recomienda hacer la prueba en Postman.
#### Tipo PUT, URL: http://127.0.0.1:8080/params
#### El JSON para ejecutar la prueba de modificación del parámetro para el pattern de la contraseña es:
```
{
  "id": "PASSWORD_PATTERN",
  "newValue": "^[a-zA-Z0-9]*$"
}
```
#### Cabe resaltar que si no se modifica el Pattern de la contraseña, no hay problema, puesto que ya viene pre cargado por el *Liquibase* en *H2*.
#### Para dar de baja al servicio se debe usar la combinación de teclas ***Ctrl + C***.