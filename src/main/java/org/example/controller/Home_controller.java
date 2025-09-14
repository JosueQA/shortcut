package org.example.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import org.example.controller.util.Correcciones_titulo;
import org.example.controller.util.Shortcut_presenter;
import org.example.controller.util.Cambiar_scene;
import javafx.scene.Node;
import java.io.IOException;
import java.util.List;

public class Home_controller {

    @FXML
    private TextField txtBuscar;

    @FXML
    private Button btnAgregarNuevo;

    @FXML
    private FlowPane fpShortCutsContenedor;

    @FXML
    private void onTituloIngresado(){
        Correcciones_titulo.Correccion_espacios_titulo(txtBuscar);
    }

    // Vamos a la interfaz de crear nuevos shortcut
    @FXML
    private void onAgregarNuevoClick(ActionEvent event) throws IOException {
        Cambiar_scene.cambiar_scene(event, "Agregar_Shortcut");
    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {

            // Creamos una nueva presentacion de un shortcut
            List<Node> presentacion_shortcuts_array = Shortcut_presenter.Shortcut_presenter(fpShortCutsContenedor);

            // En un bucle, agregamos cada VBox del array como hijo del contenedor
            for (Node presentacion_shortcuts : presentacion_shortcuts_array) {
                fpShortCutsContenedor.getChildren().add((javafx.scene.Node) presentacion_shortcuts);
            }

        });
    }

}
