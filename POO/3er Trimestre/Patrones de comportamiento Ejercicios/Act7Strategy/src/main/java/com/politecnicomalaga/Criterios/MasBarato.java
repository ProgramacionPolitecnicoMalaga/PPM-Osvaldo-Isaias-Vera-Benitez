package com.politecnicomalaga.Criterios;

import com.politecnicomalaga.Modelo.LoteDeProductos;
import com.politecnicomalaga.Modelo.Producto;

public class MasBarato implements SelectorDeMejorProducto{
    @Override
    public LoteDeProductos elegirMejoresProductos() {
        LoteDeProductos productosActual = LoteDeProductos.getInstance();
        LoteDeProductos filtrado = new LoteDeProductos();
        double masBarato = Double.MAX_VALUE;
        int resultado = 0;
        for (Producto p : productosActual.getListaProductos()){
            if (p.getPrecio() < masBarato){
                masBarato = p.getPrecio();
                resultado = productosActual.getListaProductos().indexOf(p);
            }
        }
        filtrado.addProducto(productosActual.getProductoEnPosicion(resultado));
        return filtrado;
    }
}
