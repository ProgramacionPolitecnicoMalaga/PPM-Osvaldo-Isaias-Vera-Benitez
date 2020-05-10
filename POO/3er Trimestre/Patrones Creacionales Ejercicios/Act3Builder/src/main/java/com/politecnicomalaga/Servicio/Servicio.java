package com.politecnicomalaga.Servicio;

import com.politecnicomalaga.Builder.TipoHabitacion;

public class Servicio {
    private TipoHabitacion tipoHabitacion;
    private boolean desayuno = false;
    private boolean almuerzo = false;
    private boolean cena = false;
    private boolean parqueAtracciones = false;
    private boolean cursoKiteSurf = false;
    private boolean actividadInfantil = false;
    private boolean cinePlaya = false;
    private int camaAdicional;

    public void setDesayuno() {
        desayuno = true;
    }

    public void setAlmuerzo() {
        almuerzo = true;
    }

    public void setCena() {
        cena = true;
    }

    public void setParqueAtracciones() {
        parqueAtracciones = true;
    }

    public void setCursoKiteSurf() {
        cursoKiteSurf = true;
    }

    public void setActividadInfantil() {
        actividadInfantil = true;
    }

    public void setCinePlaya() {
        cinePlaya = true;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public void setCamaAdicional(int camaAdicional) {
        this.camaAdicional = camaAdicional;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "desayuno=" + desayuno +
                ", almuerzo=" + almuerzo +
                ", cena=" + cena +
                ", parqueAtracciones=" + parqueAtracciones +
                ", cursoKiteSurf=" + cursoKiteSurf +
                ", actividadInfantil=" + actividadInfantil +
                ", cinePlaya=" + cinePlaya +
                ", tipoHabitacion=" + tipoHabitacion +
                ", camaAdicional=" + camaAdicional +
                '}';
    }
}
