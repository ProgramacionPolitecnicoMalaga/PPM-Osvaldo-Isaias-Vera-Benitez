package Modelo;

public class Venta {
    private Persona cliente;
    private Vehiculo vehiculo;
    private int cantidad;

    public Venta(Persona cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        cantidad = vehiculo.getUnidades();
    }

    public Persona getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "cliente=" + cliente +
                ", vehiculo=" + vehiculo +
                ", cantidad=" + cantidad +
                '}';
    }
}
