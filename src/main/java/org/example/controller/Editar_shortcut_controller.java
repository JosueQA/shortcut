package org.example.controller;

import javafx.event.Event;
import javafx.fxml.*;
import javafx.scene.control.*;
import org.example.controller.util.Cambiar_scene_con_util;
import org.example.controller.util.Correcciones_titulo_con_util;
import org.example.controller.util.Guardar_shortcuts_con_util;
import org.example.model.DAO.DAOImpl.Shortcut_DAO_impl;
import org.example.model.DAO.Shortcut_DAO;
import org.example.model.DTO.Shortcut_DTO;

import java.io.IOException;

public class Editar_shortcut_controller {

    @FXML
    public TextField txtTitulo;

    @FXML
    public TextArea txtTexto;

    @FXML
    public Label lblTituloError;

    @FXML
    public Label lblTextoError;

    // Inicializamos el Shorcut_DTO, que es el que recibira este valor, ya que trabajará sobre el
    public Shortcut_DTO dto;
    // Declaramos el constructor
    public Editar_shortcut_controller(Shortcut_DTO dto) {
    this.dto = dto;
}
    // Creamos el getter del dto
    public Shortcut_DTO getDto() {
        return dto;
    }

    @FXML
    public void onTituloIngresado(){
        // Definimos que cada titulo no tenga espacios, sino guiones bajos
        Correcciones_titulo_con_util.Correccion_espacios_titulo(txtTitulo);
    }

    @FXML
    public void initialize() {
        // Definimos el valor inicial del titulo
        txtTitulo.setText(dto.getTitulo());
        txtTexto.setText(dto.getTexto());
    }

    @FXML
    public void onGuardar(Event event) {
        Guardar_shortcuts_con_util.Guardar_shortcuts_editados(event, txtTitulo, txtTexto, lblTituloError, lblTextoError, getDto());
    }

    @FXML
    public void onEliminar (Event event) throws IOException {
        // Eliminamos el shortcut
        Shortcut_DAO dao = new Shortcut_DAO_impl();
        dao.eliminar_dao(getDto().getCodigo());

        // Volvemos a la pestaña anterior
        onAtras(event);
    }

    @FXML
    public void onAtras (Event event) throws IOException {
        Cambiar_scene_con_util.cambiar_scene(event, "Home");
    }

}
