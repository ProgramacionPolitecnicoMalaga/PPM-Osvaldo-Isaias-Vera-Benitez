package com.politecnicomalaga.Reader;

import com.politecnicomalaga.Modelo.Poblacion;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public class LectorXML {
    private Document doc;

    public LectorXML(){
        try{
            File inputFile = new File("./src/main/resources/poblacion-por-nacionalidades_2016-2018_alcobendas.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
        }catch (IOException | ParserConfigurationException | SAXException e){
            e.printStackTrace();
        }
    }

    public TreeMap<String,Poblacion> getDatos(){
        TreeMap<String,Poblacion> listaDatos = new TreeMap<>();
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            String xpathExpr = "/root/row";
            NodeList nodeList = (NodeList) xPath.compile(xpathExpr).evaluate(doc, XPathConstants.NODESET);
            for (int c=0; c<nodeList.getLength(); c++){
                Element element = (Element) nodeList.item(c);
                if (element.getNodeName().equals("row")){
                    String key = element.getAttribute("Nacionalidad");
                    int anho = Integer.parseInt(element.getAttribute("Año"));
                    int habitantes = Integer.parseInt(element.getAttribute("Número_de_empadronados"));
                    listaDatos.put(key,new Poblacion(anho,habitantes));
                }
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return listaDatos;
    }
}
