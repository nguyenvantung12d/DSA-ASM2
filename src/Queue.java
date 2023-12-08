public class Queue<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elements;
    private int front;
    private int rear;
    private int size;

    public Queue() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = (T) elements[front];
        front = (front + 1) % elements.length;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) elements[front];
    }

    public static void main(String[] args) {
        Queue<String> stringQueue = new Queue<>();
        stringQueue.enqueue("One");
        stringQueue.enqueue("Two");
        stringQueue.enqueue("Three");

        System.out.println("Peek: " + stringQueue.peek());

        while (!stringQueue.isEmpty()) {
            System.out.println("Dequeue: " + stringQueue.dequeue());
        }
    }
}
