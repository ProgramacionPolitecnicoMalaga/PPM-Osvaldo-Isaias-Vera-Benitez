package com.isaiasvera;

public class CompraVenta {
    public static final int COMPRA = 1;
    public static final int VENTA = 2;

    private Cliente cliente;
    private Vehiculo vehiculo;
    private double precio;
    private int operacion;

    public CompraVenta(Cliente cliente, Vehiculo vehiculo, double precio, int operacion) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.precio = precio;
        this.operacion = operacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }
}
