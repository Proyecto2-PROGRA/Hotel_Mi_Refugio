import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoEntrada extends Persona {
    protected String ValorHotel;
    protected String Fecha;
    protected String Habitaciones;
    protected String Piso;
    protected String Servicio;
    protected String cadena;
    protected String n;//Guarda el numero de abitaciones como string para luego guardarlo en fichero(Habitaciones)
    protected String n_1;//Guarda el numero de pisos como string para luego guardarlo en fichero(Piso)
    protected int NumeroPiso;
    protected int NumeroHabitaciones;
    protected int TipoDeHabitacion;
    protected int Menu;
    protected int cont;

    
  


    public ArchivoEntrada() {
    }

    public void Inicializar_in() {
        ValorHotel="100250.00";
        Fecha = "22 10 2018";
        try {
            FileWriter fichero = new FileWriter("inicializar.txt");
            fichero.append(ValorHotel);
            fichero.write("\r\n"); 

            fichero.write(Fecha);
            fichero.append("\r\n");

            NumeroPiso = (int) (Math.random() * 10) + 1;
            List<String>[] ListaTipoHabitacion = new List[NumeroPiso];



            String n_1 = Integer.toString(NumeroPiso);
            


            for (int x=0; x < NumeroPiso;x++){
                NumeroHabitaciones = (int) (Math.random() * 10) + 1;
                
                List<String> ListaHabitacion = new ArrayList<>();

                for(int i=0; i < NumeroHabitaciones; i++){
                    TipoDeHabitacion =(int) (Math.random() * 5) + 1;
                    String Habitacion = Integer.toString(TipoDeHabitacion);
                    
                    ListaHabitacion.add(Habitacion);
                    cont++;
                    
                }
                ListaTipoHabitacion[x] = ListaHabitacion;
                
                

            }
            String contador = Integer.toString(cont);
            fichero.write(contador + " ");
            fichero.write(n_1);
            
            
            for(int x=0;x<NumeroPiso;x++ ){
                List<String> LH = new ArrayList<>();

                System.out.print(ListaTipoHabitacion[x].size()+" ");
                

                LH.addAll(ListaTipoHabitacion[x]);

                for(int y=0; y<ListaTipoHabitacion[x].size();y++){
                    System.out.print(LH.get(y)+" ");
                    if("1" ==LH.get(y)){
                        System.out.print("INDIV"+ " ");
                    }else if(LH.get(y)=="2"){
                        System.out.print("INDIV"+ " ");
                    }else if(LH.get(y)=="3"){
                        System.out.print("INDIV"+ " ");
                    }else if(LH.get(y)=="4"){
                        System.out.print("INDIV"+ " ");
                    }else if(LH.get(y)=="5"){
                        System.out.print("INDIV"+ " ");
                    }
                }
                System.out.println();
                
                
            }
            

            

            
            
            fichero.close();

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        try {
            FileReader lector = new FileReader("inicializar.txt");
            BufferedReader BR = new BufferedReader(lector);
            
            while((cadena=BR.readLine())!=null){
                System.out.println(cadena);
            }
            
        
    
            BR.close();
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