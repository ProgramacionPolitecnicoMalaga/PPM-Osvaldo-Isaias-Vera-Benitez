package com.politecnicomalaga.Criterios;

import com.politecnicomalaga.Modelo.LoteDeProductos;
import com.politecnicomalaga.Modelo.Producto;

public class MejorRelacionVP implements SelectorDeMejorProducto{
    @Override
    public LoteDeProductos elegirMejoresProductos() {
        LoteDeProductos productosActual = LoteDeProductos.getInstance();
        LoteDeProductos filtrado = new LoteDeProductos();
        double mejor = Double.MIN_VALUE;
        double temp;
        int resultado = 0;
        for (Producto p : productosActual.getListaProductos()){
            temp = p.getIndiceValoracion() / p.getPrecio();
            if (temp > mejor){
                System.out.println(temp);
                mejor = temp;
                resultado = productosActual.getListaProductos().indexOf(p);
            }
        }
        filtrado.addProducto(productosActual.getProductoEnPosicion(resultado));
        return filtrado;
    }
}
