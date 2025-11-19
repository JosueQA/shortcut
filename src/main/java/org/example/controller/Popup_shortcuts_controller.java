package org.example.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import org.example.controller.util.Correcciones_titulo_con_util;
import org.example.controller.util.Shortcut_presenter_filtro_con_util;
import org.example.view_componentes.Shortcut_presenter;
import java.util.List;

public class Popup_shortcuts_controller {

    @FXML
    public ScrollPane spShortCutsScrollContenedor;
    // Lista que posee todos los shortcuts registrados en la bd
    private List<Node> presentacion_shortcuts_array;

    @FXML
    private FlowPane fpShortCutsContenedor;

    @FXML
    private TextField txtBuscar;

    @FXML
    public void initialize() {

        Platform.runLater(() -> {
            int cant = 0;

            // Creamos una nueva presentacion de un shortcut
            presentacion_shortcuts_array = Shortcut_presenter.Shortcut_presenter(fpShortCutsContenedor);

            // En un bucle, agregamos cada VBox del array como hijo del contenedor
            for (Node presentacion_shortcuts : presentacion_shortcuts_array) {
                fpShortCutsContenedor.getChildren().add((javafx.scene.Node) presentacion_shortcuts);
                cant++;
            }

            int finalCant = cant;

            Platform.runLater(() -> {
                Double x = ((VBox) presentacion_shortcuts_array.get(0)).getHeight();
                System.out.println(x);
                System.out.println(x* finalCant);

                System.out.println(spShortCutsScrollContenedor.getHeight());
                System.out.println(fpShortCutsContenedor.getHeight());

                spShortCutsScrollContenedor.setPrefHeight(finalCant);



            });


        });

    }

    @FXML
    private void onTituloIngresado(){
        // Cambiamos los espacios por "_"
        Correcciones_titulo_con_util.Correccion_espacios_titulo(txtBuscar);

        // Filtramos los shortcuts a aparecer usando el buscador
        Shortcut_presenter_filtro_con_util.filtro_busqueda(txtBuscar.getText());
    }
}

