package org.example.util.Interaccion_teclado;

import javafx.application.Platform;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import org.example.model.DTO.Shortcut_DTO;

import java.awt.*;
import java.awt.event.KeyEvent;

// Este "Robot" sera para automatizar procesos, como pegado de contenido, entre otros
public class Robot_automatico {

    static Clipboard clipboard;
    static ClipboardContent content;


    static void Intercaccion_clipboard (Shortcut_DTO dto) {
        Platform.runLater(() -> {
            clipboard = Clipboard.getSystemClipboard();
            // Guardamos el contenido del historial de copiado
            content = new ClipboardContent();
            // Copiamos el texto del shortcut
            content.putString(dto.getTexto());

            // Restaurar el contenido anterior si ya habia
            clipboard.setContent(content);

            Robot robot = null;
            try {
                robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            } catch (AWTException e) {
                throw new RuntimeException("Error al usar el pegado de contenido",e);
            }


        });
    }

    static void Pegar_contenido () {
        Platform.runLater(() -> {

        });

    }

}
// Guardamos el contenido del historial de copiado
