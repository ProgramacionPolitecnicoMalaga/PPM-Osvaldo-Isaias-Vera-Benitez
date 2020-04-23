package com.politecnicomalaga;

import java.util.ArrayList;
import java.util.List;

public class LogActividad {
    private static LogActividad instancia = new LogActividad();
    private List<String> actividades;

    public LogActividad(){
        actividades = new ArrayList<>();
    }

    public static LogActividad getInstancia(){
        return instancia;
    }

    public void addActividad(String actividad){
        actividades.add(actividad);
    }

    @Override
    public String toString() {
        return actividades.toString();
    }
}
