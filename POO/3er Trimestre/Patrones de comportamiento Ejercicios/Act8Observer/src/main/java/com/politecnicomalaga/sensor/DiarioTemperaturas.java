package com.politecnicomalaga.sensor;

import java.text.CollationKey;
import java.text.Collator;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DiarioTemperaturas implements ConsumidorDeTemperaturas{
    private Map<LocalTime,Integer> registro;

    public DiarioTemperaturas(){
        registro = new TreeMap<>();
    }
    @Override
    public void setNuevaTemperatura(int temperatura, Instant hora) {
        LocalTime date = hora.atZone(ZoneOffset.UTC).toLocalTime();
        registro.put(date,temperatura);
        System.out.println(this);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        int c = 0;
        StringBuilder resultado = new StringBuilder("DiarioTemperaturas: ").append("{");
        for (LocalTime i : registro.keySet()){
            c++;
            resultado.append("Hora: ").append(i.format(formatter)).append(", Temperatura: ").append(registro.get(i)).append("ºC");
            if (c < registro.size()){
                resultado.append(", ");
            }
        }
        resultado.append("}");
        return resultado.toString();
    }
}
