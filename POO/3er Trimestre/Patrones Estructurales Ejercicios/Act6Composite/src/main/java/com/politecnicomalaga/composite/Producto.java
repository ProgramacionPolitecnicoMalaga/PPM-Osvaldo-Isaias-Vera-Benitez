package com.politecnicomalaga.composite;

public class Producto implements Servicio{
    private String nombre;
    private double precio;
    private Paquete padre;

    public Producto(String nombre){
        this.nombre = nombre;
        asignarPrecio();
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean esPaquete() {
        return false;
    }

    @Override
    public void setPadre(Paquete padre) {
        this.padre = padre;
    }

    @Override
    public Paquete getPadre() {
        return padre;
    }

    public String getNombre(){
        return nombre;
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
        return "| [" + nombre +" = "+ precio + "]";
    }
}
