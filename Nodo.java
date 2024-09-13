class Nodo {
    int valor;
    Nodo siguiente;

    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

class ListaEnlazada {
    Nodo cabeza;

    public ListaEnlazada() {
        cabeza = null;
    }

    // Método para agregar un nuevo nodo al final de la lista
    public void agregar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    // Método para ordenar la lista usando el algoritmo de ordenamiento por inserción
    public void ordenarPorInsercion() {
        if (cabeza == null || cabeza.siguiente == null) {
            return; // La lista está vacía o tiene un solo nodo
        }

        Nodo ordenado = null; // Lista nueva que contiene los nodos ordenados

        Nodo actual = cabeza;
        while (actual != null) {
            Nodo siguiente = actual.siguiente;
            if (ordenado == null || ordenado.valor >= actual.valor) {
                // Insertar al principio de la lista ordenada
                actual.siguiente = ordenado;
                ordenado = actual;
            } else {
                // Buscar la posición adecuada para insertar el nodo actual
                Nodo temp = ordenado;
                while (temp.siguiente != null && temp.siguiente.valor < actual.valor) {
                    temp = temp.siguiente;
                }
                actual.siguiente = temp.siguiente;
                temp.siguiente = actual;
            }
            actual = siguiente;
        }
        cabeza = ordenado;
    }

    // Método para imprimir la lista
    public void imprimir() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        lista.agregar(4);
        lista.agregar(2);
        lista.agregar(8);
        lista.agregar(1);
        lista.agregar(5);

        System.out.println("Lista antes de ordenar:");
        lista.imprimir();

        lista.ordenarPorInsercion();

        System.out.println("Lista después de ordenar:");
        lista.imprimir();
    }
}
