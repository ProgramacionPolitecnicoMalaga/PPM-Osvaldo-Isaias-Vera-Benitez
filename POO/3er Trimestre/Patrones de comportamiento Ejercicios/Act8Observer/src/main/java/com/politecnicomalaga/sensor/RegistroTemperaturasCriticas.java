package com.politecnicomalaga.sensor;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RegistroTemperaturasCriticas implements ConsumidorDeTemperaturas{
    private static int TEMPERATURACRITICA = 120;
    private List<LocalTime> horasCriticas;

    public RegistroTemperaturasCriticas(){
        horasCriticas = new ArrayList<>();
    }

    @Override
    public void setNuevaTemperatura(int temperatura, Instant hora) {
        LocalTime date = hora.atZone(ZoneOffset.UTC).toLocalTime();
        if (temperatura > TEMPERATURACRITICA){
            horasCriticas.add(date);
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        StringBuilder resultado = new StringBuilder("Las horas críticas han sido: {");
        for (LocalTime l : horasCriticas){
            resultado.append(l.format(formatter));
            if (horasCriticas.indexOf(l) != horasCriticas.size()-1){
                resultado.append(", ");
            }
        }
        resultado.append("}");
        return resultado.toString();
    }
}
