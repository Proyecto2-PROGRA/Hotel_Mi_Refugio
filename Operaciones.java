
import java.io.*;
public class Operaciones extends ArchivoEntrada {

    public Operaciones() {
    }

    public void FinalizarDia() {
        try {
            FileReader lector = new FileReader("inicializar.in.txt");
            BufferedReader BR = new BufferedReader(lector);

            cadena = BR.readLine();
            cadena = BR.readLine();
            

            System.out.println(fecha_final);

            BR.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
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
