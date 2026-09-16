package taller1;


import java.io.File;  
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class borradortaller1 {
	
    static String[] alumnos = new String[100];
    static String[] apellidos = new String[100];
    static String[] rutAlumno = new String[100];
    static String[] paraleloAlumno = new String[100];

    static String[] nombresSolicitudes = new String[100];
    static String[] apellidosSolicitudes = new String[100];

    static String[] nombresAdmitidos = new String[100];
    static String[] apellidosAdmitidos = new String[100];
    static String[] rutAdmitidos = new String[100];
    static String[] paraleloAdmitidos = new String[100];

    static String[] nombresRechazados = new String[100];
    static String[] apellidosRechazados = new String[100];
    static String[] rutsRechazados = new String[100];

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("===== Sistema de Control del Grupo POO =====");
            System.out.println("1) Cargar archivos (Alumnos y Solicitudes)");
            System.out.println("2) Procesar solicitudes (Filtrado automatico)");
            System.out.println("3) Inscripcion manual al grupo");
            System.out.println("4) Administracion del curso");
            System.out.println("5) Generar reportes");
            System.out.println("6) Analisis estadistico");
            System.out.println("7) Salir");
            System.out.println("Seleccione una opcion: ");

            opcion = s.nextInt();

            switch (opcion) {

                case 1:
                    CargarArchivos();
                    break;

                case 2:
                    FiltradoAutomatico();
                    break;

                case 3:
                    InscripcionManual();
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 7);

        s.close();
    }

    public static void CargarArchivos() throws IOException {
        try {
            File file = new File("src/Alumnos.txt");
            Scanner lector = new Scanner(file);

            int  contAlumno = 0;

            while (lector.hasNextLine() && contAlumno < 100) {
                String linea = lector.nextLine();
                String[] partes = linea.split(";");
                String nombre = partes[0];
                String apellido = partes[1];
                String rut = partes[2];
                String paralelo = partes[3];

                alumnos[contAlumno] = nombre;
                apellidos[contAlumno] = apellido;
                rutAlumno[contAlumno] = rut;
                paraleloAlumno[contAlumno] = paralelo;

                contAlumno++;
            }
            lector.close();

        } catch (FileNotFoundException e) {

            System.out.println("No se encontro el archivo Alumnos.txt");
        }

        try {
            File fileSolicitudes = new File("src/Solicitudes.txt");
            Scanner lectorSolicitudes = new Scanner(fileSolicitudes);

            int contSolicitudes = 0;

            while (lectorSolicitudes.hasNextLine() && contSolicitudes < 100) {

                String linea = lectorSolicitudes.nextLine();
                String[] partes = linea.split("-");

                String nombre = partes[0];
                String apellido = partes[1];

                nombresSolicitudes[contSolicitudes] = nombre;
                apellidosSolicitudes[contSolicitudes] = apellido;

                contSolicitudes++;
            }

            lectorSolicitudes.close();

            System.out.println("Archivos cargados con exito!");

        } catch (FileNotFoundException e) {

            System.out.println("No se encontro el archivo Solicitudes.txt");
        }
    }

    public static void FiltradoAutomatico() throws IOException {

        int admitidos = 0;
        int rechazados = 0;

        for (int j = 0; j < 100; j++) {

            // Si no hay más solicitudes
            if (nombresSolicitudes[j] == null) {
                break;
            }

            boolean encontrado = false;
            for (int i = 0; i < 100; i++) {

                if (alumnos[i] == null) {
                    break;
                }

                if (nombresSolicitudes[j].equals(alumnos[i])
                        && apellidosSolicitudes[j].equals(apellidos[i])) {

                    nombresAdmitidos[admitidos] = alumnos[i];
                    apellidosAdmitidos[admitidos] = apellidos[i];
                    rutAdmitidos[admitidos] = rutAlumno[i];
                    paraleloAdmitidos[admitidos] = paraleloAlumno[i];

                    admitidos++;
                    encontrado = true;

                    break;
                }
            }
            if (!encontrado) {

                nombresRechazados[rechazados] = nombresSolicitudes[j];
                apellidosRechazados[rechazados] = apellidosSolicitudes[j];

                rechazados++;
            }
        }

        System.out.println("Procesando solicitudes...");

        for (int i = 0; i < admitidos; i++) {

            System.out.println(
                    "[OK] "
                    + nombresAdmitidos[i] + " "
                    + apellidosAdmitidos[i]
                    + " -> admitido en "
                    + paraleloAdmitidos[i]
            );
        }

        for (int i = 0; i < rechazados; i++) {

            System.out.println(
                    "[RECHAZADO] "
                    + nombresRechazados[i] + " "
                    + apellidosRechazados[i]
                    + " -> no pertenece a ningun paralelo"
            );
        }

        System.out.println(
                "Resumen: "
                + admitidos + " admitidos / "
                + rechazados + " rechazados."
        );
    }

    public static void InscripcionManual() throws IOException {

        Scanner s = new Scanner(System.in);

        System.out.println("Como desea inscribir a la persona?");
        System.out.println("1) Por nombre completo");
        System.out.println("2) Por RUT");

        int opcion = s.nextInt();
        s.nextLine();

        int admitidos = 0;
        int rechazados = 0;

        if (opcion == 1) {

            System.out.println("Ingrese nombre:");
            String nombre = s.nextLine();

            System.out.println("Ingrese apellido:");
            String apellido = s.nextLine();

            boolean encontrado = false;

            for (int i = 0; i < 100; i++) {

                if (alumnos[i] == null) {
                    break;
                }

                if (nombre.equals(alumnos[i])
                        && apellido.equals(apellidos[i])) {

                    nombresAdmitidos[admitidos] = alumnos[i];
                    apellidosAdmitidos[admitidos] = apellidos[i];
                    rutAdmitidos[admitidos] = rutAlumno[i];
                    paraleloAdmitidos[admitidos] = paraleloAlumno[i];

                    admitidos++;
                    encontrado = true;

                    System.out.println(
                            "[OK] "
                            + alumnos[i] + " "
                            + apellidos[i]
                            + " -> inscrito en "
                            + paraleloAlumno[i]
                    );

                    break;
                }
            }

            if (!encontrado) {

                nombresRechazados[rechazados] = nombre;
                apellidosRechazados[rechazados] = apellido;

                rechazados++;

                System.out.println(
                        "[RECHAZADO] "
                        + nombre + " "
                        + apellido
                        + " -> no pertenece a ningun paralelo"
                );
            }
        }

        else if (opcion == 2) {

            System.out.println("Ingrese RUT:");
            String rut = s.nextLine();

            boolean encontrado = false;

            for (int i = 0; i < 100; i++) {

                if (alumnos[i] == null) {
                    break;
                }

                if (rut.equals(rutAlumno[i])) {

                    nombresAdmitidos[admitidos] = alumnos[i];
                    apellidosAdmitidos[admitidos] = apellidos[i];
                    rutAdmitidos[admitidos] = rutAlumno[i];
                    paraleloAdmitidos[admitidos] = paraleloAlumno[i];

                    admitidos++;
                    encontrado = true;

                    System.out.println(
                            "[OK] "
                            + alumnos[i] + " "
                            + apellidos[i]
                            + " -> inscrito en "
                            + paraleloAlumno[i]
                    );

                    break;
                }
            }

            if (!encontrado) {

                rutsRechazados[rechazados] = rut;

                rechazados++;

                System.out.println(
                        "[RECHAZADO] "
                        + "Solo se dispone del RUT: "
                        + rut
                );
            }
        }

        else {

            System.out.println("Opcion invalida");
        }
    }
} 
