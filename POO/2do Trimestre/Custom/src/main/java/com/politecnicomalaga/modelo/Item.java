package com.politecnicomalaga.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Item {
    private int id;
    private String autor;
    private LocalDate fecha;
    private String texto;
    private String tema;

    public Item(int id, String autor, LocalDate fecha, String texto, String tema) {
        this.id = id;
        this.autor = autor;
        this.fecha = fecha;
        this.texto = texto;
        this.tema = tema;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

}
