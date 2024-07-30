package Graphs.Deijkstra;

import java.util.Map;

public class Test {

    public static void main(String[] args) {

//        Graph graph = new Graph();
//
//        Node start = new Node("start");
//        Node nodeA = new Node("a");
//        Node nodeB = new Node("b");
//        Node end = new Node("end");
//
//        start.connect(nodeA, 6);
//        start.connect(nodeB, 2);
//        nodeB.connect(nodeA, 3);
//        nodeB.connect(end, 5);
//        nodeA.connect(end, 1);
//
//        graph.addNode(start);
//        graph.addNode(nodeA);
//        graph.addNode(nodeB);
//        graph.addNode(end);
//
//        Map<Node, Node> map = Dijkstra.search(graph, start);
//        System.out.println(Dijkstra.printShortCut(map));

        Graph graph = new Graph();

        Node start = new Node("s");
        Node nodeA = new Node("a");
        Node nodeB = new Node("b");
        Node nodeC = new Node("c");
        Node nodeD = new Node("d");
        Node end = new Node("e");

        start.connect(nodeB, 5);
        start.connect(nodeA, 2);
        nodeB.connect(nodeD, 4);
        nodeB.connect(nodeC, 2);
        nodeA.connect(nodeB, 8);
        nodeA.connect(nodeC, 7);
        nodeD.connect(nodeC, 6);
        nodeD.connect(end, 3);
        nodeC.connect(end, 1);

        graph.addNode(start);
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(end);

        Map<Node, Node> map = Dijkstra.search(graph, start);
        System.out.print(Dijkstra.printShortCut(map));

    }
}
