package com.politecnicomalaga.Modelo;

import java.sql.Timestamp;

public class Mensaje {
    private int id_destinatario;
    private int id_remitente;
    private String titulo, texto;
    private Timestamp fecha_hora;

    public Mensaje(int id_destinatario, int id_remitente, String titulo, String texto, Timestamp fecha_hora) {
        this.id_destinatario = id_destinatario;
        this.id_remitente = id_remitente;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha_hora = fecha_hora;
    }

    public int getId_destinatario() {
        return id_destinatario;
    }

    public void setId_destinatario(int id_destinatario) {
        this.id_destinatario = id_destinatario;
    }

    public int getId_remitente() {
        return id_remitente;
    }

    public void setId_remitente(int id_remitente) {
        this.id_remitente = id_remitente;
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

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "id_destinatario=" + id_destinatario +
                ", id_remitente=" + id_remitente +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", fecha_hora=" + fecha_hora +
                '}';
    }
}
