package org.example.controller;

import javafx.event.Event;
import javafx.fxml.*;
import javafx.scene.control.*;
import org.example.controller.util.Cambiar_scene;
import org.example.controller.util.Correcciones_titulo;
import org.example.model.DAO.DAOImpl.Shortcut_DAO_impl;
import org.example.model.DAO.Shortcut_DAO;
import org.example.model.DTO.Shortcut_DTO;

import java.io.IOException;

public class Editar_shortcut_controller {

    @FXML
    public TextField txtTitulo;

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
        Correcciones_titulo.Correccion_espacios_titulo(txtTitulo);
    }

    @FXML
    public void initialize() {
        // Definimos el valor inicial del titulo
        txtTitulo.setText(dto.getTitulo());
    }

    @FXML
    public void onGuardar(){}

    @FXML
    public void onAtras (Event event) throws IOException {
        Cambiar_scene.cambiar_scene(event, "Home");
    }

    @FXML
    public void onEliminar (Event event) throws IOException {
        // Eliminamos el shortcut
        Shortcut_DAO dao = new Shortcut_DAO_impl();
        dao.eliminar_dao(getDto().getCodigo());

        // Volvemos a la pestaña anterior
        onAtras(event);
    }

}
