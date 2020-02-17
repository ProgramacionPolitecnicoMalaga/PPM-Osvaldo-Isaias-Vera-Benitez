package Vista;

import Modelo.Persona;
import Modelo.Vehiculo;
import Modelo.Venta;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    public final static int RVENTA = 1;
    public final static int LVEHICULOSDIS = 2;
    public final static int LVEHICULOSAGO= 3;
    public final static int VENTAS = 4;
    public final static int SALIR = 5;
    private Scanner lector;

    public UI() {
        lector = new Scanner(System.in).useDelimiter("\n");
    }

    public int mostrarMenu(){
        System.out.println("Seleccione una de las opciones:\n" +
                "1. Realizar una venta.\n" +
                "2. Listar los vehículos disponibles.\n" +
                "3. Listar vehículos agotados.\n" +
                "4. Consultar las ventas a un cliente.\n" +
                "5. Salir.\n");
        return lector.nextInt();
    }

    public int pedirVehiculo(ArrayList<Vehiculo> lista){
        System.out.println("Seleccione un vehiculo: ");
        mostrarVehiculosDisponibles(lista);
        return lector.nextInt();
    }

    public void mostrarVehiculosDisponibles(ArrayList<Vehiculo> lista){
        System.out.println(lista);
    }

    public int mostrarClientes(ArrayList<Persona> personas) {
        System.out.println(personas);
        return lector.nextInt();
    }

    public void mostrarVehiculosAgotados(ArrayList<Vehiculo> lista) {
        System.out.println(lista);
    }

    public void mostrarVentasCliente(ArrayList<Venta> lista){
        System.out.println(lista);
    }
}
