package com.politecnicomalaga.sensor;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SensorTemperatura extends SensorTimerTask implements FuenteDeTemperaturas{
    private List<ConsumidorDeTemperaturas> subscribers;
    private int sensor;
    private Random aleatorio;
    private Instant inicio;
    private Instant ahora;

    public SensorTemperatura(){
        subscribers = new ArrayList<>();
        aleatorio = new Random();
        inicio = Instant.now();
    }

    public void nuevaLectura(){
        sensor = aleatorio.ints(40, 200).limit(1).findFirst().getAsInt();
        ahora = Instant.now();
        Duration period = Duration.between(inicio,ahora);
        System.out.println("Lectura de temperatura: " + sensor +  "ºC (" + period.getSeconds() + " segundos desde el inicio)");
        informarAConsumidores();
    }

    @Override
    public void registrarConsumidor(ConsumidorDeTemperaturas subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void informarAConsumidores() {
        for (ConsumidorDeTemperaturas ct : subscribers){
            ct.setNuevaTemperatura(sensor,ahora);
        }
    }
}

