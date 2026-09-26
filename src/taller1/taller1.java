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
				//Métodos donde se hará el desarrollo del código.
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
		//Generar reporte. Escoger primero el tipo de reporte a hacer.
		System.out.println("Ingrese el tipo de reporte que quiere crear:  \n1) Reporte paralerlo C1  \n2) Reporte paralerlo C2 \n3)Reporte sobre los Rechazados  ");
        System.out.println();
        String selec=scanner.nextLine();
        int seleccion=Integer.parseInt(selec);
		//Control de error sobre la opción que se  ingresa.
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
		//Hacer un archivo txt con los datos de los alumnos rechazados.
		try{
			System.out.println("Ingreso rechazo");
	         String Rechazados="Rechazados-V "+contadorReporteRechazados+".txt";//con el numero correspondiente que le pertenece.
	         File file =new File(Rechazados);
	         if(file.createNewFile()){//Si el archivo no existe se crea.
	            FileWriter fw= new FileWriter(file);//Creación del archivo txt.
	            BufferedWriter bw= new BufferedWriter(fw);
	            String titulo="=== Miembros del grupo - Rechazados ===";
	            bw.write(titulo);//Escritura de la primera linea del archivo.
	            bw.newLine();//Escritura de un salto de linea.
	            for(int i=0; i< cantidadRechazados;i++){
	                if(RechazadosNombres[i] != null){
	                    String dato=""+RechazadosNombres[i]+";"+RechazadosApellidos[i];
	                    bw.write(dato);//Escritura de una linea.
	                    bw.newLine();//Escritura de un salto de linea.
	                	}
	            	

	            }
				 //Actualización de contador reporte rechazados.
	            contadorReporteRechazados++;
	            bw.close();
	            fw.close();
	                     
	            
	         }else{
	            	System.out.println("Archivo"+Rechazados+" ya creado");//Si el archivo ya ha sido creado sañta aquí y envía este mensaje.
	            }
	        }catch(Exception e){
	            System.out.println("Error al ingresar Archivo" + e.getMessage());
	        }
		
	}


	public static void reporteCDos() {
		
		//Reporte de los alumnos ingresados  pertenecientes al paralelo C2
		try{
	         String nombreCDos="ReporteC2-V "+contadorReporteCDos+".txt";//Nombre el archivo del reporte.
	         File file =new File(nombreCDos);//Nombre del archivo.
	         if(file.createNewFile()){//Si el archivo txt con ese nombre no ha sido creado, se crea. 
	            FileWriter fw= new FileWriter(file);
	            BufferedWriter bw= new BufferedWriter(fw);//Escritura en el archivo.
	            String titulo="=== Miembros del grupo - Paralelo C2 ===";//Primero linea del documento.
	            bw.write(titulo);//Escribir el título del texto.
	            bw.newLine();//Escribir una nueva línea. 
	            for(int i=0; i< cantidadIngresados;i++){
	            	
	                if(IngresadosParalelos[i].equalsIgnoreCase("C2")){
	                    String dato=""+IngresadosNombres[i]+";"+IngresadosApellidos[i]+";"+IngresadosRuts[i]+";"+IngresadosParalelos[i];//Crea la línea con los datops. 
	                    bw.write(dato);//Escribir línea en el texto.
	                    bw.newLine();//Escribir salto de línea.
	                		}
	                
	            		}
	            	
	            contadorReporteCDos++;//Actualizar la cantidad de reportes creados sobre el paralelo dos.
	            bw.close();
	            fw.close();
	                     
	            
	         }else{
	            	System.out.println("Archivo "+nombreCDos+" ya creado");//El archivo con ese nombre ya ha sido creado.
	            }
	        }catch(Exception e){
	            System.out.println("Error al ingresar Archivo" + e.getMessage());
	        }
		
	}


	public static void reporteCUno() {
		//Reporte de los alumnos ingresados  pertenecientes al paralelo C1.
		
		 try{
	         String nombreCUno="ReporteC1-V "+contadorReporteCUno+".txt";//Nombre el archivo del reporte.
	         File file =new File(nombreCUno);//Nombre del archivo.
	         if (file.createNewFile()) {//Si el archivo txt con ese nombre no ha sido creado, se crea. 
		         FileWriter fw = new FileWriter(file);//Abrir archivo para sobre escritura.
		         BufferedWriter bw= new BufferedWriter(fw);//Escritura en el archivo.
		         String titulo="=== Miembros del grupo - Paralelo C1 ===";//Primero linea del documento.
		         bw.write(titulo);//Escribir el título del texto.
	             bw.newLine();//Escribir una nueva línea. 
		         for(int i=0; i< cantidadIngresados;i++){
		            	 
		                if(IngresadosParalelos[i].equalsIgnoreCase("C1")){
		                    String dato=""+IngresadosNombres[i]+";"+IngresadosApellidos[i]+";"+IngresadosRuts[i]+";"+IngresadosParalelos[i];//Creación de la linea que se escribirá.
		                    System.out.println(dato);
		                    bw.write(dato);//Escribir el dato en el documento.
		                    bw.newLine();//Escribir un salto de Línea.
		                	}
		            
	         }
	         contadorReporteCUno++;//Actualización de la cantidad de reportes sobre el paralelo C1.
	         bw.close();
	         fw.close();
	         }else {
	            	System.out.println("Archivo"+nombreCUno+" ya creado");//En caso de el archivo ya haya sido creado, saldrá este mensaje.
	        
	         }
	        }catch(Exception e){
	            System.out.println("Error al ingresar Archivo" + e.getMessage());
	        }
	}
	        
		
	


	public  static void analisisEstadistico () {
		System.out.println("Analisis estadistico rechazados y admitidos ");
		if (cantidadSolicitudes == 0) {//Control de error.
            System.out.println("No hay solicitudes cargadas.");
            return;
        }
		
		double porcentajeRechazo = ((double)cantidadRechazados / cantidadSolicitudes) * 100;//Cálculo de porcentaje Rechazo. 
		double tasaAdmision = ((double)cantidadIngresados / cantidadSolicitudes) * 100;//Calculo de tasa de admisión.
		int cantidadC1 = 0;
	    int cantidadC2 = 0;

		    for(int i=0; i<cantidadAlumnos; i++) {
		        if(paraleloAlumno[i].equalsIgnoreCase("C1")) {
		            cantidadC1++;//Contador de alumnos pertenecientes al paralelo C1.
		        }
		        if(paraleloAlumno[i].equalsIgnoreCase("C2")) {
		            cantidadC2++;//Contador de alumnos pertenecientes al paralelo C2.
		        }
		    }
		    double porcentajeC1 = ((double)cantidadC1 / cantidadAlumnos) * 100;//Cálculo del porcentaje de C1
		    double porcentajeC2 = ((double)cantidadC2 / cantidadAlumnos) * 100;//Cálculo del porcentaje de C2.
			//Mostrar los resultados que se cálcularon..
		    System.out.println("Porcentaje de rechazo: " + porcentajeRechazo + "%");
		    System.out.println("Tasa de admision: " + tasaAdmision + "%");	    
		    System.out.println("Porcentaje de alumnos en C1: " + porcentajeC1 + "%");
		    System.out.println("Porcentaje de alumnos en C2: " + porcentajeC2 + "%");
		}
	
    public  static void administracionCurso() {
    	//Administrar el curso.
       System.out.println("Administracion del curso");
       System.out.println("Seleccione una  opcion:");
       System.out.println("1) Cambiar paralelo de un alumno");
       System.out.println("2) Eliminar alumno del curso");
       System.out.println("3) Inscribir alumno nuevo");
       System.out.println("4) Volver al menu principal");
       //Selección de la opción 
       System.out.println("Ingrese opcion: ");
       String  opcion=scanner.nextLine();
       //control de error en caso de ingresar una opción inválida.
       while(!opcion.equalsIgnoreCase("1") && !opcion.equalsIgnoreCase("2") 
    		&& !opcion.equalsIgnoreCase("3") && !opcion.equalsIgnoreCase("4")){
    	   	System.out.println("Opcion invalida, ingrese nuevamente");	
    	   	opcion=scanner.nextLine();
    	   	
       }
       //Llamar al método que se utilizará.
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
        //Método para agregar alumnos.
        if(cantidadAlumnos >= 100) {//control de error en caso de ya tener la capacidad máxima y no se puede agregar más.
        	System.out.println("No se pueden agregar mas alumnos,supero la capacidad maxima admitida");
        	return;
        }
        
        System.out.println("Ingrese el nombre del nuevo alumno: ");
        String nombreNuevo = scanner.nextLine();//Ingreso del  nombre
        while(nombreNuevo.equals("")) {//Control de error en caso de que se ingrese el nombre erroneo erroneo.
            System.out.println("El nombre no puede estar vacio.");
            System.out.println("Ingrese nuevamente el nombre:");
            nombreNuevo = scanner.nextLine();//Volver a ingresar el Nombre.
        }
        
        System.out.println("Ingrese el apellido del estudiante: ");
        String apellidoNuevo=scanner.nextLine();//Ingresar el apellido nuevo.
        while(apellidoNuevo.equals("")) { //control de error en caso de ingresar un apellido inválido.
            System.out.println("El apellido no puede estar vacio.");
            System.out.println("Ingrese nuevamente el apellido:");
            apellidoNuevo = scanner.nextLine();
        }
        
        System.out.println("Ingrese el rut del nuevo alumno: ");
        String rutNuevo=scanner.nextLine();//Ingrese el rut del alumno.
        while(rutNuevo.equals("")) { //Control de error en caso de ingresar un rut erroneo.
            System.out.println("El rut no puede estar vacio.");
            System.out.println("Ingrese nuevamente el rut:");
            rutNuevo = scanner.nextLine();
        }
        
        for(int i=0; i<cantidadAlumnos; i++) {
            if(rutNuevo.equalsIgnoreCase(rutAlumno[i])) {//En caso de que el rut ya existe, es inválido como nuevo rut, por que los ruts son únicos. 
                System.out.println("Ese RUT ya pertenece a un alumno.");
                return;
            }
        }
        System.out.println("ingrese el paralelo (C1/C2) del nuevo alumno: ");
        String paraleloNuevo = scanner.nextLine();//Ingresar el paralelo al que pertenece.
        while(!paraleloNuevo.equalsIgnoreCase("C1") &&
                !paraleloNuevo.equalsIgnoreCase("C2")) {//Control de error al ingresar el paralelo.

              System.out.println("Paralelo invalido solo puede ser C1 o C2.");
              System.out.println("Ingrese nuevamente el paralelo:");
              paraleloNuevo = scanner.nextLine();
          }
		//Ingresar los datos en las listas.
        alumnos[cantidadAlumnos] = nombreNuevo; 
        apellidoAlumno[cantidadAlumnos] = apellidoNuevo; 
        rutAlumno[cantidadAlumnos] = rutNuevo; 
        paraleloAlumno[cantidadAlumnos] = paraleloNuevo; 
        cantidadAlumnos++;// actualización en la cantidad de alumnos.
        sobreescribirLista(); 
        System.out.println("Alumno agregado correctamente.");
    }


    public static void eliminarAlumnoCurso() {//Eliminar el alumno del curso.
        System.out.println("Ingrese el rut del alumno que desee eliminar.");
        String rutEliminar = scanner.nextLine();//Ingresar valor del rut. 
        
        int indiceEliminar = buscarIndiuce(rutEliminar);
        if(indiceEliminar == -1) {//En caso de que no exista el rut en la lista.
        	System.out.println("No se encontro un alumno con ese rut");
            return;
        }
        eliminar(indiceEliminar);//Eliminar el dato.
        }
    
    public static void eliminar(int indiceEliminar) {//Método para eliminar Datos.
        String rutEliminado = rutAlumno[indiceEliminar];//Dato para eliminar.
        
        for(int i = 0; i < cantidadIngresados; i++) {
            if(rutEliminado.equalsIgnoreCase(IngresadosRuts[i])) {//Buscar datos de del alumno a eliminar.
                for(int j = i; j < cantidadIngresados - 1; j++) {//Actualizar el orden de las listas una vez eliminado los datos.
                    IngresadosNombres[j] = IngresadosNombres[j + 1];
                    IngresadosApellidos[j] = IngresadosApellidos[j + 1];
                    IngresadosRuts[j] = IngresadosRuts[j + 1];
                    IngresadosParalelos[j] = IngresadosParalelos[j + 1];
                }
				//Eliminar el dato final, se tranforma en null.
                IngresadosNombres[cantidadIngresados - 1] = null;
                IngresadosApellidos[cantidadIngresados - 1] = null;
                IngresadosRuts[cantidadIngresados - 1] = null;
                IngresadosParalelos[cantidadIngresados - 1] = null;

                cantidadIngresados --;//Actualizar la cantidad de Ingresados.
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
			//Cambiar el orden despies de eliminar el dato.
            alumnos[i] = alumnos[i+1];
            apellidoAlumno[i] = apellidoAlumno[i+1];
            rutAlumno[i] = rutAlumno[i+1];
            paraleloAlumno[i] = paraleloAlumno[i+1];

        }
		//Eliminar el dato final, se tranforma en null.
        alumnos[cantidadAlumnos-1] = null;
        apellidoAlumno[cantidadAlumnos-1] = null;
        rutAlumno[cantidadAlumnos-1] = null;
        paraleloAlumno[cantidadAlumnos-1] = null;

        cantidadAlumnos--;//Actualizar la cantidad de alumnos.
    }
    

    public  static void cambiarParalelo() {//metodo para cambio de paralelo.
       System.out.println("Ingrese el rut del alumno: ");
       String rutIngresado = scanner.nextLine();
       
       int indice = buscarIndiuce(rutIngresado);

       if(indice == -1) {//en casod e que no se encuentre el rut
           System.out.println("No se encontro un alumno con ese RUT.");
           return;
       }
       
       buscarRUT(rutIngresado);
       String paraleloNuev=null;

       while (paraleloNuev==null || !paraleloNuev.equalsIgnoreCase("C1") && !paraleloNuev.equalsIgnoreCase("C2") ) {//Control de error.
            System.out.println("Nuevo paralelo (C1/C2):  ");
            paraleloNuev=scanner.nextLine();
            
            if (!paraleloNuev.equalsIgnoreCase("C1") &&
                    !paraleloNuev.equalsIgnoreCase("C2")) {
            	System.out.println("Paralelo invalido");
            }
        }
        cambiarParaleloEfectivo(paraleloNuev,rutIngresado);
        sobreescribirLista();//Cambiar los valores en el archivo txt.
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

    public  static void cambiarParaleloEfectivo(String paraleloNuev, String rutIngresado) {//Realizar el cambio de paralelo.
                int indice=buscarIndiuce(rutIngresado);//Se busca el indice.
                if(indice == -1) {//En caso de que no se necuentre el rut.
                    System.out.println("No se encontro un alumno con ese rut");
                    return;
                }
                paraleloAlumno[indice] = paraleloNuev;//Cambiar el paralelo al que pertenece el alumno.
                for(int i=0; i<cantidadIngresados; i++) {
                    if(rutIngresado.equalsIgnoreCase(IngresadosRuts[i])) {//Se tiene que hacer el cambio tambien en la lista de ingresados.
                        IngresadosParalelos[i] = paraleloNuev;
                        break;
                    }
                }
            }
              

        
    public  static int buscarIndiuce(String rutIngresado) {//Buscar el indice del rut.
		for(int i=0; i< cantidadAlumnos; i++){
			if(rutIngresado.equalsIgnoreCase(rutAlumno[i])){//Recorrer la lista de ruts del alumno para retornar su posición en la lista.
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
		//Método para inscribir por nombre.
        System.out.println("Ingrese el nombre del alumno:");//Inicialización de las variables a utilizar.
        String nombreNuevo = null;
        String apellidoNuevo = null;

        try {
            nombreNuevo = scanner.nextLine();//Ingreso del nombre a Ingresar.
            while(nombreNuevo.equals("")) {//Control de error.
                System.out.println("El nombre no puede estar vacio.");
                System.out.println("Ingrese nuevamente el nombre:");
                nombreNuevo = scanner.nextLine();
            }
            System.out.println("Ingrese el apellido que quiere ingersar: ");
            apellidoNuevo = scanner.nextLine();
            while(apellidoNuevo.equals("")) {//Control de error.
                System.out.println("El apellido no puede estar vacio.");
                System.out.println("Ingrese nuevamente el apellido:");
                apellidoNuevo = scanner.nextLine();
            }
        } catch(Exception e) {

            System.out.println(e.getMessage());
        }

        boolean yaExiste = false;

        if(cantidadIngresados >= 100) {//Control de error en caso de que ya se tenga el máximo de integrantes ingresados.
            System.out.println("No se pueden ingresar mas alumnos al grupo.");
            return;
        }

        for(int i=0; i<cantidadIngresados; i++) {
			//Se busca el caso de que el alumno ya este ingresado.
            if(nombreNuevo.equalsIgnoreCase(IngresadosNombres[i]) && 
                    apellidoNuevo.equalsIgnoreCase(IngresadosApellidos[i])) {

                System.out.println("El alumno ya ha sido ingresado al chat");

                yaExiste = true;

                break;
            }
        }

        if (!yaExiste) {//En caso de que el alumno no se en los nombres ingresados.
            for(int i=0; i<cantidadAlumnos; i++) {
                if(nombreNuevo.equalsIgnoreCase(alumnos[i]) &&
                        apellidoNuevo.equalsIgnoreCase(apellidoAlumno[i])) {//Buscar los datos del alumno por  nombre y apellido
                    System.out.println("Solicitud de " + nombreNuevo + " " + apellidoNuevo 
                            + " -> admitido en el chat");
                    System.out.println("Es alumno ingresar al grupo");//Se encontraron los datos y se guardaran en la lista Ingresados.
                    IngresadosNombres[cantidadIngresados] = nombreNuevo;
                    IngresadosApellidos[cantidadIngresados] = apellidoNuevo;
                    IngresadosRuts[cantidadIngresados] = rutAlumno[i];
                    IngresadosParalelos[cantidadIngresados] = paraleloAlumno[i];

                    cantidadIngresados++;//Actualización de la cantidad de Ingresados.

                    yaExiste = true;

                    break;
                }
            }
        }
		//Rechazo del alumno por no encontrar datos sobre a que paralelo pertenecec.
        if(!yaExiste) {
            System.out.println("El alumno no pertenece a ningun paralelo");
            RechazadosNombres[cantidadRechazados] = nombreNuevo;
            RechazadosApellidos[cantidadRechazados] = apellidoNuevo;
            cantidadRechazados++;
            System.out.println("Rechazado Solicitud de " + nombreNuevo + " " 
                    + apellidoNuevo + "-> no pertenece a ningun paralelo");
        }
    }
    
    public static boolean alumnoYaIngresado(String rut) {//Buscar rut de alumno en los Ingrsados para saber si ya existe en esta lista.
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

    				    encontrado = true;//El dato ha sido encontrado.

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
		        FileWriter filewrite = new FileWriter("Alumnos.txt");//Abrir el archivo paara rescribir.
		        BufferedWriter br = new BufferedWriter(filewrite);//Prepararse para escribir.

		        for(int i=0; i<cantidadAlumnos; i++){
		            br.write(alumnos[i] + ";" + apellidoAlumno[i] + ";" + rutAlumno[i] + ";" + paraleloAlumno[i]);//Rescribir todos los valores del archivo txt con lo que se encuntra en las listas que tienen datos de los alumnos.
		            br.newLine();//Escribir salto de linea.
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


