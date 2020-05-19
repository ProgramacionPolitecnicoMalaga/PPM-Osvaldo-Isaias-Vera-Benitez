package com.politecnicomalaga.composite;

public class ServicioBuilder {
    private Servicio servicioActual;

    public ServicioBuilder(Servicio raiz){
        servicioActual = raiz;
    }

    public ServicioBuilder abrirPaquete(String nombre){
        Paquete paquete = new Paquete(nombre);
        if (servicioActual.esPaquete()){
            ((Paquete) servicioActual).addHijo(paquete);
            servicioActual = paquete;
        } else throw  new IllegalArgumentException("No es un paquete");
        return this;
    }

    public ServicioBuilder cerrarPaquete(){
        servicioActual = servicioActual.getPadre();
        return this;
    }

    public ServicioBuilder addProducto(String nombre){
        Producto producto = new Producto(nombre);
        ((Paquete) servicioActual).addHijo(producto);
        return this;
    }

    public Servicio getResult(){
        return servicioActual;
    }
}
