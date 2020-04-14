package com.politecnicomalaga.Viewer;

import com.politecnicomalaga.Modelo.Poblacion;
import java.util.TreeMap;
import net.htmlparser.jericho.*;

public class HTMLDataViewer implements Viewer{
    private final String NT = "\n" + "\t";
    private final String NTT = "\n" + "\t" + "\t";
    StringBuilder html;

    public HTMLDataViewer(){
        html = new StringBuilder();
    }

    public String getDatos(TreeMap<String,Poblacion> datos) {
        html.append(StartTag.generateHTML("table",new TreeMap<>(),false));
        html.append(NT).append(StartTag.generateHTML("tr",new TreeMap<>(),false));
        html.append(createRow("th","Nacionalidad",NTT));
        html.append(createRow("th","Año",NTT));
        html.append(createRow("th","Total",NTT));
        html.append(NT).append(EndTag.generateHTML("tr"));
        html.append(NT);
        for (String key : datos.keySet()){
            html.append(StartTag.generateHTML("tr",new TreeMap<>(),false));
            html.append(createRow("td",key,NTT));
            html.append(createRow("td",String.valueOf(datos.get(key).getAnho()),NTT));
            html.append(createRow("td",String.valueOf(datos.get(key).getHabitantes()),NTT));
            html.append(NT);
            html.append(EndTag.generateHTML("tr"));
            if (!datos.lastKey().equals(key)){
                html.append(NT);
            }
        }
        html.append("\n");
        html.append(EndTag.generateHTML("table"));
        return html.toString();
    }

    public String createRow(String tag, String content, String indent){
        StringBuilder temp = new StringBuilder();
        temp.append(indent);
        temp.append(StartTag.generateHTML(tag,new TreeMap<>(),false));
        temp.insert(temp.length(),content);
        temp.append(EndTag.generateHTML(tag));
        return temp.toString();
    }
}
