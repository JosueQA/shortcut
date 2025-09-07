package org.example.controller.util;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import org.example.model.DTO.Shortcut_DTO;
import org.example.model.DAO.DAOImpl.*;

import java.util.ArrayList;


public class Agregar_presentacion_shortcuts {

    public static ArrayList<VBox> Agregar_presentacion_shortcuts(FlowPane fpContainer) {
        ArrayList<VBox> presentacion_shortcuts_array = new ArrayList<>();
        // Traemos el array con todos los registros
        ArrayList<Shortcut_DTO> registros = new Shortcut_DAO_impl().leer_todos_dao();

        for (Shortcut_DTO registro : registros) {
            // Creamos el VBox
            VBox presentacion_shortcuts = new VBox(5);

            // Agregamos los elementos, para esto debemos pasar un label (tenemos que convertirlo, ya que JavaFx no acepta String, solo tipos de datos heredados de "Node"
            presentacion_shortcuts.getChildren().add(new Label(registro.getTitulo()));
            presentacion_shortcuts.getChildren().add(new Label(registro.getTexto()));

            // Definimos sus estilos
            presentacion_shortcuts.setStyle(
                    "-fx-padding: 20; " +
                            "-fx-border-width: 0px 0px 1px 0px;" +
                            "-fx-border-color: black");
            // su ancho sera del mismo que su contenedor
            presentacion_shortcuts.prefWidthProperty().bind(fpContainer.widthProperty());

            // Introducimos el VBox en el arraylist
            presentacion_shortcuts_array.add(presentacion_shortcuts);
        }

        return presentacion_shortcuts_array;
    }

}
