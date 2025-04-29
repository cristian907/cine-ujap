package Structure;

public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * Constructor por defecto de la clase Node.
     * Inicializa los atributos a valores nulos.
     */
    public Node() {
        this.data = null;
        this.next = null;
    }

    /**
     * Constructor que inicializa un nodo con un dato específico.
     *
     * @param data El dato que contendrá el nodo.
     * @throws IllegalArgumentException Si el dato es nulo.
     */
    public Node(T data) {
        if (data == null) {
            throw new IllegalArgumentException("- RefError: Data no puede ser 0. ");
        }
        this.data = data;
        this.next = null;
    }

    /**
     * Constructor que crea una copia de un nodo existente.
     *
     * @param copy El nodo a copiar.
     * @throws IllegalArgumentException Si el nodo a copiar es nulo.
     */
    public Node(Node<T> copy) {
        if (copy == null) {
            throw new IllegalArgumentException("- RefError: Copia fallida por nodo nulo. ");
        }
        this.data = copy.getData();
        this.next = copy.getNext();
    }

    // Setters

    /**
     * Establece el dato del nodo.
     *
     * @param data El nuevo dato que contendrá el nodo.
     * @throws IllegalArgumentException Si el dato es nulo o es el mismo que ya contiene el nodo.
     */
    public void setData(T data) {
        if (data == this.data) {
            throw new IllegalArgumentException("- RefError: Tiene el mismo dato. ");
        }

        if (data == null) {
            throw new IllegalArgumentException("- RefError: El dato es nulo. ");
        }

        this.data = data;
    }

    /**
     * Establece el siguiente nodo en la lista.
     *
     * @param next El nodo siguiente.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    // Getters

    /**
     * Obtiene el dato almacenado en el nodo.
     *
     * @return El dato del nodo.
     */
    public T getData() {
        return this.data;
    }

    /**
     * Obtiene el siguiente nodo en la lista.
     *
     * @return El nodo siguiente.
     */
    public Node<T> getNext() {
        return this.next;
    }

    // Operadores

    /**
     * Compara si el nodo actual es igual a otro objeto.
     *
     * @param obj El objeto a comparar.
     * @return true si los nodos son iguales, false en caso contrario.
     */
    public boolean IsEquals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Node<T> another = (Node<T>) obj;

        if (this.data == null) {
            return another.data == null;
        } else {
            return this.data.equals(another.data);
        }
    }
}
