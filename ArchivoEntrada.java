import java.io.*;

public class ArchivoEntrada extends Persona {
    protected String ValorHotel;
    protected String Fecha;
    protected String Habitaciones;
    protected String Piso;
    protected String Servicio;
    protected String cadena;
    protected String n;
    protected String n_1;
    protected int numeroPiso;
    protected int numeroHabitaciones;
    protected int Menu;

    public ArchivoEntrada() {
    }

    public void Inicializar_in() {
        ValorHotel="100250.00";
        Fecha = "22 10 2018";
        Habitaciones="4";
        Piso="2";
        try {
            FileWriter fichero = new FileWriter("inicializar.txt");
            fichero.write(ValorHotel);
            fichero.append("\r\n"); 
            fichero.write(Fecha);
            fichero.append("\r\n"); 
            numeroHabitaciones = (int) (Math.random() * 10) + 1;
            String n = Integer.toString(numeroHabitaciones);
            fichero.write(n);
            numeroPiso = (int) (Math.random() * 10) + 1;
            String n_1 = Integer.toString(numeroPiso);
            fichero.write(" "+n_1);
            fichero.append("\r\n"); 
            for (int i = 0; i < numeroPiso; i++) {
                
            }
            fichero.write("4");
            fichero.append("\r\n"); 
            fichero.write("2");
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