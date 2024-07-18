package Graphs.Deijkstra;

import java.util.*;
import java.util.stream.Collectors;

public class Dijkstra {

    public static <T> Map<Node<T>, Integer> search(Node<T> start) {

        Map<Node<T>, Node<T>> parents = new LinkedHashMap<>();
        Map<Node<T>, Integer> costs = start.getCosts();
        Set<Node<T>> processed = new HashSet<>();

        for (Node<T> node : start.getNeighbors()) {
            parents.put(node, start);
        }

        Node<T> lowestCostNode = findLowestCostNode(start.getCosts(), processed);

        while (lowestCostNode != null) {

            Integer lowestCost = costs.get(lowestCostNode);
            Map<Node<T>, Integer> lowestCostNodeNeighbors = lowestCostNode.getCosts();

            for (Node<T> neighborNeighbor : lowestCostNodeNeighbors.keySet()) {

                Integer newCost = lowestCost + lowestCostNodeNeighbors.get(neighborNeighbor);

                for (Node<T> parentsNode : parents.keySet()) {
                    if (costs.get(parentsNode) > newCost) {
                        costs.put(neighborNeighbor, newCost);
                        parents.put(parentsNode, lowestCostNode);
                    }
                }
            }

            processed.add(lowestCostNode);
            lowestCostNode = findLowestCostNode(lowestCostNodeNeighbors, processed);
        }

        return costs;
    }

    public static <T> String printShortCut(Map<Node<T>, Integer> graph) {
        StringBuilder builder = new StringBuilder();

        List<Integer> cost = graph.values().stream().sorted().toList();

        for(int i = 1 ; i <= cost.size(); i++) {
            if(i != cost.size())
                builder.append(cost.get(i-1) + " - ");
            else
                builder.append(cost.get(i-1));
        }

        return builder.toString();
    }

    private static <T> Node<T> findLowestCostNode(Map<Node<T>, Integer> costs,
                                                  Set<Node<T>> processed) {

        int lowestCost = Integer.MAX_VALUE;
        Node<T> lowestCostInNode = null;

        for (Node<T> node : costs.keySet()) {
            int cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostInNode = node;
            }
        }

        return lowestCostInNode;
    }
}