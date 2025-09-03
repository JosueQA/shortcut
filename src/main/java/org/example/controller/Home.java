package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import java.io.IOException;

public class Home {

    @FXML
    private TextField txtBuscar;

    @FXML
    private Button btnAgregarNuevo;

    // Vamos a la interfaz de crear nuevos shortcut
    @FXML
    private void onAgregarNuevoClick(ActionEvent event) throws IOException {
        // Cargar el nuevo FXML
        Parent Short_cut = FXMLLoader.load(getClass().getResource("/view/Agregar_Shortcut.fxml"));

        // Obtener el stage actual a partir del botón
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cambiar la escena
        stage.setScene(new Scene(Short_cut));
        stage.show();
    }
}
