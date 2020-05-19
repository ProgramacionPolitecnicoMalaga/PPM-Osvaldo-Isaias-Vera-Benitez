package com.politecnicomalaga.composite;

import java.util.ArrayList;
import java.util.List;

public class Paquete implements Servicio{
    private String nombre;
    private double precio;
    private List<Servicio> hijos;
    private Paquete padre;

    public Paquete(String nombre){
        this.nombre = nombre;
        hijos = new ArrayList<>();
        asignarPrecio();
    }

    @Override
    public double getPrecio() {
        double total = precio;
        for (Servicio s : hijos){
            total += s.getPrecio();
        }
        return total;
    }

    @Override
    public boolean esPaquete() {
        return true;
    }

    @Override
    public void setPadre(Paquete padre) {
        this.padre = padre;
    }

    @Override
    public Paquete getPadre() {
        return padre;
    }

    public void addHijo(Servicio hijo){
        hijo.setPadre(this);
        hijos.add(hijo);
    }

    public String getNombre(){
        return nombre;
    }

    public List<Servicio> getHijos(){
        return hijos;
    }

    public void asignarPrecio(){
        try {
            precio = Precio.precio(nombre);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    @Override
    public String toString() {
        String resultado = "**********************************\n";
        resultado += "| Paquete: " + nombre + "\n";
        if (!hijos.isEmpty()){
            resultado += "----------------------------------\n";
        }
        for (Servicio s : hijos){
            resultado += s.toString() + "\n";
        }
        return resultado;
    }
}
