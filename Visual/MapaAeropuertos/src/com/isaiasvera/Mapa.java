package com.isaiasvera;

import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.Style;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Mapa {
    private JPanel panelMain, panelActions, panelMap, panelTitulo, panelSelectorPaises;
    private JLabel txtSelectCountry;
    private JComboBox cbPaises;
    private JMapViewer mapViewer;
    private Map<String, ArrayList<Aeropuerto>> paisesAeropuertos =  new TreeMap<>();

    public Mapa() throws ParserConfigurationException {
        cargarDatosAeropuerto();
        DefaultMapController controller = new DefaultMapController(mapViewer);
        controller.setMovementMouseButton(1);
        mapViewer.setScrollWrapEnabled(true);
        Point punto = new Point();
        punto.setLocation(0, -350);
        mapViewer.setZoom(2, punto);
        cbPaises.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarMarcadores();
                String paisSeleccionado = Objects.requireNonNull(cbPaises.getSelectedItem().toString());
                if (!paisSeleccionado.equals("")){
                    ArrayList<Aeropuerto> nombresAeropuertos;
                    nombresAeropuertos = paisesAeropuertos.get(paisSeleccionado);
                    for (Aeropuerto nombresAeropuerto : nombresAeropuertos) {
                        agregarMarcador(nombresAeropuerto.getLat(),nombresAeropuerto.getLon());
                    }
                    mapViewer.setDisplayToFitMapMarkers();
                }
            }
        });
    }

    public static void main(String[] args) throws ParserConfigurationException {
        JFrame frame = new JFrame("Mapa");
        frame.setContentPane(new Mapa().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void cargarDatosAeropuerto() throws ParserConfigurationException {
        String path = System.getProperty("user.dir");
        String fileName = "aeropuertos.xml";
        File resource = new File(path + File.separator + fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        try {
            Document doc = dBuilder.parse(resource);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("aeropuerto");
            for (int c = 0; c < nodeList.getLength(); c++){
                Node nodo = nodeList.item(c);
                if (nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element elemento = (Element) nodo;
                    String pais = elemento.getAttribute("pais").trim();
                    ArrayList<Aeropuerto> aeropuerto = new ArrayList<>();
                    String lat1 = elemento.getAttribute("lat");
                    String lon1 = elemento.getAttribute("lon");
                    double lat2, lon2;
                    if (lat1.matches("(\\+|-)?([0-9]+(\\.[0-9]+))") && lon1.matches("(\\+|-)?([0-9]+(\\.[0-9]+))")){
                        lat2 = Double.parseDouble(elemento.getAttribute("lat"));
                        lon2 = Double.parseDouble(elemento.getAttribute("lon"));
                    } else {
                        lat2 = 0;
                        lon2 = 0;
                    }
                    if (paisesAeropuertos.containsKey(pais)){
                        paisesAeropuertos.get(pais).add(new Aeropuerto.ApBuilder().withLat(lat2).withLon(lon2).build());
                    } else {
                        aeropuerto.add(new Aeropuerto.ApBuilder().withPais(pais).withLat(lat2).withLon(lon2).build());
                        paisesAeropuertos.put(pais, aeropuerto);
                    }
                }
            }
        } catch (IOException | SAXException io){
            io.printStackTrace();
        }

        cbPaises.insertItemAt("",0);
        cbPaises.setSelectedIndex(0);
        for (String a: paisesAeropuertos.keySet()){
            cbPaises.addItem(a);
        }
    }

    private void agregarMarcador(double lat, double lon){
        if (lat != 0 && lon != 0){
            MapMarkerDot marcador = new MapMarkerDot(lat, lon);
            marcador.setBackColor(new Color(0,102,255));
            marcador.setColor(new Color(255,255,255));
            mapViewer.addMapMarker(marcador);
        }
    }

    private void borrarMarcadores(){
        mapViewer.getMapMarkerList().clear();
    }

}
