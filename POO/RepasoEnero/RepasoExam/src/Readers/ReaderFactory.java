package Readers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderFactory {
    public Reader fabricarReader(String fileName) throws IOException {
        Path path = new File(fileName).toPath();
        String mimeType = Files.probeContentType(path);
        switch (mimeType){
            case "text/xml": return new XMLReader(fileName);
            case "application/vnd.ms-excel": return new CSVReader(fileName);
            default: return new XMLReader(fileName);
        }
    }
}