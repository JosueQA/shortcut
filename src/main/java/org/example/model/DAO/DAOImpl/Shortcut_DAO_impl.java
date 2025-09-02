package org.example.model.DAO.DAOImpl;

import org.example.model.DAO.Shortcut_DAO;
import org.example.model.DTO.Shortcut_DTO;
import org.example.model.util.Conexion;

import java.sql.*;
import java.util.ArrayList;

public class Shortcut_DAO_impl implements Shortcut_DAO {

    @Override
    public void crear_dao(Shortcut_DTO dto) throws SQLIntegrityConstraintViolationException {

        // "throws SQLIntegrityConstraintViolationException" significa declarar error, es decir avisa que un error de ese tipo (violiacion a la integridad de la bd) puede saltar (ocurriria si el titulo se repite, ya que es UNIQUE), y quien lo llame debe usar un try-catch para capturar la excepción y hacer algo con ella (una opción distinta sería usar un catch adicional a continuación, pero necesitaremos la validacion)

        // Sql para crear nuevo shortcut
        String sql = "Insert into shortcuts (titulo, texto) values (?,?)";

        try (
                Connection conn = new Conexion().obtenerConexion();
                PreparedStatement stmt = conn.prepareStatement(sql) ) {

            // Asignamos el titulo y texto del dto del parametro
            stmt.setString(1, dto.getTitulo());
            stmt.setString(2, dto.getTexto());
            // Ejecutamos comando sql
            stmt.executeUpdate();

            System.out.println("Shortcuts '" + dto.getTitulo() + "' agregado exitosamente");

            // Si ocurre algun error..
        } catch (Exception e) {
            throw new RuntimeException("Error al crear un shortcut '" + dto.getTitulo() + "'", e);
        }
    }

    @Override
    public void editar_dao(Shortcut_DTO dto) {
        String sql = "UPDATE shortcuts SET TEXTO = ? WHERE TITULO = ?";

        try (Connection conn = new Conexion().obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dto.getTexto());
            stmt.setString(2, dto.getTitulo());
            stmt.executeUpdate();
            System.out.println("Shortcuts '" + dto.getTitulo() + "' editado exitosamente");

        } catch (Exception e) {
            throw new RuntimeException("Error al editar el shortcut '" + dto.getTitulo() + "'", e);
        }
    }

    @Override
    public void eliminar_dao(String titulo) {
        String sql = "DELETE from shortcuts WHERE TITULO = ?";

        try (Connection conn = new Conexion().obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, titulo);
            stmt.executeUpdate();

            System.out.println("Shortcuts '" + titulo + "' borrado exitosamente");

        } catch (Exception e) {
            throw new RuntimeException("Error al borrar el shortcut '" + titulo + "'", e);
        }
    }

    @Override
    public void leer_dao(String titulo) {
        String sql = "SELECT * from shortcuts WHERE TITULO = ?";

        String tituloBusqueda = "";
        String texto = "";

        try (Connection conn = new Conexion().obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                tituloBusqueda = rs.getString("titulo");
                texto = rs.getString("texto");
            }

            System.out.println("Titulo: '" + tituloBusqueda + "'");
            System.out.println("Texto: '" + texto + "'");

        } catch (Exception e) {
            throw new RuntimeException("Error al llamar el shortcut '" + titulo + "'", e);
        }
    }
}



