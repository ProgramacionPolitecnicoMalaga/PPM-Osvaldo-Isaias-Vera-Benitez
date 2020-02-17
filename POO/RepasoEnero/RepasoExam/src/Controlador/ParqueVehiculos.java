package Controlador;

import Modelo.Vehiculo;
import Modelo.Venta;

import java.util.ArrayList;

public class ParqueVehiculos {
    private ArrayList<Vehiculo> listaVehiculos;

    public ParqueVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void actualizarCantidades(ArrayList<Venta> ventas){
        for(Venta v : ventas){
            restarCantidades(v.getVehiculo());
        }
    }

    public void restarCantidades(Vehiculo vehiculo){
        String marca = vehiculo.getMarca();
        String modelo = vehiculo.getModelo();
        int cantidad = vehiculo.getUnidades();
        for(Vehiculo v : listaVehiculos){
            if(v.getMarca().equals(marca) && v.getModelo().equals(modelo)){
                v.setUnidades(v.getUnidades() - cantidad);
            }
        }
    }

    public ArrayList<Vehiculo> getVehiculosSinStock(){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        for(Vehiculo v : listaVehiculos){
            if (v.getUnidades() == 0){
                vehiculos.add(v);
            }
        }
        return vehiculos;
    }

    public ArrayList<Vehiculo> getVehiculosConStock(){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        for(Vehiculo v : listaVehiculos){
            if (v.getUnidades() != 0){
                vehiculos.add(v);
            }
        }
        return vehiculos;
    }
}