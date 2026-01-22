package org.example.ui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;

public class MainController {

    @FXML
    public void onOpenBST(ActionEvent event) throws IOException {
        loadScene(event, "/fxml/BSTView.fxml", "Visualisasi BST");
    }

    @FXML
    public void onOpenDijkstra(ActionEvent event) throws IOException {
        loadScene(event, "/fxml/DijkstraView.fxml", "Visualisasi Dijkstra");
    }

    @FXML
    public void onExit() {
        System.exit(0);
    }

    private void loadScene(ActionEvent event, String fxmlPath, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();
    }
}