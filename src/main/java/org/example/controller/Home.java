package org.example.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import org.example.util.Cambiar_scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

            // Creamos el VBox
            VBox short_cut = new VBox(10);
            // Definimos sus atributos
            short_cut.setPrefHeight(100);
            short_cut.prefWidthProperty().bind(fpShortCutsContenedor.widthProperty());

            // Creamos un nuevo componente
            TextField txtBuscar = new TextField("Hello");

            // Agregamos componentes como hijo del VBox
            short_cut.getChildren().add(txtBuscar);

            // Agregamos el VBox como hijo del contenedor
            fpShortCutsContenedor.getChildren().add(short_cut);

        });
    }

}
