package org.example.controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.model.DAO.DAOImpl.*;
import org.example.model.DAO.Shortcut_DAO;
import org.example.model.DTO.Shortcut_DTO;

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
    private void onGuardar (){
        String titulo = txtTitulo.getText();
        String texto = txtTexto.getText();

        // Si el TIULO esta vacio, pone visible el label de aviso, y si no, lo quita (si ya esta visible)
        if (titulo.isEmpty()){
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
            dao.crear_dao(dto);
        } catch (SQLIntegrityConstraintViolationException e){

        }

    }

}
