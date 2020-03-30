package com.isaiasvera;

public class Issue {
    private int idIncidencia;
    private String descripcion;
    private int sistemaAfectado;

    public Issue(int idIncidencia, String descripcion, int sistemaAfectado) {
        this.idIncidencia = idIncidencia;
        this.descripcion = descripcion;
        this.sistemaAfectado = sistemaAfectado;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSistemaAfectado(int sistemaAfectado) {
        this.sistemaAfectado = sistemaAfectado;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getSistemaAfectado() {
        return sistemaAfectado;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Issue tmp = (Issue) obj;
        return idIncidencia == tmp.getIdIncidencia() && sistemaAfectado == tmp.getSistemaAfectado();
    }

    @Override
    public String toString() {
        return "Issue{" +
                "idIncidencia=" + idIncidencia +
                ", descripcion='" + descripcion + '\'' +
                ", sistemaAfectado=" + sistemaAfectado +
                '}' + "\n";
    }
}
