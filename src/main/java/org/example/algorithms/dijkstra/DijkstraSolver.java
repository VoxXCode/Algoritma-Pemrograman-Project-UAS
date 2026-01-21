package org.example.algorithms.dijkstra;

import java.util.*;

public class DijkstraSolver {
    private int V; // Jumlah vertices (titik)
    private List<List<Node>> adj; // Adjacency List

    // Class internal untuk representasi Edge/Node tetangga
    static class Node implements Comparator<Node> {
        public int node;
        public int cost;

        public Node() {}
        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.cost, node2.cost);
        }
    }

    public DijkstraSolver(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Input data graph dari User
    public void addEdge(int source, int dest, int weight) {
        adj.get(source).add(new Node(dest, weight));
        // Jika graph tidak berarah (undirected), tambahkan baris ini:
        // adj.get(dest).add(new Node(source, weight));
    }

    public void solve(int src) {
        // TODO: Implementasi logika PriorityQueue untuk Dijkstra di sini
        PriorityQueue<Node> pq = new PriorityQueue<>(V, new Node());

        // Array jarak, inisialisasi dengan MAX_VALUE
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Masukkan source node
        pq.add(new Node(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            // Logika utama Dijkstra...
            // 1. Ambil node dengan jarak terpendek
            // 2. Iterasi tetangganya
            // 3. Update jarak jika ditemukan jalur lebih pendek
            Node u = pq.poll();
            // ... (lanjutkan implementasi)
        }

        // Print hasil
        printSolution(dist, src);
    }

    private void printSolution(int[] dist, int src) {
        System.out.println("Jarak terpendek dari Node " + src + ":");
        for (int i = 0; i < V; i++)
            System.out.println(src + " -> " + i + " : " + dist[i]);
    }
}