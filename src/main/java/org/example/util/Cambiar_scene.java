package org.example.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Cambiar_scene {

    public static void cambiar_scene(ActionEvent event, String view) throws IOException {
        // Cargar el nuevo FXML
        Parent nueva_escena = FXMLLoader.load(Cambiar_scene.class.getResource("/view/"+ view +".fxml"));
        // Obtener el stage actual a partir del botón
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Cambiar la escena
        stage.setScene(new Scene(nueva_escena));
        stage.show();
    }
}
