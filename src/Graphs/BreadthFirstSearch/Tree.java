package Graphs.BreadthFirstSearch;

import java.util.*;

public class Tree<T> {

    private T value;
    private List<Tree<T>> children;

    private Tree(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public static <T> Tree<T> of(T value) {
        return new Tree<>(value);
    }

    public Tree<T> addChild(T value) {
        Tree<T> newChild = new Tree<>(value);
        children.add(newChild);

        return newChild;
    }

    public T getValue() {
        return value;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree<?> tree = (Tree<?>) o;
        return Objects.equals(value, tree.value) && Objects.equals(children, tree.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, children);
    }

    @Override
    public String toString() {
        return "value=" + value + ", children=" + children;
    }
}
