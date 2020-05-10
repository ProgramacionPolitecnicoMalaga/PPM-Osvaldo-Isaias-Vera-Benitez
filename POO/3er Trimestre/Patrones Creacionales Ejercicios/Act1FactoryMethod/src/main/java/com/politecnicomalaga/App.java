package com.politecnicomalaga;

import com.politecnicomalaga.Controlador.ControladorPoblacion;

public class App {
    public static void main(String[] args) {
        ControladorPoblacion controlador = new ControladorPoblacion();
        System.out.println(controlador.getDatos());
    }
}
