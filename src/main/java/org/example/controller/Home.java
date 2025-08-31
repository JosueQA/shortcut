package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Home {

    @FXML
    private TextField txtBuscar;

    @FXML
    private Button btnAgregarNuevo;

    // Método llamado cuando se hace clic en el botón "Agregar nuevo"
    @FXML
    private void onAgregarNuevoClick() {
        String buscarTexto = txtBuscar.getText();
        if (buscarTexto.equals("")) {
            System.out.println("Texto no puede ser vacio");
        } else {
            System.out.println("Nuevo elemento a agregar: " + buscarTexto);
        }

    }
}
