package com.politecnicomalaga.Escenario;

public class EscenarioFactory {
    public Escenario getEscenario(TipoEscenario tipo){
        switch (tipo){
            case SELVA: return new Selva();
            case DESIERTO: return new Desierto();
            case ESPACIO: return new Espacio();
        }
        throw new IllegalArgumentException("No existe ese escenario");
    }
}
