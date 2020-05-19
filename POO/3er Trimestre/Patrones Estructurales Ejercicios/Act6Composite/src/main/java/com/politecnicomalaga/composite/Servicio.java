package com.politecnicomalaga.composite;

public interface Servicio {
    public static final double ILINK = 30.0;
    public static final double RACK = 20.0;
    public static final double SERVIDOR = 25.0;
    public static final double CLOUD = 15.0;
    public static final double VPS = 20.0;

    public double getPrecio();
    public boolean esPaquete();
    public void setPadre(Paquete padre);
    public Paquete getPadre();
}
