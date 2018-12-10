import java.io.*;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

import java.text.SimpleDateFormat;

public class Operaciones extends ArchivoEntrada {
    private int max_personas = 0;
    private int personas = 0;
    private String titular;
    private int rut_titular;
    private String acompanante;
    private int rut_acompanante;
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

        try {
            FileWriter lector = new FileWriter("Reservar.csv", true);
            BufferedWriter BR = new BufferedWriter(lector);
            PrintWriter pv = new PrintWriter(BR);
            pv.println(fechaLlegada + ";" + fechaSalida);
            pv.flush();

        } catch (Exception e) {
        }

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

            if (i == 0) {
                System.out.print("Ingrese el nombre del titular: ");
                titular = entrada.next();
                System.out.print("Ingrese el RUT del titular: ");
                rut_titular = entrada_1.nextInt();

            } else if (i != 0) {
                System.out.println("Ingresar si es adulto o nino(menor de 10)");
                System.out.println("1. Adulto");
                System.out.println("2. Nino");
                op_edad = entrada.nextInt();
                if (op_edad == 1) {
                    System.out.println("Ingrese el nombre del acompanante");
                    acompanante = entrada.next();
                    System.out.println("Ingrese el RUT del acompanante");
                    rut_acompanante = entrada_1.nextInt();
                } else {
                    System.out.println("Ingrese el nombre del nino");
                    acompanante = entrada.next();
                    nino++;
                }
            }
        }

        System.out.println("Reservo");

    }

    public void Cancelar() {
        System.out.println("cancelo");

    }

    public void Chek_in() {
        System.out.println("realizo check-in");

    }

    public void Chek_out() {
        System.out.println("realizo check-out");

    }

    public void Comer() {
        System.out.println("comio");

    }

    public void SolicitarServicios() {
        System.out.println("solicito servicios");

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

            if (formato.equals("aa")) {
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
