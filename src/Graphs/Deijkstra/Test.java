package Graphs.Deijkstra;

import java.util.Map;

import static Graphs.Deijkstra.Dijkstra.search;

public class Test {

    public static void main(String[] args) {

        Node<String> start = new Node<>("start");
        Node<String> nodeA = new Node<>("a");
        Node<String> nodeB = new Node<>("b");
        Node<String> end = new Node<>("end");

        start.connect(nodeA, 6);
        start.connect(nodeB, 2);
        nodeB.connect(nodeA, 3);
        nodeB.connect(end, 5);
        nodeA.connect(end, 1);
        start.connect(end, Integer.MAX_VALUE);

        Map<Node<String>, Integer> map = Dijkstra.search(start);

        System.out.println(map);
        System.out.println(Dijkstra.printShortCut(map));

    }
}
