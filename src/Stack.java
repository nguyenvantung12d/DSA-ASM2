
public class Stack<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elements;
    private int top;
    public Stack() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.top = -1;
    }
    public void push(T item) {
        elements[++top] = item;
    }
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) elements[top--];
    }
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) elements[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }
    private boolean isFull() {
        return top == elements.length - 1;
    }
}