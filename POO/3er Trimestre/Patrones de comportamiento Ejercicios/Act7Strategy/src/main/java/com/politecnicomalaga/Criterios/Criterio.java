package com.politecnicomalaga.Criterios;

import com.politecnicomalaga.Modelo.LoteDeProductos;

public class Criterio {
    private SelectorDeMejorProducto selectorDeMejorProducto;

    public void setSelectorDeMejorProducto(SelectorDeMejorProducto selectorDeMejorProducto) {
        this.selectorDeMejorProducto = selectorDeMejorProducto;
    }

    public LoteDeProductos getProductoSegunCriterio(){
        return selectorDeMejorProducto.elegirMejoresProductos();
    }
}
