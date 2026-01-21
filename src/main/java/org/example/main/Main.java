package org.example.main;

import org.example.algorithms.bst.BinarySearchTree;
import org.example.algorithms.dijkstra.DijkstraSolver;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Algoritma Pemrograman Project UAS ===");

        while (running) {
            System.out.println("\nPilih Menu:");
            System.out.println("1. Binary Search Tree (Input & Traversal)");
            System.out.println("2. Algoritma Dijkstra (Shortest Path)");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    runBSTDemo(scanner);
                    break;
                case 2:
                    runDijkstraDemo(scanner);
                    break;
                case 0:
                    running = false;
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }

    private static void runBSTDemo(Scanner scanner) {
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("\n--- Mode BST ---");
        System.out.print("Masukkan jumlah angka yang ingin diinput: ");
        int n = scanner.nextInt();

        System.out.println("Masukkan " + n + " angka:");
        for(int i=0; i<n; i++) {
            bst.insert(scanner.nextInt());
        }

        System.out.println("Hasil Traversal:");
        bst.inorder();
        // bst.preorder();
    }

    private static void runDijkstraDemo(Scanner scanner) {
        System.out.println("\n--- Mode Dijkstra ---");
        System.out.print("Masukkan jumlah node (vertex): ");
        int v = scanner.nextInt();
        DijkstraSolver graph = new DijkstraSolver(v);

        System.out.print("Masukkan jumlah edge (garis): ");
        int e = scanner.nextInt();

        System.out.println("Masukkan edge dengan format: [Source] [Dest] [Weight]");
        for (int i = 0; i < e; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(src, dest, weight);
        }

        System.out.print("Mulai cari jarak dari node mana (0 - " + (v-1) + ")? ");
        int startNode = scanner.nextInt();
        graph.solve(startNode);
    }
}