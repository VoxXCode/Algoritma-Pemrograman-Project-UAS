package org.example.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // --- Debugging Start ---
        String fxmlPath = "/fxml/MainView.fxml";
        URL resource = getClass().getResource(fxmlPath);

        if (resource == null) {
            System.err.println("FATAL ERROR: File FXML tidak ditemukan di path: " + fxmlPath);
            System.err.println("Cek apakah file ada di: target/classes/fxml/MainView.fxml");
            System.exit(1);
        } else {
            System.out.println("SUKSES: File FXML ditemukan di: " + resource);
        }
        // --- Debugging End ---

        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Aplikasi Algoritma UAS - Kelompok IT");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}