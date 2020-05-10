package com.politecnicomalaga.Escenario;

import com.politecnicomalaga.Modelo.*;

public class Desierto implements Escenario{
    public Jugador crearJugador() {
        return new Patton();
    }

    public Villano crearVillano() {
        return new Rommel();
    }

    public Obstaculo crearObstaculo() {
        return new Tanques();
    }
}
