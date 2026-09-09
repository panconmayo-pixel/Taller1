package taller1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class taller1 {

    static String[] alumnos = new String[100];
    static String[] solicitudes = new String[100];
    static String[] Ingresados = new String[100];
    static String[] Rechazados = new String[100];
    static int cantidadIngresados = 0;
static int cantidadRechazados = 0;

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
			
			if(opcion>7 || opcion<0) {
			throw new IOException("opcion invalida, intente denuevo");
			
			
			}
		}catch(IOException  e){
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

    
    private static void procesarSolicitudes() {
        System.out.println("Procesando solicitudes...");
        for (int i=0; i < cantidadSolicitudes; i++) {
            boolean encontrado = false;
           
            String[] Partes= solicitudes[i].split("-");
            for(int j=0; j < cantidadAlumnos; j++){
                
            String[]Partes2= alumnos[j].split(";");


                if(Partes[0].equalsIgnoreCase(Partes2[0]) && Partes[1].equalsIgnoreCase(Partes2[1])){//Preguntar si el que haya un alumno en la list6a alumno significa que tiene un paralelo
                    encontrado=true;
                     if(Ingresados[0] == null){
                        Ingresados[0] = Partes2[0] + Partes2[1] +Partes2[2]+Partes2[3];
                        System.out.println(Ingresados[0]);
                        System.out.println("[OK]       "+Partes2[0]+" "+Partes2[1] +" -> admitido en " + Partes2[3]);
                        cantidadIngresados++;
                        break;
                    }
                          
                    
                    ingresaGrupo(Partes2,i);

                    break;
                }

            }

            if(!encontrado){
            rechazadoGrupo(Partes,i);

            }
        }

       
        // Aquí puedes agregar la lógica para procesar las solicitudes
}
        
    
    
    public static void ingresaGrupo( String[] Partes2, int i) {

        
       
           
            
                 for (int a = 0; a < Ingresados.length; a++) {
                    if(Ingresados[a] != null){
                        if(Ingresados[a].equalsIgnoreCase(Partes2[0] + Partes2[1] +Partes2[2]+Partes2[3])){
                            System.out.println(Ingresados[a]);
                            System.out.println("Ya se encuentra en el grupo");
                            break;
                        }
                }
            }
                    Ingresados[cantidadIngresados] =Partes2[0] + Partes2[1] +Partes2[2]+Partes2[3];
                    System.out.println(Ingresados[cantidadIngresados]);
                    System.out.println("[OK]       "+Partes2[0]+" "+Partes2[1] +" -> admitido en " + Partes2[3]);
                    cantidadIngresados++;
                    
                

            }


           
        
        
        
    
    public static void rechazadoGrupo(String[] Partes, int i) {
        Rechazados[cantidadRechazados] = Partes[0]+Partes[1];
        System.out.println("[RECHAZO]  " + Rechazados[cantidadRechazados] + " -> no cumple con los requisitos");
        cantidadRechazados++;
    }

        

    
    private static void cargarArchivos() {

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
