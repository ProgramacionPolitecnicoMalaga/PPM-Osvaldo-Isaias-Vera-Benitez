package com.politecnicomalaga.Modelo;

import java.util.ArrayList;
import java.util.List;

public class LoteDeProductos {
    private static LoteDeProductos instancia = null;
    private List<Producto> listaProductos;

    public LoteDeProductos(){
        listaProductos = new ArrayList<>();
    }

    public static LoteDeProductos getInstance(){
        if (instancia == null)
            instancia = new LoteDeProductos();
        return instancia;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public int getTotalProductos(){
        return listaProductos.size();
    }

    public Producto getProductoEnPosicion(int posicion){
        return listaProductos.get(posicion);
    }

    public void addProducto(Producto producto){
        listaProductos.add(producto);
    }

    @Override
    public String toString() {
        return "LoteDeProductos{" +
                "listaProductos=" + listaProductos +
                '}';
    }
}
