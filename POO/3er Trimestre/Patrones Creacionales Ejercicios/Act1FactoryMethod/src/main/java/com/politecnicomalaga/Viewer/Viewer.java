package com.politecnicomalaga.Viewer;

import com.politecnicomalaga.Modelo.Poblacion;
import java.util.TreeMap;

public interface Viewer {
    public final static String HTML = "html";
    public final static String TEXT = "text";
    public String getDatos(TreeMap<String,Poblacion> listaPoblacion);
}
