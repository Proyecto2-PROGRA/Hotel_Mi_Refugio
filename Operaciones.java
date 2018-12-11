
import java.io.*;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Operaciones extends ArchivoEntrada {
    private int max_personas = 0;
    private int personas = 0;

    private int nino;
    private Boolean bandera = false;

    Scanner entrada = new Scanner(System.in);
    Scanner entrada_1 = new Scanner(System.in);

    public Operaciones() {
    }

    public void FinalizarDia() {

        fecha.add(Calendar.DAY_OF_WEEK, 1);
        dia = fecha.get(Calendar.DAY_OF_MONTH);

    }

    public void Reservar() {

        System.out.println("Ingresar Fecha de llegada");
        

        String dia_llegada;
        String mes_llegada;
        String anio_llegada;

        String dia_salida;
        String mes_salida;
        String anio_salida;

        System.out.println("Ingrese la fecha de llegada");

        dia_llegada = IngresoFecha("dd");
        mes_llegada = IngresoFecha("mm");
        anio_llegada = IngresoFecha("aaaa");

        System.out.println("Ingrese la fecha de salida");
        dia_salida = IngresoFecha("dd");
        mes_salida = IngresoFecha("mm");
        anio_salida = IngresoFecha("aaaa");

        String fechaLlegada, fechaSalida;

        fechaLlegada = dia_llegada + " " + mes_llegada + " " + anio_llegada;
        fechaSalida = dia_salida + " " + mes_salida + " " + anio_salida;

        System.out.println(fechaLlegada + " " + fechaSalida);
        ////////////////////////////////////////////////////////////////////////////////
        int op;
        do {
            System.out.println("\t**************************************************");
            System.out.println("\t     -----> Tipo de habitacion a reservar <----- ");
            System.out.println("\t**************************************************");
            System.out.println("\t Opcion|Tipo de Habitacion|Nro. de camas|Nro. maximo personas");
            System.out.println("\t 1.     Individual         1             1");
            System.out.println("\t 2.     Matrimonial        1             2");
            System.out.println("\t 3.     Doble              2 + 1         3");
            System.out.println("\t 4.     Cuadruple          4             4");
            System.out.println("\t 5.     Suite              7 + 1         10");
            System.out.println("\t**************************************************");
            System.out.print("\tIngrese una opcion: ");
            op = entrada.nextInt();

            switch (op) {
            case 1:
                max_personas = 1;
                break;
            case 2:
                max_personas = 2;
                break;
            case 3:
                max_personas = 3;
                break;
            case 4:
                max_personas = 4;
                break;
            case 5:
                max_personas = 10;
                break;
            default:
                System.out.println(" Opcion no valida.");
            }

        } while (max_personas == 0);
        ///////////////////////////////////////////////// 7
        bandera = false;
        int personas = 0;
        int op_persona = 0;
        do {
            System.out.print("Ingrese la cantidad de personas a hospedar: ");
            personas = entrada.nextInt();
            if (personas <= max_personas) {
                bandera = true;
            } else if (personas > max_personas) {
                System.out.println("La cantidad de personas es mayor a lo soportado por esta abitacion");
                System.out.println("Opcion");
                System.out.println("1. Volver a escoger la abitacion");
                System.out.println("2. Ingresar nuevamente la cantidad de personas a hospedar");
                op_persona = entrada.nextInt();
                if (op_persona == 1) {
                    Reservar();
                }
            }
        } while (bandera != true);

        int op_edad;
        for (int i = 0; i < personas; i++) {


            int minuto = fecha.get(Calendar.MINUTE);
            int hora = fecha.get(Calendar.HOUR_OF_DAY);

            String titularNombre=" ";
            String titularApellido=" ";
            int rutTitular=0;
            int rutAcompanante=0;
            String acompananteNombre=" ";
            String acompananteApellido=" ";
            String tipo=" ";
            String Titular=" ";

            if (i == 0) {
                System.out.print("Ingrese el nombre del titular: ");
                titularNombre = entrada.next();

                System.out.print("Ingrese el apellido del titular: ");
                titularApellido = entrada.next();

                System.out.print("Ingrese el RUT del titular: ");
                rutTitular = entrada_1.nextInt();
                tipo = "A";
                Titular="Titular";

            } else if (i != 0) {
                System.out.println("Ingresar si es adulto o nino(menor de 10)");
                System.out.println("1. Adulto");
                System.out.println("2. Nino");
                op_edad = entrada.nextInt();
                if (op_edad == 1) {
                    System.out.println("Ingrese el nombre del acompanante");
                    acompananteNombre = entrada.next();

                    System.out.println("Ingrese el apellido del acompanante");
                    acompananteApellido = entrada.next();
                    System.out.println("Ingrese el RUT del acompanante");
                    rutAcompanante = entrada_1.nextInt();
                    tipo = "A";
                } else {
                    System.out.println("Ingrese el nombre del nino");
                    acompananteNombre = entrada.next();
                    System.out.println("Ingrese el apellido del nino");
                    acompananteApellido = entrada.next();
                    nino++;
                    tipo = "N";
                }
            }
            try {
                FileWriter fichero = new FileWriter("Reservar.csv", true);
                fichero.write(titularNombre+";"+titularApellido+";"+rutTitular+";"+acompananteNombre+";"+acompananteApellido+";"+rutAcompanante+";"+tipo+";"+fechaLlegada+";"+fechaSalida+";"+hora+":"+minuto+";"+Titular+"\n");
                fichero.close();
            } catch (IOException ex) {
            }
        }

        System.out.println("Reservo");

    }


    public void Cancelar() throws IOException  {
        
         BufferedReader in;
         try {
            in = new BufferedReader(new FileReader("Reservar.csv"));
            String line=" ";
             
             java.util.Scanner scanner = new Scanner(System.in);
             System.out.println("ingrese rut a buscar: ");
             String request = scanner.next();
             while((line = in.readLine())!= null){
                if(line.contains(request)){
                    bandera=true;
                 String[] campos = line.split(";");
                     System.out.print(campos[2]);
                     System.out.println("\n");
                     }
                
            }
             
             if(bandera==false){
                 
                 
                 System.out.println("no se encontro lo solicitado");
                 
             }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Chek_in()throws IOException {
        int minuto = fecha.get(Calendar.MINUTE);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        BufferedReader in;
         try {
            in = new BufferedReader(new FileReader("Reservar.csv"));
            String line=" ";
             
             java.util.Scanner scanner = new Scanner(System.in);
             System.out.println("ingrese rut a buscar: ");
             String request = scanner.next();
             while((line = in.readLine())!= null){
                if(line.contains(request)){
                    bandera=true;
                 String[] campos = line.split(";");
                     System.out.println(campos[2]+ " "+hora+":"+minuto);
                     System.out.println("Check-in Realizado con exito");
                     }
                
            }
             
             if(bandera==false){
                 
                 
                 System.out.println("no se encontro lo solicitado");
                 
             }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }


    public void Chek_out()throws IOException {
        bandera=false;
        int minuto = fecha.get(Calendar.MINUTE);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);

        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader("Reservar.csv"));
            String line=" ";
             
             java.util.Scanner scanner = new Scanner(System.in);
             System.out.println("ingrese rut a buscar: ");
             String request = scanner.next();
             while((line = in.readLine())!= null){
                if(line.contains(request)){
                    bandera=true;
                 String[] campos = line.split(";");
                     System.out.println(campos[2]+ " "+hora+":"+minuto);
                     System.out.println("Check-out Realizado con exito");
                     }
                
            }
             
             if(bandera==false){
                 
                 
                 System.out.println("no se encontro lo solicitado");
                 
             }


        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

 //////////////////////////////////////////////////////////////////
    public void Comer() throws FileNotFoundException {
        try {
            FileWriter fichero = new FileWriter("Comida.csv");
            
            fichero.close();
        } catch (IOException ex) {
        }
        
        int cantElementos;
        System.out.print("ingrese cantidad de elementos del menu: ");
        cantElementos=entrada.nextInt();
        
        //////////////////////////////////////////////////////////////////
        try {
            
            for(int i=0; i<cantElementos;i++){
                bandera=false;
      
                FileWriter fichero = new FileWriter("comida.csv", true);
                do{
                    System.out.println("\t**************************************************");
                    System.out.println("\t     -----> Tipo de plato a reservar <----- ");
                    System.out.println("\t**************************************************");
                    System.out.println("\t 1.     Espaguetis a la Carbonara = $55.00 ");
                    System.out.println("\t 2.     Lomito a la Mostaza = $71.50");
                    System.out.println("\t 3.     Jugo light = $10.00");
                    System.out.println("\t 4.     Malta = $6.00");
                    System.out.println("\t**************************************************");
                    System.out.print("\tIngrese una opcion: ");
                    int varSeleccion;
                    varSeleccion=entrada.nextInt();
                    if(i==0){
                    fichero.append(cantElementos+"\r\n");
                }
                    
                    switch(varSeleccion){
                        case 1: 
                                fichero.write("ESP_C");
                                fichero.append("\r\n");
                                bandera=true;
                                break;
                        case 2:                    
                                fichero.write("LOM_M");
                                fichero.append("\r\n");
                                bandera=true;
                                break;
                        case 3: 
                                
                                fichero.write("JUG_L");
                                fichero.append("\r\n");
                                bandera=true;
                                break;
                        case 4: 
                                
                                fichero.write("MALTA");
                                fichero.append("\r\n");
                                bandera=true;
                                break;
        
                        default:
                            System.out.println(" Opcion no valida.");
                    }



                }while(bandera!=true);
            //fichero.write("\n");
                System.out.println("se agrego correctamente");
                
            fichero.close();
            }
            
        } catch (IOException ex) {
        }
                try {
            FileReader lector = new FileReader("comida.csv");
            BufferedReader BR = new BufferedReader(lector);

            while ((cadena = BR.readLine()) != null) {
                System.out.println(cadena);
            }

            BR.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }
 //////////////////////////////////////////////////////////////////
    public void SolicitarServicios() throws IOException {
        
        
        
        try {
            FileWriter fichero = new FileWriter("Servicios.csv");
            
            fichero.close();
        } catch (IOException ex) {
        }
        /// //// /// ///
         BufferedReader in;
         
        int cantElementos;
        do {
            System.out.print("ingrese cantidad de servicio a solicitar: ");
            cantElementos=entrada.nextInt();
            if(cantElementos<=2){
                bandera=true;
            }else{
                System.out.println("El numero ingresado es mayor al esperado (max 2)");
                bandera=false;
            }
        } while (bandera!=true);
        
        
        //////////////////////////////////////////////////////////////////
        try {

        bandera=false;
        FileWriter fichero = new FileWriter("Servicios.csv",true);

        in = new BufferedReader(new FileReader("Reservar.csv"));
        String line=" ";
        java.util.Scanner scanner = new Scanner(System.in);
           
        System.out.println("ingrese rut a buscar: ");
        String BuscarRut = scanner.next();
           
        while((line = in.readLine())!= null){
            if(line.contains(BuscarRut)){
                bandera=true;
                String[] campos = line.split(";");
                System.out.print(campos[2]);
                System.out.println("\n");
            }
        }
        if(bandera==false){
            System.out.println("no se encontro el rut solicitado");

        }else{
            for(int i=0; i<cantElementos;i++){
                bandera=false;
                do{
                

                if(i==0){        
                    fichero.append(BuscarRut+"\r\n");
                    fichero.append(cantElementos+"\r\n");
                }
                if (cantElementos == 1) {
                    System.out.println("\t     -----> Tipo de servicio a reservar <----- ");
                    System.out.println("\t**************************************************");
                    System.out.println("\t 1.     cama adicional");
                    System.out.println("\t 2.     caja fuerte");
                            
                    System.out.println("\t**************************************************");
                    System.out.print("\tIngrese una opcion: ");

                    int varSeleccion = entrada.nextInt();
                    switch(varSeleccion){
                        case 1: 
                                fichero.write("CAM_A");
                                fichero.append("\r\n");
                                bandera=true;
                                System.out.println("Se agrego cama");
                                break;
                        case 2:                    
                                fichero.write("CAJ_F");
                                fichero.append("\r\n");
                                bandera=true;
                                System.out.println("Se agrego cama");
                                break;
        
                        default:
                            System.out.println(" Opcion no valida.");
                    }
                } else {
                    fichero.write("CAM_A");
                    fichero.append("\r\n");
                    System.out.println("Se agrego cama");
                    fichero.write("CAJ_F");
                    fichero.append("\r\n");
                    System.out.println("Se agrego caja fuerte");
                    bandera=true;
                    break;
                    
                }
                
                }while(bandera!=true);
                        

            }
            System.out.println("se agrego correctamente");
                
            fichero.close();
        }

            
            
        } catch (IOException ex) {
        }
                try {
            FileReader lector = new FileReader("Servicios.csv");
            BufferedReader BR = new BufferedReader(lector);

            while ((cadena = BR.readLine()) != null) {
                System.out.println(cadena);
            }

            BR.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }

    
    public void Reportes() {
        System.out.println("reporte realizado");

    }

    public String IngresoFecha(String formato) {
        String fecha;
        SimpleDateFormat df;
        Date testDate;
        String date;
        bandera = false;
        Scanner sc = new Scanner(System.in);
        bandera = false;
        do {
            System.out.println("Introduzca la fecha con formato " + formato);

            fecha = sc.nextLine();

            if (formato.equals("dd")) {
                df = new SimpleDateFormat("dd");
            } else if (formato.equals("mm")) {
                df = new SimpleDateFormat("MM");
            } else {
                df = new SimpleDateFormat("yyyy");
            }

            testDate = null;
            date = fecha;
            try {
                testDate = df.parse(date);
                System.out.println("Ahora hemos creado un objeto date con la fecha indicada, " + testDate);
            } catch (Exception e) {
                System.out.println("invalid format");
                bandera = false;
            }

            if (!df.format(testDate).equals(date)) {
                System.out.println("invalid date!!");
                bandera = false;
            } else {
                System.out.println("valid date");
                System.out.println(date);
                bandera = true;
            }
        } while (bandera != true);

        return fecha;

    }

}