import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ArchivoEntrada extends Persona {
    Date fecha = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
    String fechanueva = sdf.format(fecha);

    protected String ValorHotel;
    protected String Fecha = fechanueva.toString();
    protected String Habitaciones;
    protected String Piso;
    protected String Servicio;
    protected String cadena;
    protected String n;// Guarda el numero de abitaciones como string para luego guardarlo en
                       // fichero(Habitaciones)
    protected String n_1;// Guarda el numero de pisos como string para luego guardarlo en fichero(Piso)
    protected int NumeroPiso;
    protected int NumeroHabitaciones;
    protected int TipoDeHabitacion;
    protected int Menu;
    protected int cont;
    protected int num_case;

    public ArchivoEntrada() {
    }

    public void Inicializar_in() {
        ValorHotel = "100250.00";
        try {
            FileWriter fichero = new FileWriter("inicializar.in.txt");
            fichero.append(ValorHotel);
            fichero.write("\r\n");

            fichero.write(Fecha);
            fichero.append("\r\n");

            NumeroPiso = (int) (Math.random() * 10) + 1;
            List<String>[] ListaTipoHabitacion = new List[NumeroPiso];

            String n_1 = Integer.toString(NumeroPiso);

            for (int x = 0; x < NumeroPiso; x++) {
                NumeroHabitaciones = (int) (Math.random() * 5) + 1;

                List<String> ListaHabitacion = new ArrayList<>();

                for (int i = 0; i < NumeroHabitaciones; i++) {
                    TipoDeHabitacion = (int) (Math.random() * 5) + 1;
                    String Habitacion = Integer.toString(TipoDeHabitacion);

                    ListaHabitacion.add(Habitacion);
                    cont++;

                }
                ListaTipoHabitacion[x] = ListaHabitacion;

            }
            String contador = Integer.toString(cont);
            fichero.write(contador + " ");
            fichero.write(n_1);
            fichero.append("\r\n");

            for (int x = 0; x < NumeroPiso; x++) {
                List<String> LH = new ArrayList<>();

                fichero.write(ListaTipoHabitacion[x].size() + " ");

                LH.addAll(ListaTipoHabitacion[x]);

                for (int y = 0; y < ListaTipoHabitacion[x].size(); y++) {

                    String var = LH.get(y);

                    if (var.equals("1")) {
                        fichero.write("INDIV" + " ");

                    } else if (var.equals("2")) {
                        fichero.write("MATRI" + " ");

                    } else if (var.equals("3")) {
                        fichero.write("DOBLE" + " ");

                    } else if (var.equals("4")) {
                        fichero.write("CUADR" + " ");

                    } else if (var.equals("5")) {
                        fichero.write("SUITE" + " ");

                    }
                }
                fichero.append("\r\n");

            }

            fichero.close();

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        try {
            FileReader lector = new FileReader("inicializar.in.txt");
            BufferedReader BR = new BufferedReader(lector);

            while ((cadena = BR.readLine()) != null) {
                System.out.println(cadena);
            }

            BR.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }

    }

    public void Precios_in() {

    }

    public void Operaciones_in() {
        Operaciones o = new Operaciones();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la opcion");
        num_case = sc.nextInt();

        switch (num_case) {
            case 0:
                o.FinalizarDia();
                break;
        
            default:
                break;
        }
        
        sc.close();
    }

}