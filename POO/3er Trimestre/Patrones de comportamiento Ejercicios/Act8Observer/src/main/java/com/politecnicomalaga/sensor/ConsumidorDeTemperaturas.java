package com.politecnicomalaga.sensor;

import java.time.Instant;

public interface ConsumidorDeTemperaturas {
    public void setNuevaTemperatura(int temperatura, Instant hora);
}
