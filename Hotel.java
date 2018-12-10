import java.util.Scanner;

public class Hotel {

        public static void main(String[] args) {
                ArchivoEntrada a = new ArchivoEntrada();

                Scanner entrada = new Scanner(System.in);

                int op;
                do {
                        System.out.println("\n\t***************************************");
                        System.out.println("\t     -----> MENU PRINCIPAL <----- ");
                        System.out.println("\t***************************************");
                        System.out.println("\t 1. inicializar.in ");
                        System.out.println("\t 2. precios.in  ");
                        System.out.println("\t 3. operaciones.in  ");
                        System.out.println("\t 4. Salir                              ");
                        System.out.println("\t***************************************");
                        System.out.print("\tIngrese una opcion: ");
                        op = entrada.nextInt();

                        switch (op) {
                        case 1:
                                a.Inicializar_in();
                                break;
                        case 2:
                                a.Precios_in();
                                break;
                        case 3:
                                a.Operaciones_in();
                                break;
                        case 4:
                                break;
                        default:
                                System.out.println(" Opcion no valida.");
                        }

                } while (op != 4);
        }

}