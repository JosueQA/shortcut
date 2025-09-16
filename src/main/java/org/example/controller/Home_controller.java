package org.example.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import org.example.controller.util.Cambiar_scene_con_util;
import org.example.controller.util.Correcciones_titulo_con_util;
import org.example.view_componentes.Shortcut_presenter;
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
        Cambiar_scene_con_util.cambiar_scene(event, "Agregar_Shortcut");
    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            // Creamos una nueva presentacion de un shortcut
            presentacion_shortcuts_array = Shortcut_presenter.Shortcut_presenter(fpShortCutsContenedor);

            // En un bucle, agregamos cada VBox del array como hijo del contenedor
            for (Node presentacion_shortcuts : presentacion_shortcuts_array) {
                fpShortCutsContenedor.getChildren().add((javafx.scene.Node) presentacion_shortcuts);
            }
        });
    }

    @FXML
    private void onTituloIngresado(){
        // Cambiamos los espacios por "_"
        Correcciones_titulo_con_util.Correccion_espacios_titulo(txtBuscar);


        // FILTRAMOS LOS SHORTCUTS A APARECER EN EL FLOWPANEL -------------------------------------------------------

        // Obtenemos el string ingresado
        String valor_ingresado = txtBuscar.getText().toLowerCase();

        // En un bucle, agregamos cada VBox del array como hijo del contenedor SEGUN los valores iniciales del titulo
        for (Node presentacion_shortcuts : presentacion_shortcuts_array) {

            // El elemento es un VBox, por lo que lo casteamos para poder obtener sus componentes hijos
            VBox vbox_shortcut = (VBox) presentacion_shortcuts;

            // Obtenemos el titulo de cada shortcut (lo casteamos a label, que es su tipo, y obtenemos el valor)
            String titulo_shortcut = ((Label) vbox_shortcut.getChildren().get(0)).getText().toLowerCase();

            // Aqui validamos si el valor del buscador es menor al tamaño del titulo
            if (valor_ingresado.length() < titulo_shortcut.length()) {
                // Obtenemos la misma cantidad de caracteres del valor ingresado que tiene el titulo del shortcut 
                String comparacion = titulo_shortcut.substring(0, valor_ingresado.length());
                // Si es igual aparece, y sino no
                if (valor_ingresado.equals(comparacion)) {
                    presentacion_shortcuts.setManaged(true);
                    presentacion_shortcuts.setVisible(true);
                } else {
                    presentacion_shortcuts.setManaged(false);
                    presentacion_shortcuts.setVisible(false);
                }
                // A continuación igualamos si ambos valores tienen el mismo tamaño, y determinamos lo mismo
            } else if (valor_ingresado.length() == titulo_shortcut.length()) {
                if (valor_ingresado.equals(titulo_shortcut)) {
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
    }}

}
