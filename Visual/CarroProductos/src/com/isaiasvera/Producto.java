package com.isaiasvera;

public class Producto {
    private double precio;
    private String nombre;
    private String tipo;
    private String cantidad;

    public Producto(double precio, String nombre, String tipo, String cantidad) {
        this.precio = precio;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
