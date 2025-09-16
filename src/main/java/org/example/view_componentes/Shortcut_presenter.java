package org.example.view_componentes;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import org.example.controller.util.Cambiar_scene_con_util;
import org.example.model.DAO.Shortcut_DAO;
import org.example.model.DTO.Shortcut_DTO;
import org.example.model.DAO.DAOImpl.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Shortcut_presenter {

    // Definimos que devolvera una lista de tipo Node, ya que es el padre de VBox, pero es la manera correcta siendo mas flexible cambiando el tipo de componente a devolver (todos heredan de Node)
    // Pasamos el contenedor al que pertenece solo para obtener su ancho
    public static List<javafx.scene.Node> Shortcut_presenter(FlowPane fpContainer) {

        List<javafx.scene.Node> presentacion_shortcuts_array = new ArrayList<>();

        // Traemos el array con todos los registros
        ArrayList<Shortcut_DTO> registros = new Shortcut_DAO_impl().leer_todos_dao();

        for (Shortcut_DTO registro : registros) {
            // Creamos el VBox (que es un Node), que será el componente a devolver
            VBox presentacion_shortcuts = new VBox(5);

            // Agregamos los elementos
            presentacion_shortcuts.getChildren().add(new Label(registro.getTitulo()));
            presentacion_shortcuts.getChildren().add(new Label(registro.getTexto()));

            // Estilos
            presentacion_shortcuts.setStyle(
                    "-fx-padding: 20; " +
                    "-fx-border-width: 0px 0px 1px 0px; " +
                    "-fx-border-color: black;"
            ); // Estilos - Establecemos el cambio del cursor en hover
            presentacion_shortcuts.setCursor(Cursor.HAND);

            // Llamamos el dto para poder enviar su informacion a su propia escena al darle click
            Shortcut_DAO dao = new Shortcut_DAO_impl();
            Shortcut_DTO dto = dao.leer_dao(registro.getTitulo());

            // Creamos el evento click
            presentacion_shortcuts.setOnMouseClicked(event -> {
                // Aqui validamos si el boton recibio (getbutton), es el click izquierdo (primary)
                if (event.getButton() == MouseButton.PRIMARY) {
                    try {
                        // Cambiamos de escena enviando el dto como parametro
                        Cambiar_scene_con_util.cambiar_scene(event, "Editar_shortcut", dto);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            // Ancho igual al contenedor
            presentacion_shortcuts.prefWidthProperty().bind(fpContainer.widthProperty());

            // Guardamos como Node
            presentacion_shortcuts_array.add((Node) presentacion_shortcuts);
        }

        return presentacion_shortcuts_array;
    }

}
