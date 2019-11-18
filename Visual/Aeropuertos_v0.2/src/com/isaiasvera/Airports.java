package com.isaiasvera;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Airports {
    private JPanel panelMain;
    private JComboBox cbPaises;
    private JTable tableAirports;
    private JPanel panelActions, panelDatos, panelTitulo, panelSelectorPaises;
    private JLabel txtSelectCountry;
    private Map<String,ArrayList<Aeropuerto>> paisesAeropuertos =  new TreeMap<>();

    public Airports() throws ParserConfigurationException {
        cargarDatosAeropuerto();
        configurarTabla();
        cbPaises.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int c = 0;
                borrarDatosTabla();
                String paisSeleccionado = Objects.requireNonNull(cbPaises.getSelectedItem().toString());
                if (!paisSeleccionado.equals("")){
                    ArrayList<Aeropuerto> nombresAeropuertos;
                    nombresAeropuertos = paisesAeropuertos.get(paisSeleccionado);
                    for (Aeropuerto nombresAeropuerto : nombresAeropuertos) {
                        c++;
                        agregarATabla(nombresAeropuerto.getNombreLargo(), nombresAeropuerto.getMatricula(), c);
                    }
                }
            }
        });
    }

    public static void main(String[] args) throws ParserConfigurationException {
        JFrame frame = new JFrame("Airports");
        frame.setContentPane(new Airports().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void cargarDatosAeropuerto() throws ParserConfigurationException{
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
                    String pais = elemento.getAttribute("pais");
                    ArrayList<Aeropuerto> aeropuerto = new ArrayList<>();
                    String nLargo = elemento.getAttribute("nombreLargo");
                    String mat = elemento.getAttribute("matricula");
                    if (paisesAeropuertos.containsKey(pais)){
                        paisesAeropuertos.get(pais).add(new Aeropuerto.ApBuilder().withPais(pais).withNombreLargo(nLargo).withMatricula(mat).build());
                    } else {
                        aeropuerto.add(new Aeropuerto.ApBuilder().withPais(pais).withNombreLargo(nLargo).withMatricula(mat).build());
                        paisesAeropuertos.put(pais,aeropuerto);
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
    private void configurarTabla(){
        DefaultTableModel tableModel = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){return false;}
        };
        tableModel.addColumn("-");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Matricula");
        tableAirports.setModel(tableModel);
        tableAirports.getColumn("Matricula").setMaxWidth(80);
        tableAirports.getColumn("-").setMaxWidth(35);
    }
    private void agregarATabla(String col1, String col2, int c){
        DefaultTableModel model = (DefaultTableModel) tableAirports.getModel();
            model.addRow(new Object[]{c,col1, col2});
    }
    private void borrarDatosTabla (){
        DefaultTableModel model = (DefaultTableModel) tableAirports.getModel();
        int rowCount = model.getRowCount();
        for (int c = rowCount - 1; c >= 0; c--){
            model.removeRow(c);
        }
    }
}
