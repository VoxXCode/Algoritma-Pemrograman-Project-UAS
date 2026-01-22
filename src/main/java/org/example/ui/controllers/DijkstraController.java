package org.example.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.algorithms.dijkstra.DijkstraSolver;

import java.io.IOException;
import java.util.List;

public class DijkstraController {

    @FXML private TextField nodeCountField, sourceField, destField, weightField, startNodeField, targetNodeField;
    @FXML private Pane graphPane;
    @FXML private HBox edgeInputBox, actionBox;
    @FXML private Label statusLabel;

    private DijkstraSolver solver;
    private int maxNodes;

    // Menyimpan posisi koordinat setiap node (x, y)
    private double[][] nodePositions;

    @FXML
    public void onCreateGraph() {
        try {
            maxNodes = Integer.parseInt(nodeCountField.getText());
            solver = new DijkstraSolver(maxNodes);

            // Siapkan array posisi
            nodePositions = new double[maxNodes][2];
            calculateNodePositions(); // Hitung posisi melingkar

            edgeInputBox.setDisable(false);
            actionBox.setDisable(false);

            drawGraph(null); // Gambar graf kosong (hanya node)
            statusLabel.setText("Graf dibuat dengan " + maxNodes + " node.");
        } catch (NumberFormatException e) {
            statusLabel.setText("Error: Masukkan jumlah node yang valid.");
        }
    }

    // Menghitung posisi node agar membentuk lingkaran
    private void calculateNodePositions() {
        double centerX = graphPane.getWidth() / 2;
        double centerY = graphPane.getHeight() / 2;
        double radius = Math.min(centerX, centerY) - 50; // Jarak dari tengah

        for (int i = 0; i < maxNodes; i++) {
            double angle = 2 * Math.PI * i / maxNodes; // Bagi lingkaran rata
            nodePositions[i][0] = centerX + radius * Math.cos(angle); // X
            nodePositions[i][1] = centerY + radius * Math.sin(angle); // Y
        }
    }

    @FXML
    public void onAddEdge() {
        try {
            int u = Integer.parseInt(sourceField.getText());
            int v = Integer.parseInt(destField.getText());
            int w = Integer.parseInt(weightField.getText());

            if (u >= maxNodes || v >= maxNodes) {
                statusLabel.setText("Error: Node tidak valid (maks " + (maxNodes-1) + ")");
                return;
            }

            solver.addEdge(u, v, w);
            // solver.addEdge(v, u, w); // Aktifkan jika graf tidak berarah (bolak-balik)

            drawGraph(null); // Gambar ulang graf dengan garis baru
            statusLabel.setText("Jalur " + u + " -> " + v + " (" + w + ") ditambahkan.");

            sourceField.clear(); destField.clear(); weightField.clear();
        } catch (Exception e) {
            statusLabel.setText("Error: Input harus angka.");
        }
    }

    @FXML
    public void onSolve() {
        try {
            int start = Integer.parseInt(startNodeField.getText());
            int target = Integer.parseInt(targetNodeField.getText());

            solver.solve(start);
            List<Integer> path = solver.getPath(target);
            int dist = solver.getDistance(target);

            if (path.isEmpty()) {
                statusLabel.setText("Tidak ada jalur dari " + start + " ke " + target);
                drawGraph(null); // Reset warna
            } else {
                statusLabel.setText("Jalur Terpendek: " + path + "\nTotal Jarak: " + dist);
                drawGraph(path); // Gambar ulang dengan highlight jalur hijau
            }
        } catch (Exception e) {
            statusLabel.setText("Error: Cek input start/target.");
        }
    }

    // Fungsi Utama Menggambar
    private void drawGraph(List<Integer> highlightPath) {
        graphPane.getChildren().clear();

        // 1. Gambar Garis (Edge)
        List<List<DijkstraSolver.Node>> adj = solver.getAdj();
        for (int u = 0; u < maxNodes; u++) {
            for (DijkstraSolver.Node neighbor : adj.get(u)) {
                int v = neighbor.node;

                Line line = new Line(nodePositions[u][0], nodePositions[u][1], nodePositions[v][0], nodePositions[v][1]);
                line.setStrokeWidth(2);

                // Cek apakah garis ini bagian dari solusi (Highlight)
                if (highlightPath != null && isEdgeInPath(u, v, highlightPath)) {
                    line.setStroke(javafx.scene.paint.Color.RED); // Warna Jalur Solusi
                    line.setStrokeWidth(4);
                } else {
                    line.setStroke(javafx.scene.paint.Color.LIGHTGRAY);
                }

                // Teks Berat (Weight) di tengah garis
                Text weightText = new Text((nodePositions[u][0] + nodePositions[v][0])/2,
                        (nodePositions[u][1] + nodePositions[v][1])/2,
                        String.valueOf(neighbor.cost));

                graphPane.getChildren().addAll(line, weightText);
            }
        }

        // 2. Gambar Lingkaran (Node)
        for (int i = 0; i < maxNodes; i++) {
            Circle circle = new Circle(nodePositions[i][0], nodePositions[i][1], 20);

            // Cek apakah node bagian dari solusi
            if (highlightPath != null && highlightPath.contains(i)) {
                circle.setFill(javafx.scene.paint.Color.YELLOW);
                circle.setStroke(javafx.scene.paint.Color.ORANGE);
            } else {
                circle.setFill(javafx.scene.paint.Color.DODGERBLUE);
                circle.setStroke(javafx.scene.paint.Color.BLACK);
            }

            Text text = new Text(nodePositions[i][0] - 4, nodePositions[i][1] + 4, String.valueOf(i));
            text.setStyle("-fx-font-weight: bold; -fx-fill: white;"); // Agar angka terlihat jelas

            graphPane.getChildren().addAll(circle, text);
        }
    }

    // Helper untuk mengecek apakah garis u->v ada dalam urutan jalur solusi
    private boolean isEdgeInPath(int u, int v, List<Integer> path) {
        for (int i = 0; i < path.size() - 1; i++) {
            // Jika jalur melewati u lalu v (berurutan)
            if (path.get(i) == u && path.get(i+1) == v) return true;
            // Jika graf tidak berarah, cek juga kebalikannya
            // if (path.get(i) == v && path.get(i+1) == u) return true;
        }
        return false;
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