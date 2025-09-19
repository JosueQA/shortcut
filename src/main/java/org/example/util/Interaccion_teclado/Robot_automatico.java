package org.example.util.Interaccion_teclado;

import org.example.model.DTO.Shortcut_DTO;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

// Este "Robot" sera para automatizar procesos, como pegado de contenido, entre otros
public class Robot_automatico {

    static Clipboard clipboard;
    static Transferable contenidoAnterior;

    // Guardamos lo que había en el portapapeles
    static void Guardar_portapapeles(){
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        contenidoAnterior = clipboard.getContents(null);
    }

    // Restaurar el contenido anterior si ya habia
    static void Limpiar_portapapeles(){
        if (contenidoAnterior != null) {
            clipboard.setContents(contenidoAnterior, null);
        }
    }

    static void Copiar_contenido (String shorcut_texto) {
        // Crear un objeto que contiene el texto a copiar
        StringSelection seleccion = new StringSelection(shorcut_texto);

        // Acceder al portapapeles y agregar el texto a copiar
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion, null);
    }

    static void Pegar_contenido () throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

}
