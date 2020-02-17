package Readers;

import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;

public interface Reader {
    public ArrayList<?> leer() throws ParserConfigurationException;
}
