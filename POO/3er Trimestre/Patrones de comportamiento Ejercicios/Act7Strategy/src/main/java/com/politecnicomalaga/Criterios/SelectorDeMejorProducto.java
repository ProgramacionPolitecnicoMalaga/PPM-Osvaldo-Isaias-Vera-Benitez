package com.politecnicomalaga.Criterios;

import com.politecnicomalaga.Modelo.LoteDeProductos;

public interface SelectorDeMejorProducto {
    public static int MVALORADO = 1;
    public static int MBARATO = 2;
    public static int MRELACIONVP = 3;

    public LoteDeProductos elegirMejoresProductos();
}
