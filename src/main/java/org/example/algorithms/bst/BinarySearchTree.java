package org.example.algorithms.bst;

public class BinarySearchTree {

    // 1. Buat Node jadi public static agar bisa diakses Visualizer
    public static class Node {
        public int key;
        public Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // 2. Getter Root untuk Controller
    public Node getRoot() {
        return root;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
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

    // 3. Ubah Traversal agar mengembalikan String (untuk ditampilkan di UI)
    public String getInOrder() {
        StringBuilder sb = new StringBuilder();
        inorderRec(root, sb);
        return sb.toString();
    }
    private void inorderRec(Node root, StringBuilder sb) {
        if (root != null) {
            inorderRec(root.left, sb);
            sb.append(root.key).append(" ");
            inorderRec(root.right, sb);
        }
    }

    public String getPreOrder() {
        StringBuilder sb = new StringBuilder();
        preorderRec(root, sb);
        return sb.toString();
    }
    private void preorderRec(Node root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.key).append(" ");
            preorderRec(root.left, sb);
            preorderRec(root.right, sb);
        }
    }

    public String getPostOrder() {
        StringBuilder sb = new StringBuilder();
        postorderRec(root, sb);
        return sb.toString();
    }
    private void postorderRec(Node root, StringBuilder sb) {
        if (root != null) {
            postorderRec(root.left, sb);
            postorderRec(root.right, sb);
            sb.append(root.key).append(" ");
        }
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }
    private boolean searchRec(Node root, int key) {
        if (root == null) return false;
        if (root.key == key) return true;
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }
}