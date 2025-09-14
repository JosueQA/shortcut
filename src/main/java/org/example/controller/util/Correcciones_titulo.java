package org.example.controller.util;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// LISTENER. Este listener reemplaza los espacios por "_" en los titulos del shortcut

public class Correcciones_titulo {
        // Debe pasarse un TextField si o si, porque se planea que sea un texto pequeño
    public static void Correccion_espacios_titulo(TextField txtTitulo){
        // Al parametro pasado le agregamos un listener que se llamará en cada cambio a su valor, sobre este solo se suelen usar 2 parametros: "oldText" y "newText", que representan asi mismos sobre el valor del componente
        txtTitulo.textProperty().addListener((obs, oldText, newText) -> {
            // Si el componente esta vacio, recien actuara
            if (!newText.isEmpty()) {
                // Aqui solo usamos el metodo replace de un string para cambiar los valores
                String newTextCambiado = newText.replace(" ", "_");
                // Asignamos como nuevo valor el resultado
                txtTitulo.setText(newTextCambiado);
            }
        });
    }

    public static boolean Validez_titulo(TextField txtTitulo, Label lblTituloError){

        String titulo = txtTitulo.getText();

        // Si el TIULO esta vacio, pone visible el label de aviso, y si no, lo quita (si ya esta visible)
        if (titulo.isEmpty()){
            lblTituloError.setText("Campo obligatorio");
            lblTituloError.setVisible(true);
            return false;
        } else {
            lblTituloError.setVisible(false);
            return true;
        }

    }

}
