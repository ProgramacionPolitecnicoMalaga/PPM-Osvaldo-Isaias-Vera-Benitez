package com.politecnicomalaga;

public class RetrocesoTarea {
    private Tareas tareas;

    public RetrocesoTarea(){
        tareas = Tareas.getInstancia();
    }

    public void retroceder(int numeroDeTareas){
        tareas.cambiarUltimaTareaRealizada(numeroDeTareas);
    }

    public String mostrarUltimaTareaRealizada(){
        return tareas.getUltimaTarea();
    }
}
