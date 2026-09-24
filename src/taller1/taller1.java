package taller1;

import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;

public class taller1 {
    static Scanner scanner=new Scanner(System.in);
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
    static int totalcantidadRechazados=0;
    static int totalCantidadAlumnos = 0;
    static  int contadorReporteCUno=1;
    static  int contadorReporteCDos=1;
    static int  contadorReporteRechazados=1;
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
                    administracionCurso();
			        break;
		        case 5:
                    generarReporte();
			        break;
		        case 6:
                    analisisEstadístico();
			        break;
            }

        } while (opcion != 7);

        s.close();
    }

    
    private static void analisisEstadístico() {
        System.out.println("--- Analisis estadistico ---");
        System.out.println("Cantidad de alumnos rechazados: "+totalcantidadRechazados+" ("+calcPor()+"%)");
        System.out.println("Cantidad de solicitudes duplicadas "+totalcantidadDuplicados);
        String paraleloNumeroso=paraleloMayor();
        System.out.println("El paralelo con más alumnos es: "+paraleloNumeroso);

    }


    private static String paraleloMayor() {
        String paralelomayor=null;
        //String[] C1=new String[100];
        //String[] C2=new String[100];
        int contadorC1=0;
        int contadorC2=0;
        String paralelo=null;
        for (int i = 0; i < alumnos.length; i++) {
            if(alumnos[i]!=null){
             paralelo=alumnos[i].split(";")[3];
            
            if(paralelo.equalsIgnoreCase("C1")){
                contadorC1++;
            }else{
                if(paralelo.equalsIgnoreCase("C2")){
                    contadorC2++;
                }
            }
            }
        }
        if(contadorC1>contadorC2){
            paralelomayor="el paralelo C1 tiene más alumnos ";
            return paralelomayor;
            
        }else {
            if(contadorC1<contadorC2){
                paralelomayor="el paralelo C2 tiene más alumnos ";
                return paralelomayor;
            }else{
                System.out.println(contadorC1);
                System.out.println(contadorC2);
                 paralelomayor="Ambos valores son iguales";

            }
        }

        //String mensajeDefault="No hay resultados concluyentes";
        return paralelomayor;
    }


    private static float calcPor() {
        String rechazados=""+totalcantidadRechazados;
        float prom=Float.parseFloat(rechazados)/cantidadSolicitudes;
        prom =prom *100;

        return prom;
        
    }


    private static void generarReporte() {
       
        System.out.println("Ingrese el tipo de reporte que quiere crear:  \n1) Reporte paralerlo C1  \n2) Reporte paralerlo C2 \n3)Reporte sobre los Rechazados  ");
        System.out.println();
        int seleccion=scanner.nextInt();
        switch(seleccion){
            case 1:
                reporteCUno();
            case 2:
                reporteCDos();
                break;
            case 3:
                reporteRechazados();
                break;
        }
        

        }
    


    private static void reporteRechazados() {
        try{
         String Rechazados="Rechazados-V "+contadorReporteRechazados+".txt";
         File file =new File(Rechazados);
         if(file.createNewFile()){
            FileWriter fw= new FileWriter(file);
            BufferedWriter bw= new BufferedWriter(fw);
            String titulo="=== Miembros del grupo - Paralelo C2 ===";
            bw.write(titulo);
            for(int i=0; i< IngresadosParalelos.length;i++){
                if(IngresadosParalelos[i].equalsIgnoreCase("C1")){
                    String dato=IngresadosParalelos[i];
                    bw.write(dato);
                    bw.newLine();
                }
                

            }
            contadorReporteRechazados++;
            bw.close();
            fw.close();
                     
            
         }
        }catch(IOException e){
            System.out.println("Error al ingresar Archivo" + e.getMessage());
        }
        
        
    }


    private static void reporteCDos() {
      try{
         String nombreCDos="ReporteC2-V "+contadorReporteCDos+".txt";
         File file =new File(nombreCDos);
         if(file.createNewFile()){
            FileWriter fw= new FileWriter(file);
            BufferedWriter bw= new BufferedWriter(fw);
            String titulo="=== Miembros del grupo - Paralelo C2 ===";
            bw.write(titulo);
            for(int i=0; i< IngresadosParalelos.length;i++){
                if(IngresadosParalelos[i].equalsIgnoreCase("C1")){
                    String dato=IngresadosParalelos[i];
                    bw.write(dato);
                    bw.newLine();
                }
                

            }
            contadorReporteCDos++;
            bw.close();
            fw.close();
                     
            
         }
        }catch(IOException e){
            System.out.println("Error al ingresar Archivo" + e.getMessage());
        }
        
        
        
    }


    private static void reporteCUno() {
        
        try{
         String nombreCUno="ReporteC1-V "+contadorReporteCUno+".txt";
         File file =new File(nombreCUno);
         if(file.createNewFile()){
            FileWriter fw= new FileWriter(file);
            BufferedWriter bw= new BufferedWriter(fw);
            String titulo="=== Miembros del grupo - Paralelo C1 ===";
            bw.write(titulo);
            for(int i=0; i< IngresadosParalelos.length;i++){
                if(IngresadosParalelos[i].equalsIgnoreCase("C1")){
                    String dato=IngresadosParalelos[i];
                    bw.write(dato);
                    bw.newLine();
                }
                

            }
            contadorReporteCUno++;
            bw.close();
            fw.close();
                     
            
         }
        }catch(IOException e){
            System.out.println("Error al ingresar Archivo" + e.getMessage());
        }
        
        
        
    }


    public  static void administracionCurso() {
       System.out.println("Administracion del curso");
      
       System.out.println("Seleccione opcion:");
       System.out.println("1) Cambiar paralelo de un alumno");
       System.out.println("2) Eliminar alumno del curso");
       System.out.println("3) Inscribir alumno nuevo");
       System.out.println("4) Volver al menu principal");
       int opcionEntera=0;
       System.out.println("Ingrese opcion:");
       String  opcion=scanner.nextLine();
       while(!opcion.equalsIgnoreCase("1")||!opcion.equalsIgnoreCase("2") || !opcion.equalsIgnoreCase("3")){
        System.out.println("Opcion invalida, ingrese nuevamente");
        opcion=scanner.nextLine();
        opcionEntera=Integer.parseInt(opcion);

       }
       switch(opcionEntera){
        case 1:
            cambiarParalelo();
            break;
        case 2:
            eliminarAlumnoCurso();
            break;
        case 3:
            agregarAlumno();
            break;
       default:
            break;
       }
    }


    private static void agregarAlumno() {
        System.out.println("Ingresar alumnos");
        System.out.println("Ingrese el nombre del nuevo alumno");
        String nombreNuevo=scanner.nextLine();
        System.out.println("Ingrese el apellido del estudiante");
        String apellidoNuevo=scanner.nextLine();
        System.out.println("Ingrese el rut del nuevo alumno");
        String rutNuevo=scanner.nextLine();
        System.out.println("ingrese el paralelo (C1/C2) del nuevo alumno");
    }


    private static void eliminarAlumnoCurso() {
        System.out.println("Ingrese el rut del alumno que desee eliminar.");
        String rutEliminar=null; 
        try{
        rutEliminar=scanner.nextLine();
        throw new IOException("opcion invalida, intente denuevo");

        }catch(IOException e){
            System.out.println(e.getMessage());

        }
         int indiceEliminar=buscarIndiuce(rutEliminar);
         eliminar(indiceEliminar);
    }


    


    public  static void eliminar(int indiceEliminar) {
       alumnos[indiceEliminar]=null;
       cambiarordenBusbuja(indiceEliminar);
       sobreescribirLista();
        } 
    
    
   


    public  static void cambiarordenBusbuja(int indiceEliminar) {
       int resto=alumnos.length - indiceEliminar;
       int indiceFinal=resto-1;
        for(int i=0; i<resto;i++){
            if(i != indiceFinal){
            alumnos[i]= alumnos[i+1];
            }else{
                alumnos[-1] = null;
            }
        }
    }


    public  static void cambiarParalelo() {
       System.out.println("Ingrese el rut del alumno");
        String rutIngresado=null; 
       
        try{
        rutIngresado=scanner.nextLine();
        throw new IOException ("Invalido. Ingrese valores válidos:");
       }catch(IOException  e){
        System.out.println(e.getMessage());
       }
       
            buscarRUT(rutIngresado);
            
       
       
       String paraleloNuev=null;

       while (paraleloNuev==null || !paraleloNuev.equalsIgnoreCase("C1") && !paraleloNuev.equalsIgnoreCase("C2") ) {
            System.out.println("Nuevo paralelo (C1/C2):  ");
            try{
            paraleloNuev=scanner.nextLine();
            throw new IOException("Paralelo inválido");
            }catch(IOException e){
                System.out.println(e.getMessage());
                }
        
            }
            cambiarParaleloEfectivo(paraleloNuev,rutIngresado);
            sobreescribirLista();
        }

    
    public  static void buscarRUT(String rutIngresado) {
       for(int i=0; i<totalCantidadAlumnos; i++){
        if(rutIngresado.equalsIgnoreCase(alumnos[i].split(";")[3])){
                System.out.println("Alumno: "+alumnos[i].split(";")[0]+ " "+ alumnos[i].split(";")[1]+ " (actualmente en " +alumnos[i].split(";")[2]+")");
                
            }
       }
    }


    public  static void cambiarParaleloEfectivo(String paraleloNuev, String rutIngresado) {
        
                int indice=buscarIndiuce(rutIngresado);
                
                alumnos[indice]=alumnos[indice].split(";")[0]+ " "+alumnos[indice].split(";")[1]+";"+alumnos[indice].split(";")[2]+";"+paraleloNuev;
                // si ya esta admitido actualizar;
    }
                

        
    public  static int buscarIndiuce(String rutIngresado) {
        for(int i=0; i<totalCantidadAlumnos; i++){// hay que serciorsrse de que haya 4 partes con un if
            if(rutIngresado.equalsIgnoreCase(alumnos[i].split(";")[2])){//
                return i;
            }
            
        }
        return 0;//mejor devolver un -1
        
    }
    


    public  static void inscripcionManual() {
   
    System.out.println("Inscripcion manual al grupo");
    System.out.println("Como desea inscribir a la persona?");
    System.out.println("1) Por nombre completo");
    System.out.println("2) Por RUT");
    System.out.println("Ingrese opcion:");
    int opcion=scanner.nextInt();
    while(opcion<1||opcion>2){
        System.out.println("Opcion invalida, ingrese nuevamente");
        opcion=scanner.nextInt();
    }
    if(opcion==1){
        inscripcionPorNombre();
        }else{
        inscripcionPorRut();
        }
    }
    
    public  static void inscripcionPorRut() {
        
        System.out.println("Ingrese el RUT del alumno:");
        String rutNuevo=null;
        try{
            rutNuevo=scanner.nextLine();
            throw new Exception("Error al ingresar el RUT");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            for(int i=0;i<cantidadAlumnos;i++){
                if(rutNuevo.equalsIgnoreCase(alumnos[i].split(";")[2])){
                System.out.println("Solicitud de "+alumnos[i].split(";")[0]+" "+alumnos[i].split(";")[1]+" -> admitido en "+alumnos[i].split(";")[3]);
                System.out.println("Es alumno ingresar al grupo");
                IngresadosNombres[cantidadAlumnos]=alumnos[i].split(";")[0];
                IngresadosApelliodos[cantidadAlumnos]=alumnos[i].split(";")[1];
                IngresadosRuts[cantidadAlumnos]=alumnos[i].split(";")[2];
                break;
                    }else{
                        System.out.println("El rut "+rutNuevo+" no pertenece a ningun alumno");
                        System.out.println("No tenemos su nombre, por lo que se registrara solo el RUT en los rechazados.");
                        RechazadosNombres[totalcantidadRechazados]="Desconocido solo se dispone del RUT";
                        RechazadosApellidos[totalcantidadRechazados]="Desconocido solo se dispone del RUT";
                        totalcantidadRechazados++;
                    }
            }
            
        }

    public  static void inscripcionPorNombre() {
        
        System.out.println("Ingrese el nombre del alumno:");
        String nombreNuevo = null;
        String apellidoNuevo=null;
        try{
            nombreNuevo=scanner.nextLine();
            System.out.println("Ingrese el apellido que quiere ingersar: ");
            apellidoNuevo=scanner.nextLine();
            throw new Exception("Error al ingresar el nombre o apellido");// se cambia por que siomepre aparece; hay que cambiar 
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            boolean yaExiste=false;
            for(int i=0;i<cantidadAlumnos;i++){
                if(nombreNuevo.equalsIgnoreCase(IngresadosNombres[i]) && apellidoNuevo.equalsIgnoreCase(IngresadosApelliodos[i])){
                System.out.println("El alumno ya ha sido ingresado al chat");
                yaExiste=true;
                break;
                }
            }
            
            for(int i=0;i<cantidadAlumnos;i++){
                if(nombreNuevo.equalsIgnoreCase(alumnos[i].split(";")[0]) && apellidoNuevo.equalsIgnoreCase(alumnos[i].split(";")[1])){
                System.out.println("Solicitud de "+nombreNuevo+" "+apellidoNuevo+" -> admitido en "+alumnos[i].split(";")[3]);
                System.out.println("Es alumno ingresar al grupo");
                IngresadosNombres[cantidadAlumnos]=nombreNuevo;
                IngresadosApelliodos[cantidadAlumnos]=apellidoNuevo;
                IngresadosRuts[cantidadAlumnos]=alumnos[i].split(";")[2];
                yaExiste=true;
                break;
                    }
                }
            if(!yaExiste){
                System.out.println("El alumno no pertenece a ningun paralelo");}
                //totalcantidadRechazados
                RechazadosNombres[totalcantidadRechazados]=nombreNuevo;
                RechazadosApellidos[totalcantidadRechazados]=apellidoNuevo;
                totalcantidadRechazados++;
                System.out.println("[RECHAZO] Solicitud de "+nombreNuevo+" "+apellidoNuevo+"-> no pertenece a ningun paralelo");
                

            
        }
    public  static void procesarSolicitudes() {
       
       
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
            totalcantidadRechazados++;
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
     public  static void sobreescribirLista() {
            try{
                FileWriter filewrite= new FileWriter("alumnos.txt");
                BufferedWriter br= new BufferedWriter(filewrite);
                for(int i=0; i<alumnos.length; i++){
                    br.write(alumnos[i]);
                    br.newLine();
                }

                
            }catch(Exception e){
                System.out.println("Error en la sobre escritura del anuncio, contacte soporte tecnico");
            }
    }


    public  static void cargarArchivos() {

        File Archivo = new File("alumnos.txt");
        File Archivo2 = new File("solicitudes.txt");

        try (Scanner Lector = new Scanner(Archivo)) {
            while (Lector.hasNextLine()) {
                String Linea = Lector.nextLine();
                alumnos[cantidadAlumnos] = Linea;
                cantidadAlumnos++;
                totalCantidadAlumnos++;
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
