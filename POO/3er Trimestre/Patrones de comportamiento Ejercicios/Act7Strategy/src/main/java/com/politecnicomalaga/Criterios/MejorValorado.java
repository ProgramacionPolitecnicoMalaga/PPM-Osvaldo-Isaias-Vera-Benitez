package com.politecnicomalaga.Criterios;

import com.politecnicomalaga.Modelo.LoteDeProductos;
import com.politecnicomalaga.Modelo.Producto;

public class MejorValorado implements SelectorDeMejorProducto{
    @Override
    public LoteDeProductos elegirMejoresProductos() {
        LoteDeProductos productosActual = LoteDeProductos.getInstance();
        LoteDeProductos filtrado = new LoteDeProductos();
        double masAlto = Double.MIN_VALUE;
        int resultado = 0;
        for (Producto p : productosActual.getListaProductos()){
            if (p.getIndiceValoracion() > masAlto){
                masAlto = p.getIndiceValoracion();
                resultado = productosActual.getListaProductos().indexOf(p);
            }
        }
        filtrado.addProducto(productosActual.getProductoEnPosicion(resultado));
        return filtrado;
    }
}
