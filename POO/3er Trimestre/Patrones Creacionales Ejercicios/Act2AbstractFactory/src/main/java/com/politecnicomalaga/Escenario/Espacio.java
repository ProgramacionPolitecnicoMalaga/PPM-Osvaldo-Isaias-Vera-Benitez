package com.politecnicomalaga.Escenario;

import com.politecnicomalaga.Modelo.*;

public class Espacio implements Escenario{
    public Jugador crearJugador() {
        return new USSEnterprise();
    }

    public Villano crearVillano() {
        return new Khan();
    }

    public Obstaculo crearObstaculo() {
        return new NavesKlingon();
    }
}
