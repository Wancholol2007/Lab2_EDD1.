package procesos.ejercicio2;

public class ListaOrdenada {
     private DoubleNode first, last;

    // Inserta manteniendo orden ascendente
    public void insertarOrdenado(int data) {
        DoubleNode nuevo = new DoubleNode(data);
        if (first == null) {
            first = nuevo;
            last = nuevo;
            return;
        }
        // si va al principio
        if (data <= first.getData()) {
            nuevo.setRight(first);
            first.setLeft(nuevo);
            first = nuevo;
            return;
        }
        // si va al final
        if (data >= last.getData()) {
            last.setRight(nuevo);
            nuevo.setLeft(last);
            last = nuevo;
            return;
        }
        // va en medio
        DoubleNode p = first;
        while (p.getData() < data) {
            p = p.getRight();
        }
        // p.data >= data → insertar antes de p
        nuevo.setRight(p);
        nuevo.setLeft(p.getLeft());
        p.getLeft().setRight(nuevo);
        p.setLeft(nuevo);
    }

    // Busca un nodo con ese valoror, o devuelve null
    public DoubleNode buscar(int data) {
        DoubleNode p = first;
        while (p != null) {
            if (p.getData() == data) return p;
            p = p.getRight();
        }
        return null;
    }

    // Elimina la primera ocurrencia de data
    public void eliminar(int data) {
        if (first == null) return;
        // si está en first
        if (first.getData() == data) {
            if (first == last) {
                first = last = null;
            } else {
                first = first.getRight();
                first.setLeft(null);
            }
            return;
        }
        // si está en last
        if (last.getData() == data) {
            last = last.getLeft();
            last.setRight(null);
            return;
        }
        // busca en medio
        DoubleNode p = first.getRight(); 
        while (p != null && p.getData() != data) {
            p = p.getRight();
        }
        if (p != null) {
            // p está entre first y last
            p.getLeft().setRight(p.getRight());
            p.getRight().setLeft(p.getLeft());
        }
    }

    // Recorre e imprime de first a last
    public void traverseRight() {
        System.out.print("PTR1: ");
        DoubleNode p = first;
        while (p != null) {
            System.out.print(p.getData() + "|");
            p = p.getRight();
        }
        System.out.println();
    }

    // El “merge” según el enunciado: consume todos los nodos de ptr2
    public void juntarListas(ListaCircular ptr2) {
        while (!ptr2.isEmpty()) {
            int valor = ptr2.quitarPrimero();
            if (buscar(valor) == null) {
                insertarOrdenado(valor);
            } else {
                eliminar(valor);
            }
        }
    }
}

