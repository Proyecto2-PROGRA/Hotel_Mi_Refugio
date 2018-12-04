import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoEntrada extends Persona {
    protected String ValorHotel;
    protected String Fecha;
    protected String Habitaciones;
    protected String Piso;
    protected String Servicio;
    protected String cadena;
    protected String n;//Guarda el numero de abitaciones como string para luego guardarlo en fichero(Habitaciones)
    protected String n_1;//Guarda el numero de pisos como string para luego guardarlo en fichero(Piso)
    protected int NumeroPiso;
    protected int NumeroHabitaciones;
    protected int TipoDeHabitacion;
    protected int Menu;

    
    List<String> ListaTipoHabitacion = new ArrayList<>();


    public ArchivoEntrada() {
    }

    public void Inicializar_in() {
        ValorHotel="100250.00";
        Fecha = "22 10 2018";
        try {
            FileWriter fichero = new FileWriter("inicializar.txt");
            fichero.write(ValorHotel);
            fichero.append("\r\n"); 

            fichero.write(Fecha);
            fichero.append("\r\n");

            NumeroPiso = (int) (Math.random() * 10) + 1;

            String n_1 = Integer.toString(NumeroPiso);
            fichero.write(" "+n_1);
            fichero.append("\r\n"); 


            for (int x=0; x < NumeroPiso;x++){
                NumeroHabitaciones = (int) (Math.random() * 10) + 1;
                ListaTipoHabitacion.get(x).add(new ArrayList<String>());

                for(int i=0; i < NumeroHabitaciones; i++){
                    TipoDeHabitacion =(int) (Math.random() * 5) + 1;
                    String Habitacion = Integer.toString(TipoDeHabitacion);
                    
                    ListaTipoHabitacion.get(i).add(Habitacion);
                    
                }

                /*
                String n = Integer.toString(NumeroHabitaciones);
                fichero.write(n);
                */
                fichero.append("\r\n");

            }

            
            

            

            
            
            fichero.close();

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        try {
            FileReader lector = new FileReader("inicializar.txt");
            BufferedReader BR = new BufferedReader(lector);
            
            while((cadena=BR.readLine())!=null){
                System.out.println(cadena);
            }

    
            BR.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            // TODO: handle exception
        }

    }

    public void Precios_in() {

    }

    public void Operaciones_in() {
        Operaciones o = new Operaciones();

        o.Comer();

    }

}