package org.example.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import org.example.view_componentes.Shortcut_presenter;

import java.util.List;

public class Popup_shortcuts {

    // Lista que posee todos los shortcuts registrados en la bd
    private List<Node> presentacion_shortcuts_array;

    @FXML
    private FlowPane fpShortCutsContenedor;

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            // Creamos una nueva presentacion de un shortcut
            presentacion_shortcuts_array = Shortcut_presenter.Shortcut_presenter(fpShortCutsContenedor);

            // En un bucle, agregamos cada VBox del array como hijo del contenedor
            for (Node presentacion_shortcuts : presentacion_shortcuts_array) {
                fpShortCutsContenedor.getChildren().add((javafx.scene.Node) presentacion_shortcuts);
            }
        });
    }

}
