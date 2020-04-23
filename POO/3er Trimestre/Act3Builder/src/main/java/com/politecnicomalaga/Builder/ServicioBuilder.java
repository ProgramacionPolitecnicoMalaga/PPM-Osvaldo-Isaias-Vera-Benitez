package com.politecnicomalaga.Builder;

import com.politecnicomalaga.Servicio.Servicio;

public class ServicioBuilder {
    private Servicio servicio;

    public ServicioBuilder(){
        servicio = new Servicio();
    }

    public ServicioBuilder setTipoHabitacion(TipoHabitacion tipo){
        servicio.setTipoHabitacion(tipo);
        return this;
    }

    public ServicioBuilder addDesayuno(){
        servicio.setDesayuno();
        return this;
    }

    public ServicioBuilder addAlmuerzo(){
        servicio.setAlmuerzo();
        return this;
    }

    public ServicioBuilder addCena(){
        servicio.setCena();
        return this;
    }

    public ServicioBuilder addParqueAtracciones(){
        servicio.setParqueAtracciones();
        return this;
    }

    public ServicioBuilder addCursoKiteSurf(){
        servicio.setCursoKiteSurf();
        return this;
    }

    public ServicioBuilder addActividadInfantil(){
        servicio.setActividadInfantil();
        return this;
    }

    public ServicioBuilder addCinePlaya(){
        servicio.setCinePlaya();
        return this;
    }

    public ServicioBuilder addCamaAdicional(int camas){
        servicio.setCamaAdicional(camas);
        return this;
    }

    public Servicio build(){
        return servicio;
    }

}
