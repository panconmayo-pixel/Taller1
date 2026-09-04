package taller1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class taller1 {

    static String[] alumnos = new String[79];
    static String[] solicitudes = new String[79];

    static int cantidadAlumnos = 0;
    static int cantidadSolicitudes = 0;

    public static void main(String[] args) {

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
            System.out.println("Selecciona una opcion: ");

            opcion = s.nextInt();
            s.nextLine();

            switch (opcion) {

                case 1:
                    Cargar_Archivos();
                    break;               
            }

        } while (opcion != 7);

        s.close();
    }

    private static void Cargar_Archivos() {

        File Archivo = new File("alumnos.txt");
        File Archivo2 = new File("solicitudes.txt");

        try (Scanner Lector = new Scanner(Archivo)) {
            while (Lector.hasNextLine()) {
                String Linea = Lector.nextLine();
                alumnos[cantidadAlumnos] = Linea;
                cantidadAlumnos++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro Alumnos.txt");
        }
        try (Scanner Lector = new Scanner(Archivo2)) {
            while (Lector.hasNextLine()) {
                String Linea = Lector.nextLine();
                solicitudes[cantidadSolicitudes] = Linea;
                cantidadSolicitudes++;
            }
           
        } catch (FileNotFoundException e) {

            System.out.println("No se encontro Solicitudes.txt");
        }
        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println(alumnos[i]);
        }
    }
}
