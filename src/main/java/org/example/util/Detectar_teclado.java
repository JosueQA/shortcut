package org.example.util;

import org.example.controller.util.Abrir_ventana_con_util;
import org.example.model.DAO.DAOImpl.Shortcut_DAO_impl;
import org.example.model.DAO.Shortcut_DAO;
import org.example.model.DTO.Shortcut_DTO;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

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

            /*
                EN ADELANTE INTERACTUAMOS CON EL COPIADO Y PEGADO
                Aqui hay 2 puntos principales a tomar en cuenta de su existencia:
                    1. COPIADO SIMPLE. Es un unico valor copiado (el ultimo), tiene poca latencia, y existe desde siempre.
                    2. HISTORIAL DE PORTAPAPELES DE WINDOWS. Es el historial que se muestra con WIN + V, tiene mayor latencia de respuesta, NO HAY MODO DE CONTROLARLO, y se agrego desde WINDOWS 10.
                */
/*
            try {
                // Instanciamos el CLIPBOARD sobre el COPIADO SIMPLE
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

                // Guardamos el contenido del COPIADO SIMPLE en un tipo de dato TRANSFERABLE que CLIPBOARD acepta para cambiar su contenido, con el fin de restaurarlo despues
                Transferable contenidoAnterior = clipboard.getContents(null);

                // Aqui obtenemos el valor del shortcut y guardamos en un tipo que TRANSFERABLE acepta
                StringSelection seleccion = new StringSelection(dto.getTexto());

                // Aqui decimos al COPIADO SIMPLE que agregue un nuevo valor
 EN ESTE MOMENTO WINDOWS DETECTA UN NUEVO VALOR EN EL COPIADO SIMPLE Y PROGRAMA EL GUARDADO EN EL HISTORIAL, proceso que tiene algo de latencia

                clipboard.setContents(seleccion, null);

                // Presionamos CTRL + V para el pegado del COPIADO SIMPLE
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);

                // Aqui definimos que si habia contenido antes, actuar
                if (contenidoAnterior != null){
                    // Debemos darle un momento de espera para que restaure el elemento copiado, ya que puede que se ejecute el CTRL + V DESPUES de restaurar el COPIADO SIMPLE con el valor antiguo (ver siguiente linea) por la latencia del S.O. al realizar dicha accion, y asi pegar el contenido antiguo y no el shortcut
                    Thread.sleep(150);
                    // Establecemos el valor anterior del COPIADO SIMPLE como nuevo valor, para que parezca que no aqui paso nada
 TRUQUITO. Aqui vive el truco por accidente que cuando el HISTORIAL DEL PORTAPAPELES DE WINDOWS detecta un cambio en el COPIADO SIMPLE demora en agregarlo al historial, y cuando lo detecta, y este valor desaparece (por que lo restauramos a continuacion con poco tiempo de espera) al instante, el HISTORIAL DE PORTAPAPELES DE WINDOWS no lo agrega, ya que fue un valor que estuvo por tan poco tiempo que nisiquera decide tomarlo en cuenta. Y asi no aparece en el portapapeles, pero claro no sucede siempre, depende el tiempo de espera y del S.O., asi que se debe considerar como que SI lo guarda en el HISTORIAL DEL PORTAPAPELES DE WINDOWS como penultimo valor

                    clipboard.setContents(contenidoAnterior, null);
                }
            } catch (AWTException ex) {
                throw new RuntimeException("Error al usar el pegado de contenido", ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException("Error al aplicar el tiempo de espera",ex);
            }
*/

            // Mostramos la ventana
            Abrir_ventana_con_util.abrir_popup("Popup_shortcuts", "Elige tu shortcut");

        }
    }

}
