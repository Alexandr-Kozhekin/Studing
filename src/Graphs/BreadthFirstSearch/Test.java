package Graphs.BreadthFirstSearch;

public class Test {

    public static void main(String[] args) {

        Tree<Integer> root = Tree.of(10);
        Tree<Integer> rootFirstChild = root.addChild(2);
        Tree<Integer> depthMostChild = rootFirstChild.addChild(3);
        Tree<Integer> rootSecondChild = root.addChild(4);

        System.out.println(BreadthFirstSearchAlgorithm.search(4, root));

//        System.out.println(BreadthFirstSearchAlgorithm.search(4, map));

        Node<Integer> start = new Node<>(10);
        Node<Integer> firstNeighbor = new Node<>(2);
        start.connect(firstNeighbor);

        Node<Integer> firstNeighborNeighbor = new Node<>(3);
        firstNeighbor.connect(firstNeighborNeighbor);
        firstNeighborNeighbor.connect(start);

        Node<Integer> secondNeighbor = new Node<>(4);
        start.connect(secondNeighbor);

        System.out.println(BreadthFirstSearchAlgorithm.search(3, start));

//        Node<Integer> start = new Node<>(1);
//        Node<Integer> nodeA = new Node<>(2);
//        Node<Integer> nodeB = new Node<>(3);
//        Node<Integer> end = new Node<>(4);
//
//        start.connect(nodeA);
//        start.connect(nodeB);
//        nodeB.connect(nodeA);
//        nodeA.connect(end);
//        nodeB.connect(end);

    }
}
