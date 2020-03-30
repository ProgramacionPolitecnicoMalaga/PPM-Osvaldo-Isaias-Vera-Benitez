package Controlador;

import Modelo.Persona;
import Modelo.Vehiculo;
import Modelo.Ventas;
import Readers.ReaderFactory;
import Readers.Reader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Manager {
    private ParqueVehiculos parqueVehiculos;
    private ArrayList<Persona> personas;
    private Ventas ventas;
    private ReaderFactory factory;

    public Manager() throws IOException, ParserConfigurationException {
        factory = new ReaderFactory();
        ventas = new Ventas();
        readFiles();
    }

    private void readFiles() throws IOException, ParserConfigurationException {
        Reader reader = factory.fabricarReader("Vehiculos.xml");
        parqueVehiculos = new ParqueVehiculos((ArrayList<Vehiculo>) reader.leer());
        reader = factory.fabricarReader("Personas.csv");
        personas = (ArrayList<Persona>) reader.leer();
    }

    public ParqueVehiculos getParqueVehiculos() {
        return parqueVehiculos;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public Ventas getVentas() {
        return ventas;
    }
}
