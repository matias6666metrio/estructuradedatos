import java.util.Stack;

public class Pila<T> {
    private Stack<T> stack;
    private final int limite;

    public Pila(int limite) {
        this.stack = new Stack<>();
        this.limite = limite;
    }

    public void push(T item) {
        if (stack.size() < limite) {
            stack.push(item);
        }
    }

    public T pop() {
        return stack.isEmpty() ? null : stack.pop();
    }

    public T peek() {
        return stack.isEmpty() ? null : stack.peek();
    }
}
