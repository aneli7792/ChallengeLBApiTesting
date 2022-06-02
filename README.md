# Introducción 
Este proyecto contiene la automatización de 4 casos de prueba con el objetivo de verificar el funcionamiento de los métodos principales del api https://dummy.restapiexample.com que corresponden a las funcionalidades de consultar empleados, consultar empleado según su identificación, registrar nuevos empleados y eliminar empleados existentes.

1. GET
http://dummy.restapiexample.com/api/v1/employees
2. POST
http://dummy.restapiexample.com/api/v1/create
3. GET
http://dummy.restapiexample.com/api/v1/employee/1
4. DELETE
http://dummy.restapiexample.com/api/v1/delete/2

# Software utilizado
Para realizar el proyecto se utilizaron las herramientas de
1.  Gestor de dependencias apache-maven-3.8.5
2.  Java versión: 11.0.15
3.  Framework Cucumber
4.  Framework Serenity BDD en su última versión 3.2.5
5.  Patrón de diseño ScreenPlay BDD

6.  Librería Hamcrest para realizar las validaciones de los escenarios

# Como ejecutar el proyecto
Se debe tener instalado en el ambiente en dónde se va a realizar la ejecución:
1.  La versión 11 de java
2.  Apache Maven
3.  Se abre una ventana de cmd en la raiz 
4.  Ejecutar el comando sin comillas "mvn clean verify serenity:aggregate" para generar el informe de serenity report y ver el resumen de la ejecución

# Referencias
1. http://dummy.restapiexample.com/   --Documentación del api utilizada
2. https://cucumber.io/docs/cucumber/configuration/   --Documentación de Cucumber para manejo de datos por modelos

