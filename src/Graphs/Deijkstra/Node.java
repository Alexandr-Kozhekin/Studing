package Graphs.Deijkstra;

import java.util.*;

public class Node<T> {

    private T value;
    private Set<Node<T>> neighbors;
    private Map<Node<T>, Integer> costs;

    public Node(T value) {
        this.value = value;
        this.neighbors = new LinkedHashSet<>();
        this.costs = new LinkedHashMap<>();
    }

    public void connect(Node<T> node, Integer cost) {
        this.neighbors.add(node);
        this.costs.put(node, cost);
    }

    public T getValue() {
        return value;
    }

    public Set<Node<T>> getNeighbors() {
        return neighbors;
    }

    public Map<Node<T>, Integer> getCosts() {
        return costs;
    }

    public void setNeighbors(Set<Node<T>> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> that = (Node<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "node=" + value;
    }

}
