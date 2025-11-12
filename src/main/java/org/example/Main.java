package org.example;

import javafx.application.Application;
import javafx.stage.*;
import org.example.controller.util.Abrir_ventana_con_util;
import org.example.util.Detectar_teclado;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // El parametro stage es propio del metodo, y "launch()" de javafx lo envia
        Abrir_ventana_con_util.mostrar_ventana(stage, "home", "Menu principal");
    }

    public static void main(String[] args) {
        try {
            // Registrar el hook global para luego agregar la deteccion por el teclado
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("No se pudo registrar el hook: " + ex.getMessage());
            System.exit(1);
        }

        // Agregar nuestro listener al teclado
        GlobalScreen.addNativeKeyListener(new Detectar_teclado());

        // Javafx arranca su motor grafico, y podemos ver el main
        launch();
    }
}