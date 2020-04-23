package com.politecnicomalaga;

public class ControladorTarea {
    private Tareas tareas;
    private LogActividad actividad;
    private AvanceTarea avanceTarea;
    private RetrocesoTarea retrocesoTarea;

    public ControladorTarea(){
        tareas = Tareas.getInstancia();
        actividad = LogActividad.getInstancia();
        avanceTarea = new AvanceTarea();
        retrocesoTarea = new RetrocesoTarea();
    }

    public void insertarTarea(String tarea){
        tareas.addTarea(tarea);
    }

    public void avanzar(int avance){
        String temp = "Se avanzo: " + avance;
        if (dentroDeRango(avance)){
            avanceTarea.avanzar(avance);
            temp += " | Ultima tarea: " + ultimaTarea();
            actividad.addActividad(temp);
        }else{
            temp += " | Fuera de rango";
            temp += " | Ultima tarea: " + ultimaTarea();
            actividad.addActividad(temp);
        }
    }

    public void retroceder(int retroceso){
        String temp = "Se retrocedio: " + retroceso;
        if (dentroDeRango(-retroceso)){
            retrocesoTarea.retroceder(-retroceso);
            temp += " | Ultima tarea: " + ultimaTarea();
            actividad.addActividad(temp);
        } else {
            temp += " | Fuera de rango";
            temp += " | Ultima tarea: " + ultimaTarea();
            actividad.addActividad(temp);
        }
    }

    public String ultimaTarea(){
        return tareas.getUltimaTarea();
    }

    public LogActividad getActividad(){
        return actividad;
    }

    public boolean dentroDeRango(int numero){
        int listSize = Tareas.getInstancia().getListSize();
        int ultimaTarea = Tareas.getInstancia().getPosicionUltimaTareaRealizada();
        boolean dentro = false;
        if (numero+ultimaTarea > 0 && numero + ultimaTarea < listSize)
            dentro = true;
        return dentro;
    }
}
