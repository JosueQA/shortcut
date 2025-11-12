package org.example.controller.util;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.Main;
import org.example.view_componentes.Shortcut_presenter;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Abrir_ventana_con_util {

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

    // Usado para el popup al elegir
    public static void abrir_popup(String ventana, String titulo) {
        // Height: Es el alto de la 1era busqueda al detectar la tecla

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

                // DEFINIMOS EL ALTO INICIAL DEL POPUP
                // Calculamos el alto total segun el total de shortcuts existentes

                /*
                * Traer el array con los shortcuts
                * Iterar y obtener el total
                * Obtener el height de 1
                * Multiplicar el height por el total y colocarlo como height
                * */

                // Obtenemos la altura multiplicando el total de shortcuts por la altura de 1
                double height = Shortcut_presenter.presentacion_shortcuts_array_cantidad * Shortcut_presenter.presentacion_shortcuts_array_altura;
                System.out.println(Shortcut_presenter.presentacion_shortcuts_array_cantidad + " " + Shortcut_presenter.presentacion_shortcuts_array_altura + " " + height);
                stage.setHeight(height);

                stage.show();
            } catch (IOException e) {
                throw new RuntimeException("Error al mostrar la ventana", e);
            }
        });
    }

}
