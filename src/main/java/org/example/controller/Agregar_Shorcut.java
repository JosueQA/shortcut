package org.example.controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.model.DAO.DAOImpl.*;
import org.example.model.DAO.Shortcut_DAO;
import org.example.model.DTO.Shortcut_DTO;

public class Agregar_Shorcut {

    @FXML
    private TextField txtTitulo;

    @FXML
    private Label lblTituloCampoObligatorio;

    @FXML
    private TextArea txtTexto;

    @FXML
    private Label lblTextoCampoObligatorio;

    @FXML
    private Button btnGuardar;

    @FXML
    private void onGuardar (){
        String titulo = txtTitulo.getText();
        String texto = txtTexto.getText();

        // Si el TIULO esta vacio, muestra mensaje, y si no lo quita (si ya esta puesto)
        if (titulo.isEmpty()){
            lblTituloCampoObligatorio.setVisible(true);
            return;
        } else {
            lblTituloCampoObligatorio.setVisible(false);
        }
        // Si el TEXTO esta vacio, muestra mensaje, y si no lo quita (si ya esta puesto)
        if (texto.isEmpty()){
            lblTextoCampoObligatorio.setVisible(true);
            return;
        } else {
            lblTextoCampoObligatorio.setVisible(false);
        }

        Shortcut_DAO dao = new Shortcut_DAO_impl();
        Shortcut_DTO dto = new Shortcut_DTO(titulo, texto);

        dao.crear_dao(dto);

    }

}
