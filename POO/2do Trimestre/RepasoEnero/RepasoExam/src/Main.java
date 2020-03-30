import Controlador.Controlador;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException {
        Controlador controlador = new Controlador();
        controlador.runInterface();
    }
}
