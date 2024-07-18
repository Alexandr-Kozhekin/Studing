package Stack;

import java.util.LinkedList;

public class Stack<T> {

    LinkedList<T> storage = new LinkedList<T>();

    public void push(T t) {
        storage.addFirst(t);
    }

    public T peek() {
        return storage.getFirst();
    }

    public T pop() {
        return storage.removeFirst();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public String toString() {
        return storage.toString();
    }

}
