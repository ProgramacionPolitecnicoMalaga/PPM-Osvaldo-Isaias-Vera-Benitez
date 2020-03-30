package com.isaiasvera;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Random;

public class Cliente {
    private String nombre, apellido, nif, cuentaBancaria;
    private double saldo;
    private DecimalFormat formato = new DecimalFormat("#.##");

    public Cliente(String nombre, String apellido, String nif, String cuentaBancaria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nif = nif;
        this.cuentaBancaria = cuentaBancaria;
        saldo = randomSaldo(3500.00, 35000.00);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double randomSaldo (double from, double to){
        double eo = from + new Random().nextDouble() * (to - from);
        formato.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(formato.format(eo).replaceAll(",","."));
    }

    @Override
    public boolean equals(Object obj) {
        boolean contains = false;
        if (obj instanceof Cliente){
            Cliente cliente = (Cliente) obj;
            contains = cliente.nif.equals(this.nif);
        }
        return contains;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nif='" + nif + '\'' +
                ", cuentaBancaria='" + cuentaBancaria + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    /*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return nif.equals(cliente.nif);
    }


    @Override
    public int hashCode() {
        return Objects.hash(nif);
    }*/
}
