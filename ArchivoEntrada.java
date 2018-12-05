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
            // TODO: handle exception
        }

    }

    public void Precios_in() {

        Habitaciones h = new Habitaciones();

        String Individual = h.getIndividual();
        String Doble = h.getDoble();
        String Matrimonial = h.getMatrimonial();
        String Cuadruple = h.getCuadruple();
        String Suite = h.getSuite();

        Servicios s = new Servicios();
        String Cam_A = s.getCam_A();
        String Caj_F = s.getCaj_F();
        String Esp_C = s.getEsp_C();
        String Lom_M = s.getLom_M();
        String Jug_L = s.getJug_L();
        String Malta = s.getMalta();

        try {
            FileWriter fichero = new FileWriter("Operaciones.in.txt");
            fichero.write("5 2 4");

            fichero.write("\nINDIV: " + Individual);
            fichero.write("\nDOBLE: " + Doble);
            fichero.write("\nMATRI: " + Matrimonial);
            fichero.write("\nCUADR: " + Cuadruple);
            fichero.write("\nSUITE: " + Suite);

            fichero.write("\nCAM_A:  " + Cam_A + " Cama dicional");
            fichero.write("\nCAJ_F:  " + Caj_F + " Caja Fuerte");
            fichero.write("\nESP_C:  " + Esp_C + " Espaguetis a la Carbonara");
            fichero.write("\nLOM_M:  " + Lom_M + " Lomito a la Mostaza");
            fichero.write("\nJUG_L:  " + Jug_L + " Jugo light");
            fichero.write("\nMALTA:   " + Malta + " Malta");

            fichero.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {

            FileReader lector = new FileReader("Operaciones.in.txt");
            BufferedReader BR = new BufferedReader(lector);

            while ((cadena = BR.readLine()) != null) {
                System.out.println(cadena);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void Operaciones_in() {
        Operaciones o = new Operaciones();

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero solicitado: ");
        int num_case = sc.nextInt();

        switch (num_case) {
        case 0:
            o.FinalizarDia();
            break;
        case 1:

            break;
        case 2:

            break;
        case 3:

            break;
        case 4:

            break;
        case 5:

            break;
        case 6:

            break;
        case 7:

            break;

        default:
            break;
        }
        sc.close();

    }

}