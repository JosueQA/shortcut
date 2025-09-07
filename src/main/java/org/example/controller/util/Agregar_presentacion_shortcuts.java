package org.example.controller.util;

import org.example.conexion.Conexion;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;



public class Agregar_presentacion_shortcuts {

    public static VBox Agregar_presentacion_shortcuts(FlowPane fpContainer) {
        // Creamos el VBox
        VBox presentacion_short_cut = new VBox(5);

        // Definimos sus estilos
        presentacion_short_cut.setStyle(
                "-fx-padding: 20; " +
                        "-fx-border-width: 1px 0px 1px 0px;" +
                        "-fx-border-color: black");

        // Definimos que su ancho sera del mismo que su contenedor
        presentacion_short_cut.prefWidthProperty().bind(fpContainer.widthProperty());

        // Creamos componentes
        Label lblTitulo = new Label("Titulo");
        Label lblTexto = new Label("Texto...");

        // Agregamos los componentes a la presentacion del shorcut
        presentacion_short_cut.getChildren().add(lblTitulo);
        presentacion_short_cut.getChildren().add(lblTexto);


        return presentacion_short_cut;
    }

}
