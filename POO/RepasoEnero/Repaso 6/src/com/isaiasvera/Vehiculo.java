package com.isaiasvera;

import java.time.LocalDate;
import java.util.Objects;

public class Vehiculo {
    public static final int USADO = 1;
    public static final int NUEVO = 2;

    public static final int GASOIL = 21;
    public static final int GASOLINA = 22;

    private String modelo, marca, color, matricula;
    private int combustion, estado;
    private LocalDate anoFabricacion;
    private double precio;

    public Vehiculo(String modelo, String marca, String color, String matricula, int combustion, int estado, LocalDate anoFabricacion, double precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.matricula = matricula;
        this.combustion = combustion;
        this.estado = estado;
        this.anoFabricacion = anoFabricacion;
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.color = matricula;
    }

    public int getCombustion() {
        return combustion;
    }

    public void setCombustion(int combustion) {
        this.combustion = combustion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDate getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(LocalDate anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getEstadoNombre(){
        String est;
        switch (estado){
            case 1:
                est = "Nuevo";
                break;
            case 2:
                est = "Usado";
                break;
            default:
                est = "No hay datos";
        }
        return est;
    }
    public String getCombustionNombre(){
        String est;
        switch (estado){
            case 1:
                est = "Gasoil";
                break;
            case 2:
                est = "Gasolina";
                break;
            default:
                est = "No hay datos";
        }
        return est;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", matricula='" + matricula + '\'' +
                ", combustion='" + getCombustionNombre() + '\'' +
                ", estado='" + getEstadoNombre() + '\'' +
                ", anoFabricacion=" + anoFabricacion +
                ", precio=" + precio +
                '}';
    }
}
