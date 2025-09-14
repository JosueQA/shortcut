package org.example.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.controller.util.Cambiar_scene_con_util;
import org.example.controller.util.Correcciones_titulo_con_util;
import org.example.controller.util.Guardar_shortcuts_con_util;

import java.io.IOException;

public class Agregar_Shorcut_controller {

    @FXML
    private TextField txtTitulo;

    @FXML
    private Label lblTituloError;

    @FXML
    private TextArea txtTexto;

    @FXML
    private Label lblTextoError;

    @FXML
    private void onTituloIngresado(){
        // Cambiamos los espacios por "_"
        Correcciones_titulo_con_util.Correccion_espacios_titulo(txtTitulo);
    }

    @FXML
    private void onGuardar (ActionEvent event){
        Guardar_shortcuts_con_util.Guardar_shortcuts_nuevo(event, txtTitulo, txtTexto, lblTituloError, lblTextoError);
    }

    @FXML
    private void onCancelar(ActionEvent event) throws IOException {
        Cambiar_scene_con_util.cambiar_scene(event, "Home");
    }

}
