package com.politecnicomalaga.Builder;

import com.politecnicomalaga.Servicio.Servicio;

public class ServicioDirector {
    private ServicioBuilder builder;

    public ServicioDirector(ServicioBuilder builder){
        this.builder = builder;
    }

    public Servicio packBasico(){
        return builder.setTipoHabitacion(TipoHabitacion.SIMPLE).addDesayuno().build();
    }

    public Servicio packRomance(){
        return builder.setTipoHabitacion(TipoHabitacion.DOBLE).addCena().build();
    }

    public Servicio packFamiliar(){
        return builder.setTipoHabitacion(TipoHabitacion.DOBLE)
                .addCamaAdicional(1).addDesayuno().addAlmuerzo().addCena()
                .addParqueAtracciones().addActividadInfantil().addCinePlaya().build();
    }

    public Servicio packPadresRelajados(){
        return builder.setTipoHabitacion(TipoHabitacion.DOBLE)
                .addCamaAdicional(1).addDesayuno().addAlmuerzo().addCena()
                .addActividadInfantil().addCursoKiteSurf().addCinePlaya().build();
    }

    public Servicio packDeluxe(){
        return builder.setTipoHabitacion(TipoHabitacion.SUITE)
                .addDesayuno().addAlmuerzo().addCena().addCursoKiteSurf()
                .addCinePlaya().build();
    }

    public Servicio packDeluxeFamiliar(){
        return builder.setTipoHabitacion(TipoHabitacion.SUITE)
                .addCamaAdicional(1).addDesayuno().addAlmuerzo().addCena()
                .addParqueAtracciones().addCursoKiteSurf()
                .addActividadInfantil().addCinePlaya().build();
    }
}
