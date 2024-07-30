package Graphs.Deijkstra;

import java.util.*;

public class Dijkstra {
    /**
     * Реализация алгоритма Дейкстры взята из книги Грокаем АЛГОРИТМЫ Aditya Bhargava в учебных целях.
     * Данный алгоритм предназначен для поиска кротчайшего пути во взвешенных графах.
     * Для правильной работы алгоритма необходимо что-бы ребра узлов были больше или равны нулю так как
     * данный алгоритм не может работать с отрицательными числами.
     * Для реализации взвешенного графа следует использовать класс Graph
     * @see Graph
     *Для реалтзации узлов и их ребер следует использовать класс Node
     * @see Node
     * В качестве входного значения используется взвешенный граф
     * @param graph-взвешенный граф
     *
     *Для вывода короткого пути необходимо использовать метод printShortCut(Map<Node, Node> parents) в который
     *необходимо передать результат вызова метода search(Graph graph). Метод printShortCut возвращает String
     *так-что результат можно просто вывести в консоль. Результат будет в формате start -> b -> a -> end.
     */
    public static Map<Node, Node> search(Graph graph, Node start) {
        /*
        Карта parents содержит все узлы ближайшие к узлу start
        Карта costs содержит дистанцию которую необходимо пройти к узлу start
        Список processed содержит пройденные узлы
         */
        Map<Node, Node> parents = new HashMap<>();
        Map<Node, Integer> costs = new HashMap<>();
        Set<Node> processed = new HashSet<>();
        /*
        Заполняем карты значениями узлов которые находятся по соседству с start
        таким образом если у start сосед А с длинной - 6 и B с длинной - 2
        начальные значения в таблице parents будут [A, start], [B, start], [END, null];
        а начальные значения в таблице costs будут [A, 6], [B, 2], [END, 2147483647]
        Значение END - 2147483647 указывает на то что дистанция до узла END неизвестна (для этого устанавливаем
        максимальное значение)
         */
        for(Node node : graph.getNodes()) {
            if(node.equals(start)) {
                for(Node neighbors : node.getCosts().keySet()) {
                    parents.put(neighbors, node);
                    costs.put(neighbors, node.getCosts().get(neighbors));
                }
            } else if(!parents.containsKey(node)) {
                parents.put(node, null);
                costs.put(node, node.getCost());
            }
        }
        /*
        Используя метод findLowestCostNode(costs, processed) находим узел с самой короткой дистанцией
        Параметр costs передает карту содержащую дистанцию которую необходимую пройти к узлу start
        Параметр processed передает список уже пройденных узлов
         */
        Node lowestCostNode = findLowestCostNode(costs, processed);
        //для расчета дистанции необходимо пройти каждый узел
        while (lowestCostNode != null) {
            //дистанция к ближайшему узлу
            int cost = costs.get(lowestCostNode);
            //дистанция к ближайшим узлам текущего узла lowestCostNode
            Map<Node, Integer> neighbors = lowestCostNode.getCosts();
            //обход соседей текущего узла lowestCostNode
            for (Node neighbor : neighbors.keySet()) {
                //сумма дистанции текущего узла lowestCostNode и его соседа
                int newCost = cost + neighbors.get(neighbor);
                //если сумма будет меньше дистанции до соседа текущего узла меняем значения в картах parents и costs
                if (costs.get(neighbor) > newCost) {
                    parents.put(neighbor, lowestCostNode);
                    costs.put(neighbor, newCost);
                }
            }
            //ищем следующий узел для обработки
            processed.add(lowestCostNode);
            lowestCostNode = findLowestCostNode(costs, processed);
        }

        return parents;
    }

    private static Node findLowestCostNode(Map<Node, Integer> costs,
                                                  Set<Node> processed) {

        int lowestCost = Integer.MAX_VALUE;
        Node lowestCostNode = null;

        for (Node node : costs.keySet()) {
            int cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }

        return lowestCostNode;
    }

    public static String printShortCut(Map<Node, Node> result) {

        StringBuilder builder = new StringBuilder();
        ArrayList<Node> list = new ArrayList<>(result.keySet());

        Node node = list.get(list.size()-1);

        while(node != null) {
            Node value = result.get(node);
            if(value != null) {
                builder.append(node.getValue()).append(" -> ").append(value.getValue()).append(" ");
            }
            node = value;
        }

        return builder.toString();
    }
}