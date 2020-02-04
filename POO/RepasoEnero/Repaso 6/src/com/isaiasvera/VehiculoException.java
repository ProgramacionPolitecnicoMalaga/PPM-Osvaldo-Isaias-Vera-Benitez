package com.isaiasvera;

public class VehiculoException extends Exception {
    public VehiculoException () {
        super("El vehículo ya existe");
    }
}
