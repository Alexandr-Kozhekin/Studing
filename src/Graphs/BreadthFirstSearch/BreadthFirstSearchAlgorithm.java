package Graphs.BreadthFirstSearch;

import java.util.*;

public class BreadthFirstSearchAlgorithm {

    public static <T> Optional<Tree<T>> search(T value, Tree<T> root) {

        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            Tree<T> currentNode = queue.remove();

            if(currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                queue.addAll(currentNode.getChildren());
            }
        }

        return Optional.empty();
    }

    public static <T> Optional<Node<T>> search(T value, Node<T> start) {

        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);

        Node<T> currentNode;

        Set<Node<T>> alreadyVisited = new HashSet<>();

        while(!queue.isEmpty()) {

            currentNode = queue.remove();

            System.out.printf("Visited node with value: %s ", currentNode.getValue());

            if(currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                alreadyVisited.add(currentNode);
                queue.addAll(currentNode.getNeighbors());
                queue.removeAll(alreadyVisited);
            }
        }

        return Optional.empty();
    }

    public static <K, V> Optional<V> search(V value, HashMap<K, List<V>> start) {

        Queue<V> queue = new ArrayDeque<>();

        queue.addAll(start.get(start.keySet().iterator().next()));

        V currentNode;

        Set<V> alreadyVisited = new HashSet<>();

        while(!queue.isEmpty()) {

            currentNode = queue.remove();

            System.out.printf("Visited node with value: %s ", currentNode.toString());

            if(currentNode.equals(value)) {
                return Optional.of(currentNode);
            } else {
                alreadyVisited.add(currentNode);
                queue.addAll(start.get(currentNode));
                queue.removeAll(alreadyVisited);
            }
        }

        return Optional.empty();
    }

}
