package org.example.util.Interaccion_teclado;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.example.Main;
import org.example.controller.util.Mostrar_ventana;
import org.example.model.DAO.DAOImpl.Shortcut_DAO_impl;
import org.example.model.DAO.Shortcut_DAO;
import org.example.model.DTO.Shortcut_DTO;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Detectar_teclado implements NativeKeyListener {

    static {
        // 🔇 Apagar logs molestos apenas se cargue la clase
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        logger.setUseParentHandlers(false);
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        // Aquí se detecta el CARÁCTER real, y puede fallar cuando el teclado esta otro idioma
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        // Aquí se detecta el BOTON FISICO al presionar ejecutarse 2 veces
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        // Aquí se detecta el BOTON FISICO al soltar la tecla
        if (e.getKeyCode() == NativeKeyEvent.VC_T) {

            // Aqui elegimos el shortcut a pegar
            Shortcut_DAO dao = new Shortcut_DAO_impl();
            Shortcut_DTO dto = dao.leer_dao("prueba");

            // Mostramos la ventana
            Mostrar_ventana.mostrar_ventana("Popup_shortcuts", "Elige tu shortcut");

            // Copiamos el texto del shortcut
            Robot_automatico.Intercaccion_clipboard(dto);

        }
    }

}
