package taller1;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Taller_1 {
	static String[] alumnos = new String[100];
    static String[] solicitudes = new String[100];
    static String[] Ingresados = new String[100];
    static String[] Rechazados = new String[100];

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

            try {

                if(opcion>7 | opcion<0) {
                    throw new IOException("opcion invalida, intente denuevo");
                }

            } catch(IOException e) {
                System.out.println(e.getMessage());    
            }


            switch (opcion) {

                case 1:
                   cargarArchivos();
                    break; 

                case 2:
                    procesarSolicitudes();
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;
            }

        } while (opcion != 7);

        s.close();
    }

    public static void cargarArchivos () {
    	
    	try {
	    	File archivoAlumnos = new File("txt/Alumnos.txt");
	        Scanner lectorAlumnos = new Scanner(archivoAlumnos);
	        cantidadAlumnos = 0;
	        
	        while (lectorAlumnos.hasNextLine()) {
	            alumnos[cantidadAlumnos] = lectorAlumnos.nextLine();
	            cantidadAlumnos++;
	        }
	        
	        File archivoSolicitudes = new File("txt/Solicitudes.txt");
	        Scanner lectorSolicitudes = new Scanner(archivoSolicitudes);
	        cantidadSolicitudes = 0;
	        while (lectorSolicitudes.hasNextLine()) {
	
	            solicitudes[cantidadSolicitudes] = lectorSolicitudes.nextLine();
	
	            cantidadSolicitudes++;
	        } 
    	 } catch (FileNotFoundException e) {
    	        System.out.println("No se encontro uno de los archivos.");
    	 }
    }
    
    
    public static void procesarSolicitudes() {
        for (int i=0; i < cantidadSolicitudes; i++) {
            for(int j=0; j < cantidadAlumnos; j++){
                if(solicitudes[i].equals(alumnos[j])){
                    Ingresados[i] = solicitudes[i];

                    String[] Partes= solicitudes[i].split("-");
                    String[] Partes2= alumnos[j].split(";");


                    if(Partes[0].equalsIgnoreCase(Partes2[0]) && Partes[1].equalsIgnoreCase(Partes2[1])){
                        Ingresados[i] = Partes2[2]+Partes2[3];
                    }else{
                        Rechazados[i] = Partes[0]+Partes[1];
                    }
                }
            }
        }
    }
}
