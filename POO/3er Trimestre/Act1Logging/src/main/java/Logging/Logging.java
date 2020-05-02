package Logging;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Logging {
    public final static String PROPIEDADES = "config.properties";
    private Properties properties;

    public Logging() throws IOException {
        File file = new File(PROPIEDADES);
        properties = new Properties();
        if (file.exists()) {
            properties.load(new FileInputStream(file));
        }
    }

    public String getPropiedad(String nombrePropiedad) {
        return properties.getProperty(nombrePropiedad);
    }

    public void setPropiedad(String nombrePropiedad, String valorPropiedad) {
        properties.setProperty(nombrePropiedad, valorPropiedad);
    }

    public void guardar() throws IOException {
        FileOutputStream output = new FileOutputStream(new File(PROPIEDADES));
        properties.store(output, "Configuracion");
    }

    public void borrarDatos() throws IOException {
        properties.remove("nickname");
        guardar();
    }
}