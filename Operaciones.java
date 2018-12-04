
public class Operaciones extends ArchivoEntrada {

    public Operaciones() {
    }

    public void FinalizarDia() {
        try {
            FileReader lector = new FileReader(inicializar.in.txt);
            BufferedReade BR = new BufferedReader(lector);
            cadena = BR.readline(1);
            System.out.println(cadena);
            System.out.println("Hola Mundo");
            BR.close();
        } 
        
        catch (Exception e) {
            //TODO: handle exception
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
