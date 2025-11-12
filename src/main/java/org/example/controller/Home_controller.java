package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import org.example.controller.util.*;
import javafx.scene.Node;
import java.io.IOException;
import java.util.List;

public class Home_controller {

     // Lista que posee todos los shortcuts registrados en la bd
    private List<Node> presentacion_shortcuts_array;

    @FXML
    private TextField txtBuscar;

    @FXML
    private Button btnAgregarNuevo;

    @FXML
    private FlowPane fpShortCutsContenedor;

    // Vamos a la interfaz de crear nuevos shortcut
    @FXML
    private void onAgregarNuevoClick(ActionEvent event) throws IOException {
        Cambiar_ventana_con_util.cambiar_scene(event, "Agregar_Shortcut");
    }

    @FXML
    public void initialize() {
        Shortcut_presenter_filtro_con_util.filtro_no(fpShortCutsContenedor);
    }

    @FXML
    private void onTituloIngresado(){
        // Cambiamos los espacios por "_"
        Correcciones_titulo_con_util.Correccion_espacios_titulo(txtBuscar);

        // Filtramos los shortcuts a aparecer usando el buscador
        Shortcut_presenter_filtro_con_util.filtro_busqueda(txtBuscar.getText());
    }}


