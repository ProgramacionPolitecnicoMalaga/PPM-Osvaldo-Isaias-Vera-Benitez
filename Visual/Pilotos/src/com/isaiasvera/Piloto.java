package com.isaiasvera;

public class Piloto {
    private String nombre;
    private String escuderia;
    private int posicionActual;
    private boolean descalificado;

    public Piloto(String nombre, String escuderia, int posicionActual) {
        this.nombre = nombre;
        this.escuderia = escuderia;
        this.posicionActual = posicionActual;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public boolean isDescalificado() {
        return descalificado;
    }

    public void setDescalificado(boolean descalificado) {
        this.descalificado = descalificado;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "nombre='" + nombre + '\'' +
                ", escuderia='" + escuderia + '\'' +
                ", posicionSalida=" + posicionActual +
                ", descalificado=" + descalificado +
                '}';
    }
}
