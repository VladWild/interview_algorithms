package vlad.wild.yandex.praktikum.chapter3.lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Алгоритм Дейкстры
 */
public class Dijkstra {

    public static void main(String[] args) {
        int n = 6; // Кол-во вершин
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Добавление рёбер (пример для неориентированного графа)
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 2));
        graph.get(1).add(new Edge(2, 5));
        graph.get(1).add(new Edge(3, 10));
        graph.get(2).add(new Edge(4, 3));
        graph.get(4).add(new Edge(3, 4));
        graph.get(3).add(new Edge(5, 11));

        // Запуск
        dijkstra(0, graph); // стартовая вершина — 0
    }

    public static void dijkstra(int start, List<List<Edge>> graph) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // Приоритетная очередь (минимальное расстояние — в приоритете)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int currentDist = current[1];

            if (currentDist > dist[node]) continue; // Уже нашли короче

            for (Edge edge : graph.get(node)) {
                int newDist = dist[node] + edge.weight;
                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    pq.offer(new int[]{edge.to, newDist});
                }
            }
        }

        // Вывод результата
        for (int i = 0; i < n; i++) {
            System.out.println("Кратчайшее расстояние до " + i + " = " +
                    (dist[i] == Integer.MAX_VALUE ? "∞" : dist[i]));
        }
    }

    static class Edge {
        int to, weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
