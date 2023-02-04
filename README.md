# nisum-apiusers
## API Usuarios
### La aplicación fué construída con SpringBoot, utilizando la versión 17 de Java.
### No es necesario ejecutar el Script de Base de datos dado que se desarrolló con la tecnología *Liquibase* la cual permite pre cargar la base de datos en *H2* y que se usen los servicios rest los cuales serán detallados más adelante.
### 1. Para ejecutar la aplicación, se debe ingresar por una consola hasta la carpeta apiusuarios (carpeta dentro de la cual se encuentra el microservicio construído).
### Una vez se encuentre dentro de la carpeta por consola se debe ejecutar el comando ***mvn clean*** para hacer limpieza del Target.
### Posterior a la ejecución del clean, se procede a ejecutar el comando ***mvn install*** para hacer la instalación de las librerías que se requieran.
### Una vez se tengan las dependencias instaladas en el entorno de ejecución se debe ejecutar el comando ***./mvnw spring-boot:run*** para que la aplicación inicie su ejecución desde la consola.
### 1. Servicio de creación de usuarios
#### Tipo Post.
#### 