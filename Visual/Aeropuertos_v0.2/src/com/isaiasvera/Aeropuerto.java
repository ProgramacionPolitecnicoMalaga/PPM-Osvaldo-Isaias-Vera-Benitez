package com.isaiasvera;

public class Aeropuerto {
    private String area;
    private String pais;
    private String nombreLargo;
    private String nombreCorto;
    private String matricula;
    private double lat;
    private double lon;

    public Aeropuerto(ApBuilder builder){
        this.area = builder.area;
        this.pais = builder.pais;
        this.nombreLargo = builder.nombreLargo;
        this.nombreCorto = builder.nombreCorto;
        this.matricula = builder.matricula;
        this.lat = builder.lat;
        this.lon = builder.lon;
    }

    public String getArea() {
        return area;
    }

    public String getPais() {
        return pais;
    }

    public String getNombreLargo() {
        return nombreLargo;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public static class ApBuilder {
        private String area;
        private String pais;
        private String nombreLargo;
        private String nombreCorto;
        private String matricula;
        private double lat;
        private double lon;

        public ApBuilder withArea (String text){
            this.area = text;
            return this;
        }
        public ApBuilder withPais (String text){
            this.pais = text;
            return this;
        }
        public ApBuilder withNombreLargo (String text){
            this.nombreLargo = text;
            return this;
        }
        public ApBuilder withNombreCorto(String text){
            this.nombreCorto = text;
            return this;
        }
        public ApBuilder withMatricula(String text){
            this.matricula = text;
            return this;
        }
        public ApBuilder withLat(double num){
            this.lat = num;
            return this;
        }
        public ApBuilder withLon(double num){
            this.lon = num;
            return this;
        }
        public Aeropuerto build(){
            return new Aeropuerto(this);
        }

    }

}
