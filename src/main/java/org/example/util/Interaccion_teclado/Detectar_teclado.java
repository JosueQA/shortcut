package org.example.util.Interaccion_teclado;


import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
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
        if (e.getKeyCode() == NativeKeyEvent.VC_SLASH) {
            System.out.println("¡Se presionó la tecla / !");

            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);

            } catch (AWTException ex) {
                throw new RuntimeException(ex);
            }

        }
    }

}
