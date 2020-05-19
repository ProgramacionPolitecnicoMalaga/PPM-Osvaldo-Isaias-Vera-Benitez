package com.politecnicomalaga.composite;

public class Precio {
    public static double precio(String nombre){
        switch (nombre.toLowerCase()){
            case "ilink":
                return Servicio.ILINK;
            case "rack":
                return Servicio.RACK;
            case "cloudsolutions":
                return Servicio.CLOUD;
            case "servidor":
                return Servicio.SERVIDOR;
            case "vps":
                return Servicio.VPS;
            default:
                throw new IllegalArgumentException();
        }
    }
}
