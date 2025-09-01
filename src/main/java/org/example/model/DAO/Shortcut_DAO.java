package org.example.model.DAO;

import org.example.model.DTO.Shortcut_DTO;

import java.util.ArrayList;

public interface Shortcut_DAO {

    void leer_dao(String titulo);
    void crear_dao(Shortcut_DTO dto);
    void editar_dao(Shortcut_DTO dto);
    void eliminar_dao(String titulo);

}
