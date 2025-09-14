package org.example.model.DAO;

import org.example.model.DTO.Shortcut_DTO;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public interface Shortcut_DAO {

    Shortcut_DTO leer_dao(String titulo);
    ArrayList<Shortcut_DTO> leer_todos_dao();
    void crear_dao(Shortcut_DTO dto) throws SQLIntegrityConstraintViolationException;
    void editar_dao(Shortcut_DTO dto) throws SQLIntegrityConstraintViolationException;
    void eliminar_dao(String titulo);

}
