package procesos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ProcesosEjercicio3 {

    int cantidad, tamaño = 300, tope = -1;
    String pila[];
    

    public void IngresoArchivo() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese la ruta del archivo (por ejemplo: C:\\\\ruta\\\\archivo.txt): ");
    String ruta = sc.nextLine();

    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println("Expresion " + linea);
                boolean resultado = estaBalanceada1(linea);
                if (resultado) {
                    System.out.println("Esta balanceada");
                }else{
                    System.out.println("No esta balanceada");
                }
            } 
    } catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
    }
}


    public void LeerDatoPorDato() {
        Scanner sc = new Scanner(System.in);
        pila = new String[tamaño];

        String elemento;
        System.out.println("Ingrese la cantidad de signos que quiere verificar:");
        cantidad = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer después de nextInt

        if (cantidad > tamaño) {
            System.out.println("Demasiados elementos");
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese la expresión:");
            elemento = sc.nextLine();

            while (!validacionEleme(elemento)) {
                System.out.println("Vuelva a ingresarlo:");
                elemento = sc.nextLine();
            }

            tope = tope + 1;
            pila[tope] = elemento;
        }

        System.out.println("Expresiones almacenadas correctamente");

        // Llamar correctamente a VerificadorBalanceo
        boolean resultado = VerificadorBalanceo(pila);
        if (resultado) {
            System.out.println("Esta balanceada");
        }else{
            System.out.println("No esta balanceada");
        }  
    }

    public boolean validacionEleme(String elem) {
        if (!elem.isEmpty() && elem.matches("[\\(\\)\\[\\]\\{\\}]+")) {
            System.out.println("Expresión ingresada válida");
            return true;
        } else {
            System.out.println("Expresión ingresada no es válida");
            return false;
        }
    }

    //ARREGLAR CADA METODO DE BALANCEO
    // Método que verifica si cada expresión está balanceada ingresa una pila
    public boolean VerificadorBalanceo(String[] pila) {
        for (int i = 0; i <= tope; i++) {
            if (!estaBalanceada1(pila[i])) {
                return false;
            }
        }
        return true;
    }

    // Método auxiliar para verificar balanceo de una sola expresión
    public boolean estaBalanceada1(String expresion) {
        Stack<Character> stack = new Stack<>();

        for (char c : expresion.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (!esPar(top,c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public  boolean esPar(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '{' && cierre == '}') ||
               (apertura == '[' && cierre == ']');
    }

    
    
}
