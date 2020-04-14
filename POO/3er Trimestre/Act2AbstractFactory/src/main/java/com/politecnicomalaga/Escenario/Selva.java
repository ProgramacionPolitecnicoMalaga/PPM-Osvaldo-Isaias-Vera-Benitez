package com.politecnicomalaga.Escenario;

import com.politecnicomalaga.Modelo.*;

public class Selva implements Escenario{
    public Jugador crearJugador() {
        return new Indiana();
    }

    public Villano crearVillano() {
        return new Molaram();
    }

    public Obstaculo crearObstaculo() {
        return new CarceleroTurco();
    }
}
