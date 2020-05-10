package com.politecnicomalaga;

public class AvanceTarea {
    private Tareas tareas;

    public AvanceTarea(){
        tareas = Tareas.getInstancia();
    }

    public void avanzar(int numeroDeTareas){
        tareas.cambiarUltimaTareaRealizada(numeroDeTareas);
    }

    public String mostrarUltimaTareaRealizada(){
        return tareas.getUltimaTarea();
    }
}
