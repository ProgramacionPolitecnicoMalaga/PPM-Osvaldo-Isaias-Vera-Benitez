package com.politecnicomalaga;

public class App {
    public static void main(String[] args) {
        ControladorTarea controlador = new ControladorTarea();

        controlador.insertarTarea("uno");
        controlador.insertarTarea("dos");
        controlador.insertarTarea("tres");
        controlador.insertarTarea("cuatro");
        controlador.insertarTarea("cinco");
        controlador.insertarTarea("seis");
        controlador.insertarTarea("siete");
        controlador.insertarTarea("ocho");
        controlador.insertarTarea("nueve");
        controlador.insertarTarea("diez");

        controlador.avanzar(1);
        System.out.println(controlador.ultimaTarea());

        controlador.retroceder(5);
        System.out.println(controlador.ultimaTarea());

        controlador.avanzar(4);
        System.out.println(controlador.ultimaTarea());

        controlador.retroceder(10);
        System.out.println(controlador.ultimaTarea());

        System.out.println(controlador.getActividad());
    }
}
