package org.example.controller.util;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.example.view_componentes.Shortcut_presenter;

import java.util.List;

public class Shortcut_presenter_filtro_con_util {

    // presentacion_shortcuts_array: Lista que posee todos los shortcuts registrados en la bd como VBOX
    public static List<Node> presentacion_shortcuts_array;


    // INDISPENSABLE usar este filtro
    public static void filtro_no(Pane contenedor){
        // Creamos una nueva presentacion de un shortcut
        Platform.runLater(() -> {
            presentacion_shortcuts_array = Shortcut_presenter.Shortcut_presenter(contenedor);
            // En un bucle, agregamos cada VBox del array como hijo del contenedor
            for (Node presentacion_shortcuts : presentacion_shortcuts_array) {
                // Agregamos el VBox al contenedor
                contenedor.getChildren().add((javafx.scene.Node) presentacion_shortcuts);
            }
        });
    }

    public static void filtro_busqueda(String busqueda) {

        busqueda = busqueda.toLowerCase();

        // En un bucle, agregamos cada VBox del array como hijo del contenedor SEGUN los valores iniciales del titulo
        for (Node presentacion_shortcuts : presentacion_shortcuts_array) {

            // El elemento es un VBox, por lo que lo casteamos para poder obtener sus componentes hijos
            VBox vbox_shortcut = (VBox) presentacion_shortcuts;

            // Obtenemos el titulo de cada shortcut (lo casteamos a label, que es su tipo, y obtenemos el valor)
            String titulo_shortcut = ((Label) vbox_shortcut.getChildren().get(0)).getText().toLowerCase();

            // Aqui validamos si el valor del buscador es menor al tamaño del titulo
            if (busqueda.length() < titulo_shortcut.length()) {
                // Obtenemos la misma cantidad de caracteres del valor ingresado que tiene el titulo del shortcut
                String comparacion = titulo_shortcut.substring(0, busqueda.length());
                // Si es igual aparece, y sino no
                if (busqueda.equals(comparacion)) {
                    presentacion_shortcuts.setManaged(true);
                    presentacion_shortcuts.setVisible(true);
                } else {
                    presentacion_shortcuts.setManaged(false);
                    presentacion_shortcuts.setVisible(false);
                }
                // A continuación igualamos si ambos valores tienen el mismo tamaño, y determinamos lo mismo
            } else if (busqueda.length() == titulo_shortcut.length()) {
                if (busqueda.equals(titulo_shortcut)) {
                    presentacion_shortcuts.setManaged(true);
                    presentacion_shortcuts.setVisible(true);
                } else {
                    presentacion_shortcuts.setManaged(false);
                    presentacion_shortcuts.setVisible(false);
                }
            } else {
                presentacion_shortcuts.setManaged(false);
                presentacion_shortcuts.setVisible(false);
            }
            /* ¿Como aparecen todos sin que haya algun valor en el buscador?
                Pues simple, porque cuando no hay ningun valor, su length es 0, al sacar el substring(0, 0) la respuesta es 0, entonces 0 == 0 es true, por lo que se ejecuta la condicional que verifica si "el valor ingresado es igual al String comparacion"
             */
    }

    }
}
