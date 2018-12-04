import java.io.FileWriter;

public class ArchivoEntrada extends Persona {
    protected int ValorHotel;
    protected String Fecha;
    protected String Habitaciones;
    protected int Piso;
    protected String Servicio;
    protected int Menu;

public ArchivoEntrada() {
}

public void Inicializar_in(){
    try {
        FileWriter fichero = new FileWriter("inicializar.in.txt");
        fichero.write("Holaaaaaaaaaaaaaa");
        fichero.write("Hola mundo");
        fichero.close();
        
    } catch (Exception e) {
        //TODO: handle exception
        
    }
    try {
        FileReader lector = new FileReader("inicializar.in.txt");
        bufferedReader BR = new BufferdReader (lector);
        System.out.println(BR.redLines());
    } catch (Exception e) {
        //TODO: handle exception
    }
    
    
    
}

public void Precios_in(){
    
    
}

public void Operaciones_in(){
    Operaciones o = new Operaciones();
    
    o.Comer();
    
}



}