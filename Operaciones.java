import java.io.*;
import java.util.Date;
import java.util.Calendar;


public class Operaciones extends ArchivoEntrada {

    public Operaciones() {
    }

    public void FinalizarDia() {
        

        fecha.add(Calendar.DAY_OF_WEEK, 1);
        dia = fecha.get(Calendar.DAY_OF_MONTH);

        System.out.println(dia + " "+mes+" "+ anio);


    }

    public void Reservar() {
        System.out.println("Reservó");

    }

    public void Cancelar() {
        System.out.println("canceló");

    }

    public void Chek_in() {
        System.out.println("realizo check-in");

    }

    public void Chek_out() {
        System.out.println("realizo check-out");

    }

    public void Comer() {
        System.out.println("comió");

        
    }

    public void SolicitarServicios() {
        System.out.println("solicito servicios");

    }

    public void Reportes() {
        System.out.println("reporte realizado");

    }
}
