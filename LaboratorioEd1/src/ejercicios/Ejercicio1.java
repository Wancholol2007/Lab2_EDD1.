package ejercicios;

import java.util.Scanner;

// Nodo que representa un elemento no nulo de la matriz
class Nodo {
    int fila, columna, valor;
    Nodo siguiente;

    public Nodo(int fila, int columna, int valor) {
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
        this.siguiente = null;
    }
}

// Clase para representar la matriz dispersa como lista enlazada simple
class ListaDispersa {
    Nodo cabeza;

    public ListaDispersa() {
        this.cabeza = null;
    }

    public void insertar(int fila, int columna, int valor) {
        if (valor == 0) return;
        Nodo nuevo = new Nodo(fila, columna, valor);

        if (cabeza == null || comparar(nuevo, cabeza) < 0) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null && comparar(nuevo, actual.siguiente) > 0) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }
    }

    private int comparar(Nodo a, Nodo b) {
        if (a.fila != b.fila) return a.fila - b.fila;
        return a.columna - b.columna;
    }

    public int obtenerValor(int fila, int columna) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.fila == fila && actual.columna == columna) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        return 0;
    }

    public ListaDispersa multiplicar(ListaDispersa B, int dimension) {
        ListaDispersa resultado = new ListaDispersa();

        int fila = 0;
        while (fila < dimension) {
            int columna = 0;
            while (columna < dimension) {
                int suma = 0;
                int k = 0;
                while (k < dimension) {
                    int valA = this.obtenerValor(fila, k);
                    int valB = B.obtenerValor(k, columna);
                    suma += valA * valB;
                    k++;
                }
                if (suma != 0) {
                    resultado.insertar(fila, columna, suma);
                }
                columna++;
            }
            fila++;
        }

        return resultado;
    }

    public ListaDispersa potencia(int n, int dimension) {
        ListaDispersa resultado = this.copiar();
        int contador = 1;
        while (contador < n) {
            resultado = resultado.multiplicar(this, dimension);
            contador++;
        }
        return resultado;
    }

    public ListaDispersa copiar() {
        ListaDispersa copia = new ListaDispersa();
        Nodo actual = cabeza;
        while (actual != null) {
            copia.insertar(actual.fila, actual.columna, actual.valor);
            actual = actual.siguiente;
        }
        return copia;
    }

    public void imprimir() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println("(" + actual.fila + ", " + actual.columna + ", " + actual.valor + ")");
            actual = actual.siguiente;
        }
    }
}

// Clase principal del ejercicio
public class Ejercicio1 {

    // Método que se puede llamar desde el menú (Main.java)
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);

        // Crear la matriz dispersa fija del ejercicio
        ListaDispersa A = new ListaDispersa();
        int dimension = 3; // La matriz es de 3x3

        // Insertar elementos de ejemplo (como en el enunciado del examen)
        A.insertar(0, 1, 1);
        A.insertar(1, 2, 1);
        A.insertar(2, 0, 1);

        // Mostrar matriz original
        System.out.println("Matriz A original:");
        A.imprimir();

        // Leer el valor de n desde teclado
        int potencia;
        do {
            System.out.print("\nIngrese un valor entero positivo para n (potencia): ");
            while (!sc.hasNextInt()) {
                System.out.print("Entrada inválida. Ingrese un número entero positivo: ");
                sc.next();
            }
            potencia = sc.nextInt();
            if (potencia < 1) {
                System.out.println("n debe ser mayor o igual a 1.");
            }
        } while (potencia < 1);

        // Calcular la potencia A^n
        ListaDispersa resultado = A.potencia(potencia, dimension);

        // Mostrar el resultado
        System.out.println("\nResultado de A^" + potencia + ":");
        resultado.imprimir();

        // Puedes comentar esto si da problemas
        // sc.close();
    }

    // Método main opcional para pruebas independientes
    public static void main(String[] args) {
        ejecutar();
    }
}

