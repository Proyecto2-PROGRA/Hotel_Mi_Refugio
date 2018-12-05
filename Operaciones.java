
import java.io.*;
public class Operaciones extends ArchivoEntrada {

    public Operaciones() {
    }

    public void FinalizarDia() {
<<<<<<< HEAD
        try {
            FileReader lector = new FileReader("inicializar.in.txt");
            BufferedReader BR = new BufferedReader(lector);

            cadena = BR.readLine();
            cadena = BR.readLine();
            String cadena_dia = cadena.substring(0,2);

            System.out.println(cadena_dia);

            BR.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
=======

>>>>>>> 82e0919bc7623aab2d519f704d7ab9c0fa25b972
    }

    public void Reservar() {

    }

    public void Cancelar() {

    }

    public void Chek_in() {

    }

    public void Chek_out() {

    }

    public void Comer() {

    }

    public void SolicitarServicios() {

    }

    public void Reportes() {

    }
}
