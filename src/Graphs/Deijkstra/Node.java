package Graphs.Deijkstra;

import java.util.*;

public class Node {

    private String value;
    //дистанция до соседних узлов
    private Map<Node, Integer> costs;
    //дистанция до текущего узла
    private int cost = Integer.MAX_VALUE;

    public Node(String value) {
        this.value = value;
        this.costs = new LinkedHashMap<>();
    }

    public void connect(Node node, Integer cost) {
        costs.put(node, cost);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<Node, Integer> getCosts() {
        return costs;
    }

    public void setCosts(Map<Node, Integer> costs) {
        this.costs = costs;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(value, node.value);
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