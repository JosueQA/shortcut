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
            System.out.println("Todo cargado y visible");

            // Creamos una nueva presentacion de un shortcut
            VBox short_cut = Agregar_presentacion_shortcuts.Agregar_presentacion_shortcuts(fpShortCutsContenedor);

            // Agregamos el VBox como hijo del contenedor
            fpShortCutsContenedor.getChildren().add(short_cut);

        });
    }

}
