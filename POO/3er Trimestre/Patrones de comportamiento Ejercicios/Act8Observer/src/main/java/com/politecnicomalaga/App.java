package com.politecnicomalaga;

import com.politecnicomalaga.sensor.DiarioTemperaturas;
import com.politecnicomalaga.sensor.PromedioTemperaturas;
import com.politecnicomalaga.sensor.RegistroTemperaturasCriticas;
import com.politecnicomalaga.sensor.SensorTemperatura;

import java.util.Timer;

public class App 
{
    public static void main( String[] args )
    {
        DiarioTemperaturas diario = new DiarioTemperaturas();
        PromedioTemperaturas promedio = new PromedioTemperaturas();
        RegistroTemperaturasCriticas criticas = new RegistroTemperaturasCriticas();
        Timer temporizador = new Timer();
        SensorTemperatura sensor = new SensorTemperatura();
        sensor.registrarConsumidor(diario);
        sensor.registrarConsumidor(promedio);
        sensor.registrarConsumidor(criticas);
        temporizador.schedule(sensor,0,5000);


    }
}
