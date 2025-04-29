package Structure;

public class Queue<T> {
    private Node<T> front;
    private Node<T> last;
    private int size;

    /**
     * Constructor por defecto de la clase Queue.
     * Inicializa una cola vacía.
     */
    public Queue() {
        this.front = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param data El dato que se desea agregar a la cola.
     * @throws IllegalArgumentException Si el dato es nulo.
     */
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("- QueueError: El dato es nulo, no pudo ser agregado a la cola. ");
        }

        Node<T> newNode = new Node<>(data);

        if (this.isEmpty()) {
            this.front = newNode; // Inicio de la cola es el nuevo nodo
        } else {
            this.last.setNext(newNode); // El siguiente nodo del último ahora es el nuevo nodo
        }
        this.last = newNode; // El nuevo nodo es ahora el último

        this.size++;
    }

    /**
     * Elimina y devuelve el elemento al frente de la cola.
     *
     * @return El dato almacenado en el frente de la cola.
     * @throws IllegalArgumentException Si la cola está vacía.
     */
    public T dequeue() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("- QueueError: la cola esta vacia");
        }

        T data = this.front.getData(); // Se toma el dato a retornar
        this.front = this.front.getNext(); // El frente ahora es el siguiente nodo

        if (this.front == null) {
            this.last = null; // Si la cola queda vacía, el último también es nulo
        }

        this.size--;
        return data;
    }

    /**
     * Obtiene el elemento al frente de la cola sin eliminarlo.
     *
     * @return El dato almacenado en el frente de la cola.
     * @throws IllegalArgumentException Si la cola está vacía.
     */
    public T getPeek() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("- QueueError: la cola esta vacia");
        }
        return this.front.getData();
    }

    /**
     * Obtiene el tamaño actual de la cola.
     *
     * @return El número de elementos en la cola.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return this.front == null && this.size == 0;
    }
}
