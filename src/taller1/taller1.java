package taller1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class taller1 {

    static String[] alumnos = new String[100];
    static String[] solicitudes = new String[100];
    static String[] IngresadosNombres = new String[100];
    static String[] IngresadosApelliodos = new String[100];
    static String[] IngresadosRuts = new String[100];
    static String[] IngresadosParalelos = new String[100];
    static String[] RechazadosNombres = new String[100];
    static String[] RechazadosApellidos = new String[100];
    static int cantidadAlumnos = 0;
    static int cantidadSolicitudes = 0;
    static int totalcantidadDuplicados = 0;
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
                    inscripcionManual();
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

    
    private static void inscripcionManual() {
    Scanner scanner=new Scanner(System.in);   
    System.out.println("Inscripcion manual al grupo");
    System.out.println("Ingrese el nombre que quiere ingersar: ");
    String nombreNuevo = null;
    String apellidoNuevo=null;
    try{
    nombreNuevo=scanner.nextLine();
    apellidoNuevo=scanner.nextLine();
    throw new Exception("Error al ingresar el nombre o apellido");
    }catch(Exception e){
        e.getMessage();
    }
    for(int i=0;i<cantidadAlumnos;i++){
        if(nombreNuevo.equalsIgnoreCase(IngresadosNombres[i]) && apellidoNuevo.equalsIgnoreCase(IngresadosApelliodos[i])){
            System.out.println("El alumno ya ha sido ingresado al chat");
       }
    }
    for(int i=0;i<cantidadAlumnos;i++){
        if(nombreNuevo.equalsIgnoreCase(alumnos[i].split(";")[0]) && apellidoNuevo.equalsIgnoreCase(alumnos[i].split(";")[1])){
            System.out.println("Es alumno ingresar al grupo");
       }
    }
}


    private static void procesarSolicitudes() {
       
       
       int cantiDuplicados=0;
       int cantidadIngresados=0;
       int cantidadRechazados=0;
       

       for (int i = 0; i < solicitudes.length; i++) { 
        if(solicitudes[i]!=null){
        
        String solNombres= solicitudes[i].split("-")[0];
        String solApellidos= solicitudes[i].split("-")[1];
        boolean yaProcesado=false;
        for (int j = 0; j <cantidadIngresados ; j++){
            
            if(IngresadosNombres[j].equalsIgnoreCase(solNombres) && IngresadosApelliodos[j].equalsIgnoreCase(solApellidos)){       
                yaProcesado=true;
                System.out.println("[RECHAZO] Solicitud de "+solNombres+" "+solApellidos+"-> ya fue ingresado anteriormente");
                break;
            }
        }
        if(yaProcesado == false){
            
            for (int j = 0; j < cantidadRechazados; j++) {
                if(RechazadosNombres[j].equalsIgnoreCase(solNombres) && RechazadosApellidos[j].equalsIgnoreCase(solApellidos)){
                    yaProcesado=true;
                    System.out.println("[RECHAZO] Solicitud de "+solNombres+" "+solApellidos+"-> ya fue rechazada anteriormente");
                    break;
                }
            }

        }
        if(yaProcesado == true){
            cantiDuplicados++;
            totalcantidadDuplicados++;
            
            continue;
        }
        boolean esAlumno=false;
        if (cantidadIngresados==0){
            primerIngreso(solNombres, solApellidos,esAlumno,cantidadIngresados);
            cantidadIngresados++;
            

        }else{
        
        for (int j = 0; j < alumnos.length; j++){
           
            if(alumnos[j]!=null){
            String alumnoNombre=alumnos[j].split(";")[0];
            String alumnoApellido=alumnos[j].split(";")[1];
            if(alumnoNombre.equalsIgnoreCase(solNombres) && alumnoApellido.equalsIgnoreCase(solApellidos)){
                IngresadosNombres[cantidadIngresados]=solNombres;
                IngresadosApelliodos[cantidadIngresados]=solApellidos;
                IngresadosRuts[cantidadIngresados]=alumnos[j].split(";")[2];
                IngresadosParalelos[cantidadIngresados]=alumnos[j].split(";")[3];

                cantidadIngresados++;
                esAlumno=true;
                System.out.println("Solicitud de "+solNombres+" "+solApellidos+" -> admitido en "+alumnos[j].split(";")[3]);
                break;
                    }
            
                }
            }
        }
        if(!esAlumno){
            RechazadosNombres[cantidadRechazados]=solNombres;
            RechazadosApellidos[cantidadRechazados]=solApellidos;
            cantidadRechazados++;
            System.out.println("[RECHAZO] Solicitud de "+solNombres+" "+solApellidos+"-> no pertenece a ningun paralelo");
                }

            }
        }
        System.out.println("Resumen del procesamiento de solicitudes: "+cantidadIngresados+" ingresados/"+cantidadRechazados+" rechazados" );

       
       
        // Aquí puedes agregar la lógica para procesar las solicitudes
}
        
    
    public static void primerIngreso(String solNombres, String solApellidos, boolean esAlumno, int cantidadIngresados) {
       String alumnoNombre=alumnos[0].split(";")[0];
            String alumnoApellido=alumnos[0].split(";")[1];
            if(alumnoNombre.equalsIgnoreCase(solNombres) && alumnoApellido.equalsIgnoreCase(solApellidos)){
                IngresadosNombres[cantidadIngresados]=solNombres;
                IngresadosApelliodos[cantidadIngresados]=solApellidos;
                IngresadosRuts[cantidadIngresados]=alumnos[0].split(";")[2];
                IngresadosParalelos[cantidadIngresados]=alumnos[0].split(";")[3];

                cantidadIngresados++;
                esAlumno=true;
                System.out.println("Solicitud de "+solNombres+" "+solApellidos+" -> admitido en "+alumnos[0].split(";")[3]);
            }
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
