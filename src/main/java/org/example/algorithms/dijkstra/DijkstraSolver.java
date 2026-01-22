package org.example.algorithms.dijkstra;

import java.util.*;

public class DijkstraSolver {
    private int V;
    private List<List<Node>> adj;
    private int[] parent; // Pindahkan ke sini agar bisa diakses public
    private int[] dist;   // Simpan jarak juga

    // Class Node tetap sama, pastikan public static agar bisa diakses Controller
    public static class Node implements Comparator<Node> {
        public int node;
        public int cost;

        public Node() {}
        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node n1, Node n2) {
            return Integer.compare(n1.cost, n2.cost);
        }
    }

    public DijkstraSolver(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    }

    public void addEdge(int source, int dest, int weight) {
        adj.get(source).add(new Node(dest, weight));
    }

    // Getter untuk Visualisasi di Controller
    public List<List<Node>> getAdj() { return adj; }

    public void solve(int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>(V, new Node());
        dist = new int[V];
        parent = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().node;

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.cost;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
    }

    // Method baru: Mengambil urutan node jalur terpendek
    public List<Integer> getPath(int target) {
        List<Integer> path = new ArrayList<>();
        if (dist == null || target >= V || dist[target] == Integer.MAX_VALUE) {
            return path; // Kosong jika tidak ada jalur
        }

        for (int v = target; v != -1; v = parent[v]) {
            path.add(v);
        }
        Collections.reverse(path); // Balik urutan agar dari Source -> Dest
        return path;
    }

    // Ambil total jarak
    public int getDistance(int target) {
        if (dist == null || target >= V) return -1;
        return dist[target];
    }
}