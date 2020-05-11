package com.politecnicomalaga.sensor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PromedioTemperaturas implements ConsumidorDeTemperaturas{
    List<Integer> temperaturas;
    int average;

    public PromedioTemperaturas(){
        temperaturas = new ArrayList<>();
    }

    @Override
    public void setNuevaTemperatura(int temperatura, Instant hora) {
        temperaturas.add(temperatura);
        average = (average+temperatura)/2;
        System.out.println("El promedio de temperaturas es: " + average + "ºC");
    }
}
