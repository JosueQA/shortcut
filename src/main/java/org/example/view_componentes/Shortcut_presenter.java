package org.example.view_componentes;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import org.example.controller.util.Cambiar_ventana_con_util;
import org.example.model.DAO.Shortcut_DAO;
import org.example.model.DTO.Shortcut_DTO;
import org.example.model.DAO.DAOImpl.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Shortcut_presenter {

    // Cantidad de shortcuts como VBOX
    public static int presentacion_shortcuts_array_cantidad = 0;
    // Altura de 1 shortcut como VBOX
    public static double presentacion_shortcuts_array_altura = 0.00;

    // Definimos que devolvera una lista de tipo Node, ya que es el padre de VBox, pero es la manera correcta siendo mas flexible cambiando el tipo de componente a devolver (todos heredan de Node)
    // PARAMERTO: Pasamos el contenedor al que pertenece solo para obtener su ancho
    public static List<javafx.scene.Node> Shortcut_presenter(Node fpContainer) {

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
                        Cambiar_ventana_con_util.cambiar_scene(event, "Editar_shortcut", dto);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            // Ancho igual al contenedor
            presentacion_shortcuts.prefWidthProperty().bind(fpContainer.getScene().widthProperty());

            // Guardamos como Node
            presentacion_shortcuts_array.add((Node) presentacion_shortcuts);

            // Sumamos 1 a la cantidad total de height existentes ---------------------------------------
            presentacion_shortcuts_array_cantidad++;
        }
        // Calculamos la altura de 1 height para conocer la altura de cada uno ----------------------
        presentacion_shortcuts_array_altura = ((VBox) presentacion_shortcuts_array.get(0)).getHeight();

        // Array de stodos los ahortcuts existentes como VBOX cada uno
        return presentacion_shortcuts_array;
    }

}
