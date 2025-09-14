package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import java.util.Objects;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Debe existir: src/main/resources/view/Home.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(
                Objects.requireNonNull(Main.class.getResource("/view/Home.fxml"),
                        "No encuentro /view/Home.fxml en resources")
        );
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Shortcuts");
        stage.setScene(scene);
        stage.sizeToScene();
        System.out.println("Se cargo correctamente");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}