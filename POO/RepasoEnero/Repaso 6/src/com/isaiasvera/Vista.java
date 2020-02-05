package com.isaiasvera;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Vista {
    public final static int NUEVOV = 1;
    public final static int NUEVOC = 2;
    public final static int VENTAC = 3;
    public final static int COMPRAC = 4;
    public final static int SALDO = 5;
    public final static int TERMINAR = 6;

    private Scanner lector;

    public Vista(){
        lector = new Scanner(System.in).useDelimiter("\n");
    }

    public int menuInicial(){
        System.out.println("Seleccciona una opción:\n" +
                "1- Introducir un nuevo vehículo.\n" +
                "2- Introducir un nuevo cliente.\n" +
                "3- Realizar una venta a un cliente.\n" +
                "4- Realizar una compra a un cliente.\n" +
                "5- Obtener el saldo total de un cliente que ha realizado ventas/compras en el concesionario.\n" +
                "6- Terminar.");
        return lector.nextInt();
    }

    public String askModelo() {
        System.out.println("Introduce el modelo del vehiculo:");
        return lector.next();
    }

    public String askMarca() {
        System.out.println("Introduce la marca del vehiculo:");
        return lector.next();
    }

    public String askColor() {
        System.out.println("Introduce el color del vehiculo:");
        return lector.next();
    }

    public String askMatricula() {
        System.out.println("Introduce la matricula del vehiculo:");
        return lector.next();
    }

    public int askCombustion() {
        int temp;
        System.out.println("Selecciona el tipo de combustión:\n" +
                "21. Gasoil\n" +
                "22. Gasolina");
        temp = lector.nextInt();
        System.out.println(temp);
        if (temp > 20 && temp < 23)
            return temp;
        else System.out.println("Opción incorrecta.");
            return askCombustion();
    }

    public int askEstado() {
        int temp;
        System.out.println("Selecciona el estado del vehiculo:\n" +
                "1. Usado\n" +
                "2. Nuevo");
        temp = lector.nextInt();
        if (temp > 0 && temp < 3)
            return temp;
        else System.out.println("Opción incorrecta.");
            return askEstado();
    }

    public LocalDate askDate() {
        System.out.println("Introduce el año de fabricación (dd-mm-yyyy):");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(lector.next(),format);
    }

    public double askPrecio() {
        System.out.println("Introduce el precio de venta:");
        return lector.nextDouble();
    }

    public void showVehiculos(ArrayList<Vehiculo> vehiculos){
        if (!vehiculos.isEmpty()){
            System.out.println("Lista de vehiculos:");
            for (Vehiculo ve : vehiculos){
                System.out.println(vehiculos.indexOf(ve) + ". " + ve);
            }
        } else {
            System.out.println("No hay datos almacenados");
        }
    }

    public String askNombre() {
        System.out.println("Introduce el nombre del cliente:");
        return lector.next();
    }

    public String askApellido() {
        System.out.println("Introduce el apellido del cliente:");
        return lector.next();
    }

    public String askNIF() {
        System.out.println("Introduce el NIF del cliente:");
        return lector.next();
    }

    public String askBankAccount() {
        System.out.println("Introduce la cuenta bancaria del cliente:");
        return lector.next();
    }

    public void showClientes(ArrayList<Cliente> clientes){
        if (!clientes.isEmpty()){
            System.out.println("Lista de clientes:");
            for (Cliente cl : clientes){
                System.out.println(clientes.indexOf(cl) + ". " + cl);
            }
        } else {
            System.out.println("No hay datos almacenados.");
        }
    }

    public Vehiculo askVehiculoVenta(ArrayList<Vehiculo> vehiculos) {
        Vehiculo temp = null;
        if (!vehiculos.isEmpty()) {
            System.out.println("Selecciona el vehiculo a vender:");
            showVehiculos(vehiculos);
            temp = vehiculos.get(lector.nextInt());
        } else {
            System.out.println("No hay vehiculos para realizar la operación.");
        }
        return temp;
    }

    public Cliente askClienteVenta(ArrayList<Cliente> clientes) {
        Cliente temp = null;
        if (!clientes.isEmpty()){
            System.out.println("Selecciona el cliente:");
            showClientes(clientes);
            temp = clientes.get(lector.nextInt());
        } else {
            System.out.println("No hay clientes para realizar la operación.");
        }
        return temp;
    }

    public void showCompraVenta(ArrayList<CompraVenta> comprasVentas) {
        if (!comprasVentas.isEmpty()){
            for (CompraVenta cv : comprasVentas){
                System.out.println(comprasVentas.indexOf(cv) + ". " + cv);
            }
        } else {
            System.out.println("No hay datos almacenados.");
        }
    }

    public Cliente askClienteSaldo(ArrayList<Cliente> clientes) {
        showClientes(clientes);
        return clientes.get(lector.nextInt());
    }
}
