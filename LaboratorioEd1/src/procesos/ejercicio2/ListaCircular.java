package procesos.ejercicio2;

public class ListaCircular {
     private Node first, last;

    
    public void add(int valor) {
    Node nuevo = new Node(valor);
    if (first == null) {
        first = nuevo;
        last  = nuevo;
        nuevo.next = nuevo;
    } else {
        last.next = nuevo;
        nuevo.next = first;
        last = nuevo;
    }
}

    // Quita y devuelve el valor del first; destruye la lista cuando queda vacío
    public int quitarPrimero() {
        if (first == null) 
            System.out.println("Lista vacía");
        int valor = first.data;
        if (first == last) {
            first = last = null;
        } else {
            first = first.next;
            last.next = first;
        }
        return valor;
    }

    public boolean isEmpty() {
        return first == null;
    }

    // (Opcional) para depurar
    public void traverse() {
        System.out.print("PTR2: ");
        if (first == null) {
            System.out.println("<vacía>");
            return;
        }
        Node p = first;
        do {
            System.out.print(p.data + "|");
            p = p.next;
        } while (p != first);
        System.out.println();
    }
}
