package com.isaiasvera;

import java.util.ArrayList;
import java.util.Random;

public class Manager {
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

    public void addVehiculo(Vehiculo vehiculo) throws VehiculoException {
        if (!vehiculos.contains(vehiculo)){
            vehiculos.add(vehiculo);
        } else {
            throw new VehiculoException();
        }
    }

    public void addCliente(Cliente cliente) throws ClienteException {
        if (!vehiculos.contains(cliente)){
            clientes.add(cliente);
        } else {
            throw new ClienteException();
        }
    }
}
