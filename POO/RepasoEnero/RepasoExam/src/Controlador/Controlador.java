package Controlador;

import Modelo.Venta;
import Vista.UI;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Controlador {
    private UI ui;
    private Manager mgr;

    public Controlador() throws IOException, ParserConfigurationException {
        ui = new UI();
        mgr = new Manager();
        runInterface();
    }

    public void runInterface(){
        int opcion = 0;
        int optCliente;
        int optVehiculo;
        while (opcion != UI.SALIR){
            opcion = ui.mostrarMenu();
            switch (opcion){
                case UI.RVENTA:
                    optVehiculo = ui.pedirVehiculo(mgr.getParqueVehiculos().getVehiculosConStock());
                    optCliente = ui.mostrarClientes(mgr.getPersonas());
                    mgr.getVentas().addVenta(new Venta(mgr.getPersonas().get(optCliente),mgr.getParqueVehiculos().getVehiculosConStock().get(optVehiculo)));
                    mgr.getParqueVehiculos().actualizarCantidades(mgr.getVentas().getListaVentas());
                    break;
                case UI.LVEHICULOSDIS:
                    ui.mostrarVehiculosDisponibles(mgr.getParqueVehiculos().getVehiculosConStock());
                    break;
                case UI.LVEHICULOSAGO:
                    ui.mostrarVehiculosAgotados(mgr.getParqueVehiculos().getVehiculosSinStock());
                    break;
                case UI.VENTAS:
                    optCliente = ui.mostrarClientes(mgr.getPersonas());
                    ui.mostrarVentasCliente(mgr.getVentas().getVentasPersona(mgr.getPersonas().get(optCliente).getNombreApellido()));
                    break;
            }
        }
    }
}
