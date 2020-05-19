package com.politecnicomalaga.UI;

import com.politecnicomalaga.composite.Paquete;
import com.politecnicomalaga.composite.Producto;
import com.politecnicomalaga.composite.Servicio;
import com.politecnicomalaga.controlador.Controlador;

import java.util.List;
import java.util.Scanner;

public class UI {
    public static final int ANADIR = 1;
    public static final int BORRAR = 2;
    public static final int SETPRECIO = 3;
    public static final int GETPRECIO = 4;
    private Scanner lector;
    private int opcion = -1;
    Controlador controlador;
    private int llamadas = 0;
    StackTraceElement[] sts;


    public UI(){
        controlador = new Controlador();
        lector = new Scanner(System.in).useDelimiter("\n");
        run();
    }

    private void run() {
        while (opcion != 5){
            switch (menu()){
                case ANADIR:
                    controlador.addServicio(introNombreServicio(),esPaquete());
                    if (cerrarPaquete())
                        controlador.cerrar();
                    break;
                case BORRAR:
                    Paquete padre = (Paquete) controlador.getServiciofinal();
                    System.out.println(padre.getNombre());
                    mostrarTodosLosServicios(padre.getHijos());
                    System.out.println(llamadas);
                    controlador.borrarServicio(borrarMenu());
                    break;
                case SETPRECIO:
                    break;
                case GETPRECIO:
                    break;
                default:
                    throw new IllegalArgumentException("Opcion no se corresponde.");
            }
        }
    }

    public void mostrarTodosLosServicios(List<Servicio> servicios) {
        llamadas++;
        int posServicio = 0;
        int numPaquete = 0;
        for (Servicio s : servicios){
            if (s.esPaquete()){
                //
                Paquete paquete = (Paquete) s;
                System.out.println(numPaquete +". "+((Paquete) s).getNombre() + "(Paquete)");
                mostrarTodosLosServicios(paquete.getHijos());
                numPaquete++;
            } else {
                Producto producto = (Producto) s;
                System.out.println("\t"+ posServicio +". "+producto.getNombre() + "(Producto)");
                posServicio++;
            }
        }
    }

    public int[] borrarMenu(){
        System.out.println("Selecciona el numero de servicio que quieras eliminar por orden: ");
        int[] posiciones = new int[3];
        posiciones[0] = lector.nextInt();
        posiciones[1] = lector.nextInt();
        posiciones[2] = lector.nextInt();
        return posiciones;
    }

    public int menu(){
        System.out.println("\nSelecciona una opción: \n" +
                "1. Añadir servicio.\n" +
                "2. Borrar servicio.\n" +
                "3. Asignar precio.\n" +
                "4. Obtener precio.\n" +
                "5. Salir");
        return opcion = lector.nextInt();
    }

    public String introNombreServicio(){
        System.out.println("Por favor escribe el nombre del servicio: ");
        return lector.next();
    }

    public boolean esPaquete(){
        System.out.println("Es un paquete?\n"+ "1. Sí.\n" + "2. No.");
        return lector.nextInt() == 1;
    }

    public boolean cerrarPaquete(){
        System.out.println("Deseas cerrar el paquete?\n"+ "1. Sí.\n" + "2. No.");
        return lector.nextInt() == 1;
    }



}

/*

public void mostrarTodosLosServicios(List<Servicio> servicios) {
        for (Servicio s : servicios){
            if (s.esPaquete()){
                numPaquete++;
                Paquete paquete = (Paquete) s;
                System.out.println(posServicio +". "+((Paquete) s).getNombre() + "(Paquete " + numPaquete + ")");
                mostrarTodosLosServicios(paquete.getHijos());
            } else {
                posServicio++;
                Producto producto = (Producto) s;
                System.out.println(posServicio +". "+producto.getNombre() + "(Producto)");
            }
        }
    }

 */