package com.politecnicomalaga.Controlador;

import com.politecnicomalaga.Escenario.Escenario;
import com.politecnicomalaga.Escenario.EscenarioFactory;
import com.politecnicomalaga.Escenario.TipoEscenario;
import com.politecnicomalaga.Modelo.Jugador;
import com.politecnicomalaga.Modelo.Obstaculo;
import com.politecnicomalaga.Modelo.Villano;

import java.util.Scanner;

public class SelectorJuego {
    private final Scanner lector;
    private Jugador jugador;
    private Villano villano;
    private Obstaculo obstaculo;

    public SelectorJuego(){
        lector = new Scanner(System.in).useDelimiter("\n");
        cargar();
    }

    public int mostrarSelectorEscenarios(){
        System.out.println("Selecciona un escenario: " + "\n"
                +"1. Selva."+
                "2. Desierto."+
                "3. Espacio.");
        return lector.nextInt();
    }

    public void cargar(){
        EscenarioFactory factory = new EscenarioFactory();
        Escenario escenario;
        TipoEscenario tipo;
        switch (mostrarSelectorEscenarios()){
            case 1:
                tipo = TipoEscenario.SELVA;
                break;
            case 2:
                tipo = TipoEscenario.DESIERTO;
                break;
            case 3:
                tipo = TipoEscenario.ESPACIO;
                break;
            default:
                tipo = TipoEscenario.SELVA;
        }
        escenario = factory.getEscenario(tipo);
        jugador = escenario.crearJugador();
        villano = escenario.crearVillano();
        obstaculo = escenario.crearObstaculo();
    }

    public String getJugador(){
        return jugador.getNombreJugador();
    }

    public String getVillano(){
        return villano.getNombreVillano();
    }

    public String getObstaculo(){
        return obstaculo.getNombreObstaculo();
    }
}
