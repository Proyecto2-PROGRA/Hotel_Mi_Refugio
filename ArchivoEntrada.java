import java.io.PrintWriter;

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
    /*Algoritmo para escribir en un archivo desde Java
            1.-Crear una variable de tipo File
            2.-Crear una variabke de tipo PrintWriter
            3.-Preparar el archivo
            4.-Verificar si el archivo no esxiste
                4.1.-Crear el Archvivo

                4.2.-En otro caso (else)
                    4.2.1 Preparar el archivo para escribir
                    4.2.2 Escribir en el archivo
                    4.2.3 Cerrar el archivo
    */
    //paso 1
    File miArchivo;//Para manipular al archivo
    //paso 2
    PrintWriter escribir;//Para escribir en el archivo
    //paso 3
    miArchivo = new File("EjemploEscritura.txt");//Preparando el archivo
    
    
    
}

public void Precios_in(){
    
    
}

public void Operaciones_in(){
    Operaciones o = new Operaciones();
    
    o.Comer();
    
}



}