package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Сar");
        stage.setResizable(false);

        Pane root = FXMLLoader.load(getClass().getResource("App.fxml"));

        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}