package com.politecnicomalaga;

import java.util.ArrayList;
import java.util.List;

public class Tareas {
    private static Tareas instancia = new Tareas();
    private int ultimaTareaRealizada;
    private List<String> tareas;

    public Tareas(){
        tareas = new ArrayList<>();
        ultimaTareaRealizada = -1;
    }

    public static Tareas getInstancia(){
        return instancia;
    }

    public void addTarea(String nuevaTarea){
        tareas.add(nuevaTarea);
        cambiarUltimaTareaRealizada(1);
    }

    public String getUltimaTarea(){
        return tareas.get(ultimaTareaRealizada);
    }

    public void cambiarUltimaTareaRealizada(int numeroDeTareas){
        ultimaTareaRealizada += numeroDeTareas;
    }

    public int getListSize(){
        return tareas.size();
    }

    public int getPosicionUltimaTareaRealizada() {
        return ultimaTareaRealizada;
    }
}
