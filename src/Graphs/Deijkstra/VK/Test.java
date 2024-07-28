package Graphs.Deijkstra.VK;

public class Test {

    public static void main(String[] args) {

        Node nodeStart = new Node("start");
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeEnd = new Node("end");

        nodeStart.addDestination(nodeB, 5);
        nodeStart.addDestination(nodeA, 2);

        nodeB.addDestination(nodeD, 4);
        nodeB.addDestination(nodeC, 2);

        nodeA.addDestination(nodeB, 8);
        nodeA.addDestination(nodeC, 7);

        nodeD.addDestination(nodeC, 6);
        nodeD.addDestination(nodeEnd, 3);

        nodeC.addDestination(nodeEnd, 1);

        Graph graph = new Graph();

        graph.addNode(nodeStart);
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeEnd);

        graph = Impl.calculateShortestPathFromSource(graph, nodeStart);

        for(Node n : graph.getNodes()) {
            StringBuilder builder = new StringBuilder();
            builder.append("Узел " + n + ": ");
            for(Node s : n.getShortestPath()) {
                builder.append(s + " -> ");
            }
            builder.append(n + " " + "(общее расстояние = " + n.getDistance() + ")");
            System.out.println(builder);
        }

    }
}
