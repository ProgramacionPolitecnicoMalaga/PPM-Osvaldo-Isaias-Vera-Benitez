package Readers;

import Modelo.Vehiculo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
import java.util.ArrayList;

public class XMLReader implements Reader {
    String dir;
    String fileName;

    public XMLReader(String fileName){
        dir = System.getProperty("user.dir");
        this.fileName = fileName;
    }

    @Override
    public ArrayList<?> leer() throws ParserConfigurationException {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        try {
            File inputFile = new File(dir + File.separator + fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            XPath xPath = XPathFactory.newInstance().newXPath();
            String xpathExpr = "vehiculos/vehiculo";
            NodeList nodeList = (NodeList) xPath.compile(xpathExpr).evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nodeList.item(i);
                    if (el.getNodeName().contains("vehiculo")) {
                        listaVehiculos.add(getDatosVehiculo(el));
                    }
                }
            }
        } catch (IOException | SAXException | XPathExpressionException e) {
            e.printStackTrace();
        }
        return listaVehiculos;
    }

    public Vehiculo getDatosVehiculo (Element vehiculo){
        String marca = vehiculo.getAttribute("marca");
        String modelo = vehiculo.getAttribute("modelo");
        String comb = vehiculo.getAttribute("combustible");
        int km = Integer.parseInt(vehiculo.getAttribute("kilometros"));
        int unidades = Integer.parseInt(vehiculo.getAttribute("unidades"));
        double precio = Double.parseDouble(vehiculo.getAttribute("precio"));
        return new Vehiculo(marca,modelo,comb,km,unidades,precio);
    }
}
