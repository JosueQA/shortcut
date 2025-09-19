package org.example.controller.util;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.Main;

import java.io.IOException;
import java.util.Objects;

public class Mostrar_ventana {

    // Usado para main
    public static void mostrar_ventana(Stage stage, String ventana, String titulo) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Objects.requireNonNull(Main.class.getResource("/view/" + ventana + ".fxml"), "No encuentro /view/" + ventana +".fxml en resources")
        );
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    // Usado para demas archivos
    public static void mostrar_ventana(String ventana, String titulo){
        // Lo englobamos en el siguiente metodo, ya que este dice "corre esto despues, cuando puedas, porque podemos estar en otro hilo, y en dicho caso tendriamos problemas al ejecutar en el hilo de javafx
        Platform.runLater(() -> {

            try {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(
                        Objects.requireNonNull(Main.class.getResource("/view/" + ventana + ".fxml"), "No encuentro /view/" + ventana +".fxml en resources")
                );
                Scene scene = null;
                scene = new Scene(fxmlLoader.load());
                stage.setTitle(titulo);
                stage.setScene(scene);
                stage.sizeToScene();
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException("Error al mostrar la ventana", e);
            }
        });
    }

}
