package com.politecnicomalaga.Controlador;

import com.politecnicomalaga.Modelo.Poblacion;
import com.politecnicomalaga.Reader.LectorENV;
import com.politecnicomalaga.Reader.LectorXML;
import com.politecnicomalaga.Viewer.Viewer;
import com.politecnicomalaga.Viewer.ViewerFactory;

import java.util.TreeMap;

public class ControladorPoblacion {
    private TreeMap<String,Poblacion> listaPoblacion;
    private Viewer viewer;

    public ControladorPoblacion (){
        listaPoblacion = new TreeMap<>();
        cargar();
    }

    public void cargar(){
        LectorXML lectorXML = new LectorXML();
        ViewerFactory factory = new ViewerFactory();
        viewer = factory.getViewer(LectorENV.getTipo());
        setListaPoblacion(lectorXML.getDatos());
    }

    public String getDatos(){
        return viewer.getDatos(getListaPoblacion());
    }

    public TreeMap<String, Poblacion> getListaPoblacion() {
        return listaPoblacion;
    }

    public void setListaPoblacion(TreeMap<String, Poblacion> listaPoblacion) {
        this.listaPoblacion = listaPoblacion;
    }

}
