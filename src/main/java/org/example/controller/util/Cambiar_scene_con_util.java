package org.example.controller.util;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import org.example.model.DTO.Shortcut_DTO;

import java.io.IOException;

public class Cambiar_scene_con_util {
    /*
    ¿Como usarlo?
    - El metodo es static, por lo que no sera necesario asignar a una variable, solo LO LLAMAMOS COMO METODO DE ESTA CLASE DONDE QUERAMOS QUE SE EJECUTE.
    - 2 PARAMETROS. El 1er parametro pide el un evento, que escalara hasta obtener la ventana actual. El 2do parametro es el nombre de la nueva escena a la que cambiará
    Ejm;
    "Cambiar_scene_con_util.cambiar_scene(event, "Agregar_Shortcut");"

    */

    public static void cambiar_scene(Event event, String view) throws IOException {
        // Cargar el nuevo FXML
        Parent nueva_escena = FXMLLoader.load(Cambiar_scene_con_util.class.getResource("/view/"+ view +".fxml"));
        // Obtener el stage actual a partir del botón
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Cambiar la escena
        stage.setScene(new Scene(nueva_escena));
        stage.show();
    }

    // Cambiar de escena con un parametro, SIEMPRE Y CUUANDO el controlador definido en el fxml, tenga un constructor que reciba Shorcut_dto
    public static void cambiar_scene(Event event, String view,Shortcut_DTO dto) throws IOException {

        // Cargamos la vista, y lo guardamos en nun loader
        FXMLLoader loader = new FXMLLoader(Cambiar_scene_con_util.class.getResource("/view/" + view + ".fxml"));

        // Usamos la "fabrica de controladores" para manejar como se instanciará al controlador
        loader.setControllerFactory(type -> { // representa la clase del controlador del fxml
            try {
                // Busca el constructor público que acepta Shortcut_DTO y lo invoca pasando dto para crear el controlador.
                return type.getConstructor(Shortcut_DTO.class).newInstance(dto);
            } catch (Exception e) {
                throw new RuntimeException("Error al instanciar un FXML con un parametro en el constructor",e);
            }
        });

        Parent nueva_escena = loader.load();
        // Obtener el stage actual a partir del evento
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Cambiar la escena
        stage.setScene(new Scene(nueva_escena));
        stage.show();
    }

}
