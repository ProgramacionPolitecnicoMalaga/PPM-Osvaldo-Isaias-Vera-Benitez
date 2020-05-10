package com.politecnicomalaga;

import com.politecnicomalaga.Controlador.SelectorJuego;

public class App {
    public static void main(String[] args) {
        SelectorJuego selector = new SelectorJuego();
        System.out.println(selector.getJugador());
        System.out.println(selector.getVillano());
        System.out.println(selector.getObstaculo());
    }
}
