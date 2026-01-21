package org.example.algorithms.bst;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // --- FITUR 1: INSERT (Input Nilai) ---
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        // TODO: Lengkapi logika insert BST di sini
        // Jika tree kosong, return node baru
        // Jika key < root.key, ke kiri. Jika key > root.key, ke kanan.
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // --- FITUR 2: TRAVERSAL (PreOrder, InOrder, PostOrder) ---
    public void inorder() {
        System.out.print("InOrder: ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        // TODO: Lengkapi logika InOrder (Left, Root, Right)
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

}