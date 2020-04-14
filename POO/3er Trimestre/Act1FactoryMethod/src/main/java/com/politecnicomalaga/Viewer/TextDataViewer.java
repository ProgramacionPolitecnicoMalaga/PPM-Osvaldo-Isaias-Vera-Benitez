package com.politecnicomalaga.Viewer;

import com.politecnicomalaga.Modelo.Poblacion;
import java.util.TreeMap;

public class TextDataViewer implements Viewer{
    public String getDatos(TreeMap<String,Poblacion> listaPoblacion) {
        StringBuilder lista = new StringBuilder();
        lista.append("\n").append("Listado de empadronamientos:\n");
        lista.append("-------------------------------------------------------------------------------------------------").append("\n");
        for (String key : listaPoblacion.keySet()){
            lista.append("\t" + "El total de empadronados en ")
                    .append(listaPoblacion.get(key).getAnho())
                    .append(" procedentes de ").append(key).append(" fue de ")
                    .append(listaPoblacion.get(key).getHabitantes())
                    .append(" personas.")
                    .append("\n").append("-------------------------------------------------------------------------------------------------");
            if (!listaPoblacion.lastKey().equals(key)){
                lista.append("\n");
            }
        }
        return lista.toString();
    }
}
