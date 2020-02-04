package com.isaiasvera;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Manager mgr = new Manager();
        Vista vista = new Vista();
        int opcion = vista.menuInicial();
        while(opcion != Vista.TERMINAR){
            switch (opcion){
                case Vista.NUEVOV:
                    String marca = vista.askMarca();
                    String modelo = vista.askModelo();
                    String color = vista.askColor();
                    String matricula = vista.askMatricula();
                    int combustion = vista.askCombustion();
                    int estado = vista.askEstado();
                    LocalDate fabDate = vista.askDate();
                    double precio = vista.askPrecio();
                    try{
                        mgr.addVehiculo(new Vehiculo(modelo,marca,color,matricula,combustion,estado,fabDate,precio));
                        vista.showVehiculos(mgr.getVehiculos());
                    } catch (VehiculoException ve){
                        ve.printStackTrace();
                    }
                    break;
                case Vista.NUEVOC:
                    String nombre = vista.askNombre();
                    String apellido = vista.askApellido();
                    String nif = vista.askNIF();
                    String bank = vista.askBankAccount();
                    try{
                        mgr.addCliente(new Cliente(nombre,apellido,nif, bank));
                        vista.showClientes(mgr.getClientes());
                    } catch (ClienteException ce){
                        ce.printStackTrace();
                    }
                    break;
                case Vista.VENTAC:
                    break;
                case Vista.COMPRAC:
                    break;
                case Vista.SALDO:
                    break;
                case 7:
                    vista.showVehiculos(mgr.getVehiculos());
                    break;
                case 8:
                    vista.showClientes(mgr.getClientes());
                default:
                    System.out.println("Opción incorrecta");
            }
            opcion = vista.menuInicial();
        }
    }
}
