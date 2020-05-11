package com.politecnicomalaga.sensor;

public interface FuenteDeTemperaturas {
    public void registrarConsumidor(ConsumidorDeTemperaturas subscriber);
    public void informarAConsumidores();
}
