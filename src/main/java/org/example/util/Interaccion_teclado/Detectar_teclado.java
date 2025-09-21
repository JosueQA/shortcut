package org.example.util.Interaccion_teclado;


import javafx.application.Platform;
import javafx.scene.input.ClipboardContent;
import org.example.controller.util.Mostrar_ventana;
import org.example.model.DAO.DAOImpl.Shortcut_DAO_impl;
import org.example.model.DAO.Shortcut_DAO;
import org.example.model.DTO.Shortcut_DTO;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
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
            //Mostrar_ventana.mostrar_ventana("Popup_shortcuts", "Elige tu shortcut");

            // Guardamos el contenido del historial de copiado

            try {

                // Guardar lo que hay actualmente en el portapapeles
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable contenidoAnterior = clipboard.getContents(null);

                // Guardamos el contenido del historial de copiado
                StringSelection seleccion = new StringSelection(dto.getTexto());
                clipboard.setContents(seleccion, null);

                Robot robot = new Robot();
                synchronized (contenidoAnterior) {
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_V);
                    robot.keyRelease(KeyEvent.VK_V);
                    robot.keyRelease(KeyEvent.VK_CONTROL);
                }

                if (contenidoAnterior != null){
                    // Debemos darle un momento de espera para que restaure el elemento copiado, ya que puede que se ejecute ANTES del ctrl + v, y eso puede generar el pegado del texto anterior o hasta mantener el portapapeles en un estado no valido y no pegar nada
                    // Establecemos el valor anterior en el portapapeles
                    clipboard.setContents(contenidoAnterior, null);
                }
            } catch (AWTException ex) {
                throw new RuntimeException("Error al usar el pegado de contenido", ex);
            }

        }
    }

}
