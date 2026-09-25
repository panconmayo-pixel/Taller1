# Taller 01:"El grupo de POO"

## Descripción del proyecto
Este proyecto busca crear un sistema que controle el ingreso de estudiantes al grupo de WhatsApp de POO. Para esto, se verifica que las personas que solicitan ingresar estén registradas oficialmente en el curso, ya sea en el paralelo C1 o C2.
Para realizar esta verificación se utilizan dos archivos `Alumnos.txt`, que contiene los datos de los estudiantes inscritos, y `Solicitudes.txt`, que contiene los nombres de las personas que solicitaron ingresar al grupo.

## Integrantes
• Nombre: Catalina Fica | RUT: 21.779.663-6 | Usuario GitHub: panconmayo-pixel (https://github.com/panconmayo-pixel) | Carrera: Ingeniería Civil en Computación e Informática

•Nombre: Valentina Castillo | RUT: 15.166.692-2 | Usuario GitHub:  valentinacastillo02-hash(https://(https://github.com/valentinacastillo02-hash) | Carrera: Ingeniería en tecnologias de informaciòn

## Desiciones tecnicas 

Se utilizaron arreglos estáticos para almacenar la información de los alumnos, solicitudes, personas ingresadas y rechazadas.
Para leer y modificar los archivos se utilizaron las clases `Scanner`, `File`, `FileWriter` y `BufferedWriter`.
El programa está dividido en diferentes métodos, donde cada uno se encarga de una función específica, como cargar archivos, procesar solicitudes, realizar inscripciones, administrar el curso y generar estadísticas.


## Estructura del Repositorio

- `src/tarea1/taller1.java`: clase principal del programa y contiene el método `main`.
- `src/tarea1/module-info.java`: configuración del módulo.
- `Alumnos.txt`: archivo con información de los alumnos.
- `Solicitudes.txt`: archivo con información de las solicitudes.
- `ReadMe.md`: documentación del proyecto.

## Requisitos de entorno
- Java JDK.
- Eclipse IDE o un entorno compatible con Java.
- Los archivos `Alumnos.txt` y `Solicitudes.txt`.

## Instrucciones de Compilación y Ejecución

1. Abrir el proyecto en Eclipse.
2. Verificar que los archivos `Alumnos.txt` y `Solicitudes.txt` estén disponibles.
3. Abrir la clase `taller1.java`.
4. Ejecutar el programa como una aplicación Java.
5. Seleccionar una opción del menú principal.
6. Para finalizar el programa, seleccionar la opción `7) Salir`.

## Manejo de Casos Borde y Validaciones

El programa valida diferentes situaciones para evitar errores durante su ejecución. Entre ellas:
- Verifica que los datos ingresados no estén vacíos.
- Evita registrar estudiantes con un RUT que ya se encuentre registrado.
- Valida que el paralelo ingresado sea `C1` o `C2`.
- Comprueba que los estudiantes de las solicitudes estén registrados en la lista oficial.
- Controla solicitudes duplicadas.
- Permite identificar solicitudes rechazadas y aceptadas.