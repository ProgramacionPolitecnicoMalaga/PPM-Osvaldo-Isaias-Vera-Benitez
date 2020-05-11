package com.politecnicomalaga.Modelo;

public class Producto {
    private String nombre;
    private double precio,indiceValoracion;

    public Producto(String nombre, double precio, double indiceValoracion) {
        this.nombre = nombre;
        this.precio = precio;
        this.indiceValoracion = indiceValoracion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double getIndiceValoracion() {
        return indiceValoracion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", indiceValoracion=" + indiceValoracion +
                '}';
    }
}
