package com.politecnicomalaga.Factory;

import com.politecnicomalaga.Criterios.MasBarato;
import com.politecnicomalaga.Criterios.MejorRelacionVP;
import com.politecnicomalaga.Criterios.MejorValorado;
import com.politecnicomalaga.Criterios.SelectorDeMejorProducto;

public class CriterioFactory {
    public static SelectorDeMejorProducto getCriterio(int criterio){
        switch (criterio){
            case SelectorDeMejorProducto.MVALORADO:
                return new MejorValorado();
            case SelectorDeMejorProducto.MBARATO:
                return new MasBarato();
            case SelectorDeMejorProducto.MRELACIONVP:
                return new MejorRelacionVP();
            default:
                return new MejorValorado();
        }
    }
}
