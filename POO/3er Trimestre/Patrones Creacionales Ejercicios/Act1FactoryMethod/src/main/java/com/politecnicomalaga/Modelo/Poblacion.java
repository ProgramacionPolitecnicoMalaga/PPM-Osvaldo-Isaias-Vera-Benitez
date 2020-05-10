package com.politecnicomalaga.Modelo;

public class Poblacion {
    private int anho, habitantes;

    public Poblacion(int anho, int habitantes) {
        this.anho = anho;
        this.habitantes = habitantes;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }
}
