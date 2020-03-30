package com.isaiasvera;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Random;

public class Manager {
    private double saldoConcesionario = 200000.00;
    private ArrayList<Cliente> clientes;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<CompraVenta> comprasVentas;

    public Manager (){
        clientes = new ArrayList<>();
        vehiculos = new ArrayList<>();
        comprasVentas = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<CompraVenta> getComprasVentas() {
        return comprasVentas;
    }

    public void setComprasVentas(ArrayList<CompraVenta> comprasVentas) {
        this.comprasVentas = comprasVentas;
    }

    public double getSaldoConcesionario() {
        return saldoConcesionario;
    }

    public void setSaldoConcesionario(double saldoConcesionario) {
        this.saldoConcesionario = saldoConcesionario;
    }

    public void addVehiculo(Vehiculo vehiculo) throws VehiculoException {
        if (!vehiculos.contains(vehiculo)){
            vehiculos.add(vehiculo);
        } else {
            throw new VehiculoException();
        }
    }

    public void addCliente(Cliente cliente) throws ClienteException {
        if (!clientes.contains(cliente)){
            clientes.add(cliente);
        } else {
            throw new ClienteException();
        }
    }

    public void addOperacion(CompraVenta operacion) {
        if (operacion.getOperacion() == CompraVenta.VENTA){
            if (operacion.getCliente().getSaldo() > operacion.getVehiculo().getPrecio()){
                comprasVentas.add(operacion);
                operacion.getCliente().setSaldo(operacion.getCliente().getSaldo()-operacion.getVehiculo().getPrecio());
                deleteVehiculo(operacion.getVehiculo());
            } else {
                System.out.println("Saldo del cliente insuficiente para realizar la operacion.");
            }
        } else {
            if (operacion.getVehiculo().getPrecio() < getSaldoConcesionario()){
                comprasVentas.add(operacion);
                setSaldoConcesionario(getSaldoConcesionario()-operacion.getVehiculo().getPrecio());
            } else {
                System.out.println("Saldo del Concesionario insuficiente para realizar la operación.");
            }
        }
    }

    public String getSaldoCliente(Cliente cliente){
        double valorCompras = Double.MIN_VALUE;
        double valorVentas = Double.MIN_VALUE;
        for (CompraVenta cv : comprasVentas){
            if (cliente.equals(cv.getCliente())){
                if (cv.getOperacion() == CompraVenta.VENTA){
                    valorVentas += cv.getPrecio();
                } else {
                    valorCompras += cv.getPrecio();
                }
            }
        }
        return "Valor de compras: " + valorCompras + "\n" + "Valor de ventas: " + valorVentas;
    }

    public void deleteVehiculo(Vehiculo vehiculo){
        getVehiculos().remove(vehiculo);
    }

}
