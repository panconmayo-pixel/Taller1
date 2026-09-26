package taller1;
//Nombre1 Apellido1 - 21.000.000-K - ICCI
//Valentina Castillo - 15.166.692-2 - ITI
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;



public class taller1 {
	 static Scanner scanner=new Scanner(System.in);
	//iniciar los arreglos a ocupar y las cantidades con las que se trabajará en el problema.
	 
	    static String[] alumnos = new String[100];
	    static String[] apellidoAlumno= new String[100];
	    static String[] rutAlumno = new String[100];
	    static String[] paraleloAlumno = new String[100];
	    
	    static String[] alumnosSolicitudes = new String[100];
	    static String[] apellidoSolicitudes = new String[100];
	    static String[] solicitudes = new String[100];
	    
	
	    static String[] IngresadosNombres = new String[100];
	    static String[] IngresadosApellidos = new String[100];
	    static String[] IngresadosRuts = new String[100];
	    static String[] IngresadosParalelos = new String[100];
	   
	    static String[] RechazadosNombres = new String[100];
	    static String[] RechazadosApellidos = new String[100];
	    
	    
	    
	    static int cantidadIngresados = 0;
	    static int cantidadRechazados = 0;
	    static boolean solicitudesProcesadas = false;
	    static int cantidadAlumnos = 0;
	    static int cantidadSolicitudes = 0;
	    static int totalcantidadDuplicados = 0;
	    static int totalCantidadAlumnos = 0;
	    static  int contadorReporteCUno=1;
	    static  int contadorReporteCDos=1;
	    static int  contadorReporteRechazados=1;

	        
	public static void main(String[] args) {
	//Menu principal de usuario.
		Scanner s = scanner;
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

            String opcionTexto = s.nextLine();

            try {
				//Asegurarse que se ingresan los datos correctamentes
                opcion = Integer.parseInt(opcionTexto);

                if(opcion < 1 || opcion > 7) {
                    System.out.println("Opcion invalida, intente nuevamente.");
                    opcion = 0;
                }

            } catch(Exception e) {
                System.out.println("Debe ingresar un numero.");
                opcion = 0;
            }
            switch (opcion) {
				//selección de lo que se hará.
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
		        	analisisEstadistico ();
			        break;
		        case 7:
		        	System.out.println("Saliendo....");
            }

        } while (opcion != 7);
        s.close();
    }

	
	public static void generarReporte() {
		
		System.out.println("Ingrese el tipo de reporte que quiere crear:  \n1) Reporte paralerlo C1  \n2) Reporte paralerlo C2 \n3)Reporte sobre los Rechazados  ");
        System.out.println();
        String selec=scanner.nextLine();
        int seleccion=Integer.parseInt(selec);
        while(seleccion !=1 && seleccion !=2  && seleccion !=3){
        	   	System.out.println("Opcion invalida, ingrese nuevamente");	
        	   	seleccion=scanner.nextInt();
        	   	
           }
        switch(seleccion){
            case 1:
                reporteCUno();
                break;
            case 2:
                reporteCDos();
                break;
            case 3:
                reporteRechazados();
                break;
        }
		
	}


	public static void reporteRechazados() {
		try{
			System.out.println("Ingreso rechazo");
	         String Rechazados="Rechazados-V "+contadorReporteRechazados+".txt";
	         File file =new File(Rechazados);
	         if(file.createNewFile()){
	            FileWriter fw= new FileWriter(file);
	            BufferedWriter bw= new BufferedWriter(fw);
	            String titulo="=== Miembros del grupo - Rechazados ===";
	            bw.write(titulo);
	            bw.newLine();
	            for(int i=0; i< cantidadRechazados;i++){
	                if(RechazadosNombres[i] != null){
	                    String dato=""+RechazadosNombres[i]+";"+RechazadosApellidos[i];
	                    bw.write(dato);
	                    bw.newLine();
	                	}
	            	

	            }
	            contadorReporteRechazados++;
	            bw.close();
	            fw.close();
	                     
	            
	         }else{
	            	System.out.println("Archivo"+Rechazados+" ya creado");
	            }
	        }catch(Exception e){
	            System.out.println("Error al ingresar Archivo" + e.getMessage());
	        }
		
	}


	public static void reporteCDos() {
		
		
		try{
	         String nombreCDos="ReporteC2-V "+contadorReporteCDos+".txt";
	         File file =new File(nombreCDos);
	         if(file.createNewFile()){
	            FileWriter fw= new FileWriter(file);
	            BufferedWriter bw= new BufferedWriter(fw);
	            String titulo="=== Miembros del grupo - Paralelo C2 ===";
	            bw.write(titulo);
	            bw.newLine();
	            for(int i=0; i< cantidadIngresados;i++){
	            	
	                if(IngresadosParalelos[i].equalsIgnoreCase("C2")){
	                    String dato=""+IngresadosNombres[i]+";"+IngresadosApellidos[i]+";"+IngresadosRuts[i]+";"+IngresadosParalelos[i];
	                    bw.write(dato);
	                    bw.newLine();
	                		}
	                
	            		}
	            	
	            contadorReporteCDos++;
	            bw.close();
	            fw.close();
	                     
	            
	         }else{
	            	System.out.println("Archivo "+nombreCDos+" ya creado");
	            }
	        }catch(Exception e){
	            System.out.println("Error al ingresar Archivo" + e.getMessage());
	        }
		
	}


	public static void reporteCUno() {
		
		
		 try{
	         String nombreCUno="ReporteC1-V "+contadorReporteCUno+".txt";
	         File file =new File(nombreCUno);
	         if (file.createNewFile()) {
		         FileWriter fw = new FileWriter(file);
		         BufferedWriter bw= new BufferedWriter(fw);
		         String titulo="=== Miembros del grupo - Paralelo C1 ===";
		         bw.write(titulo);
		         bw.newLine();
		         for(int i=0; i< cantidadIngresados;i++){
		            	 
		                if(IngresadosParalelos[i].equalsIgnoreCase("C1")){
		                    String dato=""+IngresadosNombres[i]+";"+IngresadosApellidos[i]+";"+IngresadosRuts[i]+";"+IngresadosParalelos[i];
		                    System.out.println(dato);
		                    bw.write(dato);
		                    bw.newLine();
		                	}
		            
	         }
	         contadorReporteCUno++;
	         bw.close();
	         fw.close();
	         }else {
	            	System.out.println("Archivo"+nombreCUno+" ya creado");
	        
	         }
	        }catch(Exception e){
	            System.out.println("Error al ingresar Archivo" + e.getMessage());
	        }
	}
	        
		
	


	public  static void analisisEstadistico () {
		System.out.println("Analisis estadistico rechazados y admitidos ");
		if (cantidadSolicitudes == 0) {
            System.out.println("No hay solicitudes cargadas.");
            return;
        }
		
		double porcentajeRechazo = ((double)cantidadRechazados / cantidadSolicitudes) * 100;
		double tasaAdmision = ((double)cantidadIngresados / cantidadSolicitudes) * 100;
		int cantidadC1 = 0;
	    int cantidadC2 = 0;

		    for(int i=0; i<cantidadAlumnos; i++) {
		        if(paraleloAlumno[i].equalsIgnoreCase("C1")) {
		            cantidadC1++;
		        }
		        if(paraleloAlumno[i].equalsIgnoreCase("C2")) {
		            cantidadC2++;
		        }
		    }
		    double porcentajeC1 = ((double)cantidadC1 / cantidadAlumnos) * 100;
		    double porcentajeC2 = ((double)cantidadC2 / cantidadAlumnos) * 100;

		    System.out.println("Porcentaje de rechazo: " + porcentajeRechazo + "%");
		    System.out.println("Tasa de admision: " + tasaAdmision + "%");	    
		    System.out.println("Porcentaje de alumnos en C1: " + porcentajeC1 + "%");
		    System.out.println("Porcentaje de alumnos en C2: " + porcentajeC2 + "%");
		}
	
    public  static void administracionCurso() {
    	
       System.out.println("Administracion del curso");
       System.out.println("Seleccione una  opcion:");
       System.out.println("1) Cambiar paralelo de un alumno");
       System.out.println("2) Eliminar alumno del curso");
       System.out.println("3) Inscribir alumno nuevo");
       System.out.println("4) Volver al menu principal");
       
       System.out.println("Ingrese opcion: ");
       String  opcion=scanner.nextLine();
       
       while(!opcion.equalsIgnoreCase("1") && !opcion.equalsIgnoreCase("2") 
    		&& !opcion.equalsIgnoreCase("3") && !opcion.equalsIgnoreCase("4")){
    	   	System.out.println("Opcion invalida, ingrese nuevamente");	
    	   	opcion=scanner.nextLine();
    	   	
       }
       
       int opcionEntera = Integer.parseInt(opcion);
       
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
        case 4:
        	break; 
       }
    }
    

    public static void agregarAlumno() {
        System.out.println("Ingresar alumnos");
        
        if(cantidadAlumnos >= 100) {
        	System.out.println("No se pueden agregar mas alumnos,supero la capacidad maxima admitida");
        	return;
        }
        
        System.out.println("Ingrese el nombre del nuevo alumno: ");
        String nombreNuevo = scanner.nextLine();
        while(nombreNuevo.equals("")) {
            System.out.println("El nombre no puede estar vacio.");
            System.out.println("Ingrese nuevamente el nombre:");
            nombreNuevo = scanner.nextLine();
        }
        
        System.out.println("Ingrese el apellido del estudiante: ");
        String apellidoNuevo=scanner.nextLine();
        while(apellidoNuevo.equals("")) { 
            System.out.println("El apellido no puede estar vacio.");
            System.out.println("Ingrese nuevamente el apellido:");
            apellidoNuevo = scanner.nextLine();
        }
        
        System.out.println("Ingrese el rut del nuevo alumno: ");
        String rutNuevo=scanner.nextLine();
        while(rutNuevo.equals("")) { 
            System.out.println("El rut no puede estar vacio.");
            System.out.println("Ingrese nuevamente el rut:");
            rutNuevo = scanner.nextLine();
        }
        
        for(int i=0; i<cantidadAlumnos; i++) {
            if(rutNuevo.equalsIgnoreCase(rutAlumno[i])) {
                System.out.println("Ese RUT ya pertenece a un alumno.");
                return;
            }
        }
        System.out.println("ingrese el paralelo (C1/C2) del nuevo alumno: ");
        String paraleloNuevo = scanner.nextLine();
        while(!paraleloNuevo.equalsIgnoreCase("C1") &&
                !paraleloNuevo.equalsIgnoreCase("C2")) {

              System.out.println("Paralelo invalido solo puede ser C1 o C2.");
              System.out.println("Ingrese nuevamente el paralelo:");
              paraleloNuevo = scanner.nextLine();
          }
        alumnos[cantidadAlumnos] = nombreNuevo; 
        apellidoAlumno[cantidadAlumnos] = apellidoNuevo; 
        rutAlumno[cantidadAlumnos] = rutNuevo; 
        paraleloAlumno[cantidadAlumnos] = paraleloNuevo; 
        cantidadAlumnos++;
        sobreescribirLista(); 
        System.out.println("Alumno agregado correctamente.");
    }


    public static void eliminarAlumnoCurso() {
        System.out.println("Ingrese el rut del alumno que desee eliminar.");
        String rutEliminar = scanner.nextLine();
        
        int indiceEliminar = buscarIndiuce(rutEliminar);
        if(indiceEliminar == -1) {
        	System.out.println("No se encontro un alumno con ese rut");
            return;
        }
        eliminar(indiceEliminar);
        }
    
    public static void eliminar(int indiceEliminar) {
        String rutEliminado = rutAlumno[indiceEliminar];
        
        for(int i = 0; i < cantidadIngresados; i++) {
            if(rutEliminado.equalsIgnoreCase(IngresadosRuts[i])) {
                for(int j = i; j < cantidadIngresados - 1; j++) {
                    IngresadosNombres[j] = IngresadosNombres[j + 1];
                    IngresadosApellidos[j] = IngresadosApellidos[j + 1];
                    IngresadosRuts[j] = IngresadosRuts[j + 1];
                    IngresadosParalelos[j] = IngresadosParalelos[j + 1];
                }
                IngresadosNombres[cantidadIngresados - 1] = null;
                IngresadosApellidos[cantidadIngresados - 1] = null;
                IngresadosRuts[cantidadIngresados - 1] = null;
                IngresadosParalelos[cantidadIngresados - 1] = null;

                cantidadIngresados --;
                break;
            }
        }
        alumnos[indiceEliminar] = null;
        cambiarordenBusbuja(indiceEliminar);
        sobreescribirLista();

        System.out.println("Alumno eliminado correctamente.");
    }
    
    public static void cambiarordenBusbuja(int indiceEliminar) {

        for(int i=indiceEliminar; i<cantidadAlumnos-1; i++){

            alumnos[i] = alumnos[i+1];
            apellidoAlumno[i] = apellidoAlumno[i+1];
            rutAlumno[i] = rutAlumno[i+1];
            paraleloAlumno[i] = paraleloAlumno[i+1];

        }

        alumnos[cantidadAlumnos-1] = null;
        apellidoAlumno[cantidadAlumnos-1] = null;
        rutAlumno[cantidadAlumnos-1] = null;
        paraleloAlumno[cantidadAlumnos-1] = null;

        cantidadAlumnos--;
    }
    

    public  static void cambiarParalelo() {
       System.out.println("Ingrese el rut del alumno: ");
       String rutIngresado = scanner.nextLine();
       
       int indice = buscarIndiuce(rutIngresado);

       if(indice == -1) {
           System.out.println("No se encontro un alumno con ese RUT.");
           return;
       }
       
       buscarRUT(rutIngresado);
       String paraleloNuev=null;

       while (paraleloNuev==null || !paraleloNuev.equalsIgnoreCase("C1") && !paraleloNuev.equalsIgnoreCase("C2") ) {
            System.out.println("Nuevo paralelo (C1/C2):  ");
            paraleloNuev=scanner.nextLine();
            
            if (!paraleloNuev.equalsIgnoreCase("C1") &&
                    !paraleloNuev.equalsIgnoreCase("C2")) {
            	System.out.println("Paralelo invalido");
            }
        }
        cambiarParaleloEfectivo(paraleloNuev,rutIngresado);
        sobreescribirLista();
        System.out.println("Paralelo cambiado correctamente.");
        }
    
    public static void buscarRUT(String rutIngresado) {

        int indice = buscarIndiuce(rutIngresado);

        if(indice != -1) {

            System.out.println("Alumno: " + alumnos[indice] + " "
                    + apellidoAlumno[indice]
                    + " (actualmente en "
                    + paraleloAlumno[indice] + ")");

        }
    }

    public  static void cambiarParaleloEfectivo(String paraleloNuev, String rutIngresado) {
                int indice=buscarIndiuce(rutIngresado);
                if(indice == -1) {
                    System.out.println("No se encontro un alumno con ese rut");
                    return;
                }
                paraleloAlumno[indice] = paraleloNuev;
                for(int i=0; i<cantidadIngresados; i++) {
                    if(rutIngresado.equalsIgnoreCase(IngresadosRuts[i])) {
                        IngresadosParalelos[i] = paraleloNuev;
                        break;
                    }
                }
            }
              

        
    public  static int buscarIndiuce(String rutIngresado) {
		for(int i=0; i< cantidadAlumnos; i++){
			if(rutIngresado.equalsIgnoreCase(rutAlumno[i])){
	            return i;
	        }
			
	    }
	    return -1;
	}
    
    public static void inscripcionManual() {
		//Inscripción por parte del usuario de una persona.Seleccionar si se hace a partir del nombre o del rut.
        System.out.println("Inscripcion manual al grupo");
        System.out.println("Como desea inscribir a la persona?");
        System.out.println("1) Por nombre completo");
        System.out.println("2) Por RUT");
        System.out.println("Ingrese opcion:");

        String opcionT = scanner.nextLine();
        int opcion;

        try {
            opcion = Integer.parseInt(opcionT);
			//Coantrol de error en casod e que se ingrese alguna de las opciones no válidos.
            while(opcion < 1 || opcion > 2) {
                System.out.println("Opcion invalida, ingrese nuevamente");
                opcionT = scanner.nextLine();
                opcion = Integer.parseInt(opcionT);
            }
        } catch(Exception e) {
            System.out.println("Debe ingresar un numero.");
            return;
        }
        if(opcion == 1) {
			//Se selecciona inscribir por nombre.
            inscripcionPorNombre();
        } else {
			//Se selecciona inscribir por rut.
            inscripcionPorRut();
        }
    }
    
    public  static void inscripcionPorRut() {
       
        System.out.println("Ingrese el RUT del alumno:");
        String rutNuevo=null;
        try{
            rutNuevo=scanner.nextLine();
            
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        	boolean existe = false;
        	//Conrol de error de que no se pueden ingresar más de 100 datos.
        	if(cantidadIngresados >= 100) {
        	    System.out.println("No se pueden ingresar mas alumnos al grupo.");
        	    return;
        	}
            for(int i=0;i<cantidadAlumnos;i++){
            	//Buscar de que el rut no haya sido ingresado todavía. 
            	 if(alumnoYaIngresado(rutNuevo)) {
            	        System.out.println("El alumno ya ha sido ingresado al grupo.");
            	        existe = true;
            	        break;
            	    }
				//Buscar el rut en la lista rut alumno y en caso de encontrarse guardar los datos del alumno.
                if(rutNuevo.equalsIgnoreCase(rutAlumno[i])) {
                System.out.println("Solicitud de "+ alumnos [i]  +" "+apellidoAlumno[i]+" -> admitido en "+ paraleloAlumno[i]);
                System.out.println("Es alumno ingresar al grupo");
                IngresadosNombres[cantidadIngresados]=alumnos[i];
                IngresadosApellidos[cantidadIngresados]=apellidoAlumno[i];
                IngresadosRuts[cantidadIngresados]=rutAlumno[i];
                IngresadosParalelos[cantidadIngresados] = paraleloAlumno[i];
                //Actualización de la cantidad de datos.
                cantidadIngresados ++;
                existe = true;
                break;
                }
            }
            if (!existe) {
					//Al ser no encontrado el nombre solo se rechaza  el rut, que se guarda en rechazo, y la notificación de que no se tiene  el nombre
                    System.out.println("El rut "+rutNuevo+" no pertenece a ningun alumno");
                    System.out.println("No tenemos su nombre, por lo que se registrara solo el RUT en los rechazados.");
                    RechazadosNombres[cantidadRechazados]="Desconocido solo se dispone del RUT";
                    RechazadosApellidos[cantidadRechazados]=rutNuevo;
					//Actualización de datos.
                    cantidadRechazados++;
                }
        }
            
        

    public static void inscripcionPorNombre() {

        System.out.println("Ingrese el nombre del alumno:");
        String nombreNuevo = null;
        String apellidoNuevo = null;

        try {
            nombreNuevo = scanner.nextLine();
            while(nombreNuevo.equals("")) {
                System.out.println("El nombre no puede estar vacio.");
                System.out.println("Ingrese nuevamente el nombre:");
                nombreNuevo = scanner.nextLine();
            }
            System.out.println("Ingrese el apellido que quiere ingersar: ");
            apellidoNuevo = scanner.nextLine();
            while(apellidoNuevo.equals("")) {
                System.out.println("El apellido no puede estar vacio.");
                System.out.println("Ingrese nuevamente el apellido:");
                apellidoNuevo = scanner.nextLine();
            }
        } catch(Exception e) {

            System.out.println(e.getMessage());
        }

        boolean yaExiste = false;

        if(cantidadIngresados >= 100) {
            System.out.println("No se pueden ingresar mas alumnos al grupo.");
            return;
        }

        for(int i=0; i<cantidadIngresados; i++) {

            if(nombreNuevo.equalsIgnoreCase(IngresadosNombres[i]) && 
                    apellidoNuevo.equalsIgnoreCase(IngresadosApellidos[i])) {

                System.out.println("El alumno ya ha sido ingresado al chat");

                yaExiste = true;

                break;
            }
        }

        if (!yaExiste) {
            for(int i=0; i<cantidadAlumnos; i++) {
                if(nombreNuevo.equalsIgnoreCase(alumnos[i]) &&
                        apellidoNuevo.equalsIgnoreCase(apellidoAlumno[i])) {
                    System.out.println("Solicitud de " + nombreNuevo + " " + apellidoNuevo 
                            + " -> admitido en el chat");
                    System.out.println("Es alumno ingresar al grupo");
                    IngresadosNombres[cantidadIngresados] = nombreNuevo;
                    IngresadosApellidos[cantidadIngresados] = apellidoNuevo;
                    IngresadosRuts[cantidadIngresados] = rutAlumno[i];
                    IngresadosParalelos[cantidadIngresados] = paraleloAlumno[i];

                    cantidadIngresados++;

                    yaExiste = true;

                    break;
                }
            }
        }

        if(!yaExiste) {
            System.out.println("El alumno no pertenece a ningun paralelo");
            RechazadosNombres[cantidadRechazados] = nombreNuevo;
            RechazadosApellidos[cantidadRechazados] = apellidoNuevo;
            cantidadRechazados++;
            System.out.println("Rechazado Solicitud de " + nombreNuevo + " " 
                    + apellidoNuevo + "-> no pertenece a ningun paralelo");
        }
    }
    
    public static boolean alumnoYaIngresado(String rut) {
        for(int i = 0; i < cantidadIngresados; i++) {
            if(rut.equalsIgnoreCase(IngresadosRuts[i])) {
                return true;
            }
        }
        return false;
    }
    
    public static void procesarSolicitudes() {
		//Asegurarse de no procesar dos veces el mismo archivo txt de solicitudes.
        if(solicitudesProcesadas) {
            System.out.println("Las solicitudes ya fueron procesadas.");
            return;
        }
		//Cantidad de datos que fueron rechazados  por ser ya ingresados al sistema.
        totalcantidadDuplicados = 0;
        boolean encontrado;
      
       for (int i  = 0; i < cantidadSolicitudes;i ++) {
    	   encontrado = false;
       
    	   for (int j = 0; j < cantidadAlumnos; j ++)  {
    		   if (alumnos[j].equalsIgnoreCase(alumnosSolicitudes[i])
    				    && apellidoAlumno[j].equalsIgnoreCase(apellidoSolicitudes[i])) {

    				    encontrado = true;

    				    if(alumnoYaIngresado (rutAlumno[j])) {
    				    	totalcantidadDuplicados ++;

    				    } else {
    				    	
    				    	if(cantidadIngresados >= 100) {
    				    	    System.out.println("Se alcanzo la capacidad maxima en el  grupo");
    				    	    break;
    				    	}
							//Ingresado los valores de solicitudes no duplicados pero que si estan ingresados en alumnos. 
    				        IngresadosNombres[cantidadIngresados] = alumnosSolicitudes[i];
    				        IngresadosApellidos[cantidadIngresados] = apellidoSolicitudes[i];
    				        IngresadosRuts[cantidadIngresados] = rutAlumno[j];
    				        IngresadosParalelos[cantidadIngresados] = paraleloAlumno[j];

    				        cantidadIngresados++;
    				    }
    		   }			
    	   }
		// los datos al no ser encontrados se guardan en los rechazados.
       if (! encontrado) {
    	   RechazadosNombres  [cantidadRechazados] = alumnosSolicitudes[i];
    	   RechazadosApellidos[cantidadRechazados] = apellidoSolicitudes[i];
    	   cantidadRechazados ++;  
       }
       }
	   //Entregar el estado en que quedo la solicitud(  Si fue admitida o rechazada y el resultado final de las solicitudes.
       System.out.println("Procesando solicitudes...");
       for (int k =0; k < cantidadIngresados;k ++) {
    	   System.out.println(" [OK] " + IngresadosNombres  [k] + " " + IngresadosApellidos [k] +  " -> admitido en "  +  IngresadosParalelos [k]  );
       }
       for (int c =0; c < cantidadRechazados;c ++) {
    	   System.out.println(" [RECHAZADO] " + RechazadosNombres  [c] + " " + RechazadosApellidos [c] +  " -> no pertenece a ningun paralelo"  );
       }
       System.out.println(" Resumen:" + cantidadIngresados + " admitidos /" + cantidadRechazados + " rechazados /"+ totalcantidadDuplicados + " duplicados");
       solicitudesProcesadas = true;
      
      }
    
     public  static void sobreescribirLista() {
		    try{
		        FileWriter filewrite = new FileWriter("Alumnos.txt");
		        BufferedWriter br = new BufferedWriter(filewrite);

		        for(int i=0; i<cantidadAlumnos; i++){
		            br.write(alumnos[i] + ";" + apellidoAlumno[i] + ";" + rutAlumno[i] + ";" + paraleloAlumno[i]);
		            br.newLine();
		        }

		        br.close();

		    } catch(Exception e){
		        System.out.println("Error en la sobre escritura del anuncio, contacte soporte tecnico");
		        System.out.println(e.getMessage());
		    }
		}


    public  static void cargarArchivos() {
		//Lectura de archivos y llenada de los arreglos sobre los alumnos y solicitudes.
		//asegurarse de que nos se hayan leído ya los archivos.
    	 if(cantidadAlumnos > 0 || cantidadSolicitudes > 0) {
    	        System.out.println("Los archivos ya fueron cargados.");
    	        return;
    	    }
		//Apertura de los archivos txt.
        File Archivo = new File("Alumnos.txt");
        File Archivo2 = new File("Solicitudes.txt");
        
        try (Scanner Lector = new Scanner(Archivo)){
        		
            while (Lector.hasNextLine()) {
				//dejar limitado la cantidad de datos que pueden entrar en caso de que haya más datos en los txt de los que pueden caber dentro las listas. 
            	if(cantidadAlumnos >= 100) {
            	    System.out.println("Se alcanzo la capacidad maxima de alumnos.");
            	    break;
            	}
            	 String Linea = Lector.nextLine();
            	 
                 String [] datos = Linea.split(";");
                 if (datos.length >= 4) {
					 //Llenado de la listas relacionadas con alumnos y actualizar el contador de los alumnos.
	                 alumnos[cantidadAlumnos] = datos[0]; 
	                 apellidoAlumno[cantidadAlumnos] = datos[1]; 
	                 rutAlumno[cantidadAlumnos] = datos[2]; 
	                 paraleloAlumno[cantidadAlumnos] = datos[3];
	                 
	                cantidadAlumnos++;
                 }
             
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro Alumnos.txt");
        }
        
        try (Scanner Lector = new Scanner(Archivo2)) {
            while (Lector.hasNextLine()) {
				//dejar limitado la cantidad de datos que pueden entrar en caso de que haya más datos en los txt de los que pueden caber dentro las listas. 
            	if(cantidadSolicitudes >= 100) {
            	    System.out.println("Se alcanzo la capacidad maxima de solicitudes.");
            	    break;
            	}
            	String Linea2 = Lector.nextLine();
            	String  [] datosSolicitudes = Linea2.split("-");
        	if(datosSolicitudes.length >= 2) {
				//Llenado de las listas de solicitudes
            	alumnosSolicitudes [cantidadSolicitudes] = datosSolicitudes [0];
            	apellidoSolicitudes [cantidadSolicitudes] = datosSolicitudes [1];
            	//Actualización de los datos  distintos de null que existen en solicitudes.
            	cantidadSolicitudes ++;
        	}
            }
           
        } catch (FileNotFoundException e) {

            System.out.println("No se encontro Solicitudes.txt");
        }
		//monstrar las cantidades de alumnos y solicitudes con las que se parte.
        System.out.println("Archivos cargados exitosamente !");
        System.out.println(cantidadAlumnos +" alumnos en la lista.");
        System.out.println(cantidadSolicitudes +" solicitudes de ingreso.");
        
    }


	}


