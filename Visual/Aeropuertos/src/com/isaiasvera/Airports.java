package com.isaiasvera;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Airports {
    private JPanel panelMain;
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JList list1;
    private Map<String,String> paises =  new TreeMap<>();

    public Airports() throws URISyntaxException, IOException, SAXException, ParserConfigurationException {
        File resource = new File("src/com/isaiasvera" + File.separator + "aeropuertos.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(resource);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("aeropuerto");
        for (int c = 0; c < nodeList.getLength(); c++){
            Node nodo = nodeList.item(c);
            if (nodo.getNodeType() == Node.ELEMENT_NODE){
                Element elemento = (Element) nodo;
                String temp = elemento.getAttribute("pais");
               paises.put(elemento.getAttribute("pais"), "");
            }
        }
        for (String a: paises.keySet()){
            comboBox1.addItem(a);
        }
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                String temp = Objects.requireNonNull(comboBox1.getSelectedItem().toString());
                File resource = new File("src/com/isaiasvera" + File.separator + "aeropuertos.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = null;
                try {
                    dBuilder = dbFactory.newDocumentBuilder();
                } catch (ParserConfigurationException ex) {
                    ex.printStackTrace();
                }
                Document doc = null;
                try {
                    doc = dBuilder.parse(resource);
                } catch (SAXException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                doc.getDocumentElement().normalize();
                NodeList nodeList = doc.getElementsByTagName("aeropuerto");
                for (int c = 0; c < nodeList.getLength(); c++){
                    Node nodo = nodeList.item(c);
                    if (nodo.getNodeType() == Node.ELEMENT_NODE){
                        Element elemento = (Element) nodo;
                        String tmp = elemento.getAttribute("pais");
                        if (tmp.equals(temp)){
                            textArea1.append(elemento.getAttribute("nombreLargo") + "\n");
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) throws URISyntaxException, ParserConfigurationException, SAXException, IOException {
        JFrame frame = new JFrame("Airports");
        frame.setContentPane(new Airports().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
