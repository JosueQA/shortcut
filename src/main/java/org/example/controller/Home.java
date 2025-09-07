package org.example.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import org.example.controller.util.Agregar_presentacion_shortcuts;
import org.example.controller.util.Cambiar_scene;

import java.io.IOException;
import java.util.ArrayList;

public class Home {

    @FXML
    private TextField txtBuscar;

    @FXML
    private Button btnAgregarNuevo;

    @FXML
    private FlowPane fpShortCutsContenedor;

    // Vamos a la interfaz de crear nuevos shortcut
    @FXML
    private void onAgregarNuevoClick(ActionEvent event) throws IOException {
        Cambiar_scene.cambiar_scene(event, "Agregar_Shortcut");
    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {

            // Creamos una nueva presentacion de un shortcut
            ArrayList<VBox> presentacion_shortcuts_array = Agregar_presentacion_shortcuts.Agregar_presentacion_shortcuts(fpShortCutsContenedor);

            // En un bucle, agregamos cada VBox del array como hijo del contenedor
            for (VBox presentacion_shortcuts : presentacion_shortcuts_array) {
                fpShortCutsContenedor.getChildren().add(presentacion_shortcuts);
            }

        });
    }

}
