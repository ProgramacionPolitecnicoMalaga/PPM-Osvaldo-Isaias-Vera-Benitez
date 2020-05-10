package com.politecnicomalaga.Escenario;

import com.politecnicomalaga.Modelo.Jugador;
import com.politecnicomalaga.Modelo.Obstaculo;
import com.politecnicomalaga.Modelo.Villano;

public interface Escenario {
    public Jugador crearJugador();
    public Villano crearVillano();
    public Obstaculo crearObstaculo();
}
