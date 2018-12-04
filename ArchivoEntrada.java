import java.io.*;

public class ArchivoEntrada extends Persona {
    protected int ValorHotel;
    protected String Fecha;
    protected String Habitaciones;
    protected int Piso;
    protected String Servicio;
    protected int Menu;

    public ArchivoEntrada() {
    }

    public void Inicializar_in() {
        try {
            FileWriter fichero = new FileWriter("inicializar.txt");
            fichero.write("Holaaaaaaaaaaaaaa");
            fichero.close();

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        try {
            FileReader lector = new FileReader("inicializar.txt");
            BufferedReader BR = new BufferedReader(lector);
            System.out.println(BR.readLine());
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