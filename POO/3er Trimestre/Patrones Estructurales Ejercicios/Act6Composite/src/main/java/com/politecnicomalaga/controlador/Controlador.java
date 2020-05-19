package com.politecnicomalaga.controlador;

import com.politecnicomalaga.composite.Paquete;
import com.politecnicomalaga.composite.Producto;
import com.politecnicomalaga.composite.Servicio;
import com.politecnicomalaga.composite.ServicioBuilder;

import java.util.List;

public class Controlador {
    ServicioBuilder builder;
    Servicio serviciofinal;

    public Controlador(){
        serviciofinal = init();
    }

    public void addServicio(String servicio, boolean esPaquete){
        if (builder == null){
            if (esPaquete){
                builder = new ServicioBuilder(new Paquete(servicio));
            } else {
                throw new IllegalArgumentException("Añadir un paquete primero");
            }
        } else {
            if (esPaquete){
                builder.abrirPaquete(servicio);
            } else {
                builder.addProducto(servicio);
            }
        }
    }

    public void cerrar(){
        builder.cerrarPaquete();
    }

    public void borrarServicio(int[] posicionServicio){


    }

    public Servicio getServiciofinal(){
        return serviciofinal;
    }


    public Servicio init(){
        Paquete raizIlink = new Paquete("iLink");
        ServicioBuilder builder = new ServicioBuilder(raizIlink);

        builder.abrirPaquete("iLink")
                .abrirPaquete("Rack").addProducto("Servidor").addProducto("Servidor").cerrarPaquete()
                .abrirPaquete("Rack").addProducto("Servidor").cerrarPaquete()
                .cerrarPaquete()
                .abrirPaquete("CloudSolutions")
                .abrirPaquete("Rack").addProducto("VPS").addProducto("VPS").cerrarPaquete()
                .cerrarPaquete();
        return builder.getResult();
    }
}
