package org.example.util;

import java.sql.*;

public class Conexion {

    public Connection obtenerConexion() {
        String url = "jdbc:mysql://localhost:3306/shortcuts";
        String user = "root";
        String pass = "musicme";

        try {
            // Conectamos la base de datos (no podemos ponerlo como parametro de este try, porque se cerrara al finalizar este bloque, y enviara una util cerrada desde donde se llame)
            Connection conn = DriverManager.getConnection(url, user, pass);
            // Debemos recibir la siguiente variable en el archivo donde queramos usarlo
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar util", e);
        }
    }


}
