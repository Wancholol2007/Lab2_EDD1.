package ejercicios;

//importamis el Sccaner
import java.util.Scanner;
import procesos.ProcesosEjercicio3;
public class Ejercicio3 {

    public void mostrarMenu(){
        Scanner sc=new Scanner(System.in);
        int op1;
        String res="si";
        while (res.equals("si")) {
            System.out.println("Menu de Pila");
            System.out.println("1.Ingresando archivo txt");
            System.out.println("2.Igresando expresion por expresion");
            System.out.println("3.Salida");
            op1=sc.nextInt();
            while (op1<=0 || op1>3) {
                System.out.println("Opcion incorrecta");
                System.out.println("Vuelva a intentarlo");
                op1=sc.nextInt();
            }
             switch(op1){
               case 1:
                    new ProcesosEjercicio3().IngresoArchivo();
               break;

               case 2:
                     new ProcesosEjercicio3().LeerDatoPorDato();
               break;
               case 3:
               System.out.println("Subprogrma cerrado");
                     res="no";
               break;
             }
        }

    }


    
}