package ejercicios;

import java.util.Scanner;
import procesos.ejercicio2.ListaCircular;
import procesos.ejercicio2.ListaOrdenada;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ejecutaEjercicio2(sc);
        sc.close();
    }

    public static void ejecutaEjercicio2(Scanner sc) {
        ListaOrdenada ptr1 = new ListaOrdenada();
        ListaCircular  ptr2 = new ListaCircular();
        int n, valor;

        // 1) ¿Cuántos tendrá PTR1 (ordenada)?
        System.out.print("¿Cuántos elementos tendra PTR1 ordenada? ");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Valor " + i + ": ");
            valor = sc.nextInt();
            ptr1.insertarOrdenado(valor);
        }

        // 2) ¿Cuántos tendrá PTR2 (circular)?
        System.out.print("¿Cuántos elementos tendra PTR2 circular? ");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Valor " + i + ": ");
            valor = sc.nextInt();
            ptr2.add(valor);
        }

        // 3) Menú de fusión
        String volver = "no";
        while (volver.equalsIgnoreCase("no")) {
            System.out.println("\n-- EJERCICIO 2: FUSION DE LISTAS --");
            System.out.println("1. Mostrar PTR1 (ordenada)");
            System.out.println("2. Mostrar PTR2 (circular)");
            System.out.println("3. Ejecutar algoritmo de fusion");
            System.out.println("4. Volver al menu principal");
            System.out.print("Opción: ");
            int opc2 = sc.nextInt();

            switch (opc2) {
                case 1:
                    ptr1.traverseRight();
                    break;
                case 2:
                    ptr2.traverse();
                    break;
                case 3:
                    ptr1.juntarListas(ptr2);
                    System.out.println("Fusion realizada. PTR2 ha quedado vacia.");
                    ptr2.traverse();
                    break;
                case 4:
                    volver = "si";
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }
}
