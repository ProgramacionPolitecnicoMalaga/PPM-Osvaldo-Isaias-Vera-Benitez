package Modelo;

public class Vehiculo {
    private String marca, modelo, combustible;
    private int kilometros, unidades;
    private double precio;

    public Vehiculo(String marca, String modelo, String combustible, int kilometros, int unidades, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.combustible = combustible;
        this.kilometros = kilometros;
        this.unidades = unidades;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCombustible() {
        return combustible;
    }

    public int getKilometros() {
        return kilometros;
    }

    public int getUnidades() {
        return unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", combustible='" + combustible + '\'' +
                ", kilometros=" + kilometros +
                ", unidades=" + unidades +
                ", precio=" + precio +
                '}' + "\n";
    }
}
