package org.example.model.DTO;

import javafx.scene.Node;

public class Shortcut_DTO {

    String codigo, titulo, texto;

    public Shortcut_DTO(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    // El 3er parametro lo usaremos cuando queramos llamarlo
    public Shortcut_DTO(String titulo, String texto, String codigo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.texto = texto;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
