package org.example.controller.util;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// LISTENER. Este listener reemplaza los espacios por "_" en los titulos del shortcut

public class Correcciones_titulo_con_util {

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

}
