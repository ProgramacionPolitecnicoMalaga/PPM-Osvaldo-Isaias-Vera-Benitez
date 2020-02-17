package Modelo;

import java.util.ArrayList;

public class Ventas {
    private ArrayList<Venta> listaVentas;

    public Ventas() {
        listaVentas = new ArrayList<>();
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void addVenta(Venta venta){
        listaVentas.add(venta);
    }

    public ArrayList<Venta> getVentasPersona(String nombreCliente){
        ArrayList<Venta> listaVentasCliente = new ArrayList<>();
        for (Venta v : listaVentas) {
            if (v.getCliente().getNombreApellido().contains(nombreCliente)){
                listaVentasCliente.add(v);
            }
        }
        return listaVentasCliente;
    }

    @Override
    public String toString() {
        return "Ventas{" +
                "ventas=" + listaVentas +
                '}';
    }
}
