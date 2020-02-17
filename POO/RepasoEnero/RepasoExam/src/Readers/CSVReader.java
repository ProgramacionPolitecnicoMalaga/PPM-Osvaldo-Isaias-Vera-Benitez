package Readers;

import Modelo.Persona;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CSVReader implements Reader {
    String fileName;
    String dir;
    public CSVReader(String fileName) {
        dir = System.getProperty("user.dir");
        this.fileName = fileName;
    }
    @Override
    public ArrayList<?> leer() {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        File inputFile = new File(dir + File.separator + fileName);
        String[] datosPersona;
        String delimeter = ";";
        String linea;
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(inputFile));
            while ((linea = bReader.readLine()) != null) {
                datosPersona = linea.split(delimeter);
                for (String s : datosPersona) {
                    listaPersonas.add(new Persona(s));
                }
            }
        } catch (IOException a){
            a.printStackTrace();
        }
        return listaPersonas;
    }

}
