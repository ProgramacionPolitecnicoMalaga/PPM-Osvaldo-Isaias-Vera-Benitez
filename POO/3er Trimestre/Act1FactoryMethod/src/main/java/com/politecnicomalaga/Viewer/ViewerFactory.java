package com.politecnicomalaga.Viewer;

public class ViewerFactory {
    public Viewer getViewer(String tipo){
        switch (tipo){
            case Viewer.HTML: return new HTMLDataViewer();
            case Viewer.TEXT: return new TextDataViewer();
            default: new HTMLDataViewer();
        }
        throw new IllegalArgumentException("Tipo de viewer no existe.");
    }
}
