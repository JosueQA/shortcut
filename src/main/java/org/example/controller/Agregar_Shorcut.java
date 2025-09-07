package org.example.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.model.DAO.DAOImpl.*;
import org.example.model.DAO.Shortcut_DAO;
import org.example.model.DTO.Shortcut_DTO;
import org.example.controller.util.Cambiar_scene;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

public class Agregar_Shorcut {

    @FXML
    private TextField txtTitulo;

    @FXML
    private Label lblTituloError;

    @FXML
    private TextArea txtTexto;

    @FXML
    private Label lblTextoError;

    @FXML
    private void onGuardar (ActionEvent event){
        String titulo = txtTitulo.getText();
        String texto = txtTexto.getText();

        // Si el TIULO esta vacio, pone visible el label de aviso, y si no, lo quita (si ya esta visible)
        if (titulo.isEmpty()){
            lblTituloError.setText("Campo obligatorio");
            lblTituloError.setVisible(true);
            return;
        } else {
            lblTituloError.setVisible(false);
        }
        // Si el TEXTO esta vacio, pone visible el label de aviso, y si no, lo quita (si ya esta visible)
        if (texto.isEmpty()){
            lblTextoError.setVisible(true);
            return;
        } else {
            lblTextoError.setVisible(false);
        }

        Shortcut_DAO dao = new Shortcut_DAO_impl();
        Shortcut_DTO dto = new Shortcut_DTO(titulo, texto);

        try{
            // Guardamos el nuevo shortcut
            dao.crear_dao(dto);

            // Guardamos y reregresamos al home
            Cambiar_scene.cambiar_scene(event, "Home");

        } catch (SQLIntegrityConstraintViolationException e){
            lblTituloError.setText("Este titulo ya existe, intenta con otro");
            lblTituloError.setVisible(true);
        } catch (IOException e) {
            // Mostramos un popup con un alert sobre el tipo de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en input o ouput");
            alert.setHeaderText("Ocurrio un error al enviar o recibir informacion relacionado al titulo");
            alert.showAndWait();
        }
    }

    @FXML
    private void onCancelar(ActionEvent event) throws IOException {
        Cambiar_scene.cambiar_scene(event, "Home");
    }

}
