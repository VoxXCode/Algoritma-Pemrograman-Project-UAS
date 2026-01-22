package org.example.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.algorithms.bst.BinarySearchTree;

import java.io.IOException;

public class BSTController {

    @FXML private TextField inputField;
    @FXML private Pane visualizerPane;
    @FXML private Label inOrderLabel, preOrderLabel, postOrderLabel;

    private BinarySearchTree bst = new BinarySearchTree();

    @FXML
    public void onInsert() {
        try {
            // 1. Ambil input
            int val = Integer.parseInt(inputField.getText());

            // 2. Masukkan ke Logic BST
            bst.insert(val);

            // 3. Update Teks Traversal
            updateTraversalLabels();

            // 4. Gambar Ulang Tree
            drawTree();

            inputField.clear();
        } catch (NumberFormatException e) {
            System.out.println("Input harus angka!");
        }
    }

    private void updateTraversalLabels() {
        preOrderLabel.setText("PreOrder: " + bst.getPreOrder());
        inOrderLabel.setText("InOrder:   " + bst.getInOrder());
        postOrderLabel.setText("PostOrder: " + bst.getPostOrder());
    }

    private void drawTree() {
        visualizerPane.getChildren().clear();
        if (bst.getRoot() != null) {
            // Mulai menggambar dari tengah atas panel
            double initialX = visualizerPane.getWidth() / 2;
            double initialY = 40;
            displayTree(bst.getRoot(), initialX, initialY, visualizerPane.getWidth() / 4);
        }
    }

    private void displayTree(org.example.algorithms.bst.BinarySearchTree.Node node, double x, double y, double hGap) {
        if (node.left != null) {
            Line line = new Line(x - hGap, y + 50, x, y);
            line.getStyleClass().add("bst-line"); // Pakai CSS
            visualizerPane.getChildren().add(line);
            displayTree(node.left, x - hGap, y + 50, hGap / 2);
        }
        if (node.right != null) {
            Line line = new Line(x + hGap, y + 50, x, y);
            line.getStyleClass().add("bst-line"); // Pakai CSS
            visualizerPane.getChildren().add(line);
            displayTree(node.right, x + hGap, y + 50, hGap / 2);
        }

        Circle circle = new Circle(x, y, 20);
        circle.getStyleClass().add("bst-node"); // Pakai CSS Class "bst-node"

        Text text = new Text(String.valueOf(node.key));
        text.setX(x - 6);
        text.setY(y + 5);
        text.getStyleClass().add("bst-text"); // Pakai CSS Class "bst-text"

        visualizerPane.getChildren().addAll(circle, text);
    }

    @FXML
    public void onBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Menu Utama");
    }
}