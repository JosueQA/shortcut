package org.example.controller.util;

import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.model.DAO.DAOImpl.Shortcut_DAO_impl;
import org.example.model.DAO.Shortcut_DAO;
import org.example.model.DTO.Shortcut_DTO;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

public class Guardar_shortcuts_con_util {

    // Creamos el metodo para guardar shorcuts nuevos
    public static void Guardar_shortcuts_nuevo(Event event, TextField txtTitulo, TextArea txtTexto, Label lblTituloError, Label lblTextoError) {
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

        // Creamos el nuevo dto
        Shortcut_DAO dao = new Shortcut_DAO_impl();
        Shortcut_DTO dto = new Shortcut_DTO(titulo, texto);

        try{
            // Guardamos el nuevo shortcut
            dao.crear_dao(dto);

            // Guardamos y regresamos al home
            Cambiar_scene_con_util.cambiar_scene(event, "Home");

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

    // Creamos el metodo para guardar shorcuts editados
    public static void Guardar_shortcuts_editados(Event event, TextField txtTitulo, TextArea txtTexto, Label lblTituloError, Label lblTextoError, Shortcut_DTO dtoCodigo) {
        String titulo = txtTitulo.getText();
        String texto = txtTexto.getText();

    // VERIFICAMOS SI EL CAMPO TITULO Y TEXTO ESTAN VACIOS -------------------------------------------

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

    // CREAMOS SHORTCUT DTO, CON EL CODIGO DEL SHORCUT EXISTENTE -------------------------------------
        // Esto para poder editarlo
        Shortcut_DAO dao = new Shortcut_DAO_impl();
        Shortcut_DTO dto = new Shortcut_DTO(titulo, texto, dtoCodigo.getCodigo());

        try{
            // Guardamos el nuevo shortcut
            dao.editar_dao(dto);

            // Guardamos y regresamos al home
            Cambiar_scene_con_util.cambiar_scene(event, "Home");

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
}
