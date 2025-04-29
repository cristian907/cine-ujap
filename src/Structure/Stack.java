package Structure;

public class Stack<T> {
    private Node<T> stack;
    private int size;

    /**
     * Constructor por defecto de la clase Stack.
     * Inicializa una pila vacía.
     */
    public Stack() {
        this.stack = null;
        this.size = 0;
    }

    /**
     * Agrega un elemento a la cima de la pila.
     *
     * @param data El dato que se desea agregar a la pila.
     * @throws IllegalArgumentException Si el dato es nulo.
     */
    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException("- StackError: El dato es nulo, no pudo ser agregado a la pila.");
        }
        Node<T> newNode = new Node<>(data);
        newNode.setNext(this.stack); // El nuevo nodo apunta al nodo actual en la cima
        this.stack = newNode; // El nuevo nodo ahora es la cima de la pila

        this.size++;
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     *
     * @return El dato almacenado en la cima de la pila.
     * @throws IllegalArgumentException Si la pila está vacía.
     */
    public T pop() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("- StackError: la pila esta vacia");
        }
        T data = this.stack.getData(); // Se toma el dato de la cima
        this.stack = this.stack.getNext(); // La cima ahora es el siguiente nodo

        this.size--;
        return data;
    }

    /**
     * Muestra el elemento en la cima de la pila sin eliminarlo.
     *
     * @return El dato almacenado en la cima de la pila.
     * @throws IllegalArgumentException Si la pila está vacía.
     */
    public T showStack() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("- StackError: la pila esta vacia");
        }
        return this.stack.getData();
    }

    /**
     * Obtiene el tamaño actual de la pila.
     *
     * @return El número de elementos en la pila.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return this.stack == null && this.size == 0;
    }
}
