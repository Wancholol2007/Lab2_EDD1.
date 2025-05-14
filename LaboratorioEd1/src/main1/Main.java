package main1;

import java.util.Scanner;
import ejercicios.Ejercicio3;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio1;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc;
        String r = "si";
        while (r.equalsIgnoreCase("si")) {
            System.out.println("1. Lista simple");
            System.out.println("2. Ejercicio de fusión de listas");
            System.out.println("3. Pila");
            System.out.println("4. Salida");
            System.out.print  ("Ingrese la opción que desea: ");
            opc = sc.nextInt();

            while (opc <= 0 || opc >= 5) {
                System.out.print("Opción no válida, vuelva a intentarlo: ");
                opc = sc.nextInt();
            }

            switch (opc) {
                case 1:
                    Ejercicio1.ejecutar();
                    break;
                case 2:
                    Ejercicio2.ejecutaEjercicio2(sc);
                    break;
                case 3:
                    new Ejercicio3().mostrarMenu();
                    break;
                case 4:
                    System.out.println("Cerrando el programa");
                    r = "no";
                    break;
            }
        }
        sc.close();
    }
}
