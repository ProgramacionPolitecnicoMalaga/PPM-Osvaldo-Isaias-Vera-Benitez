package com.politecnicomalaga;

import com.politecnicomalaga.Modelo.LoteDeProductos;
import com.politecnicomalaga.Criterios.Criterio;
import com.politecnicomalaga.Criterios.SelectorDeMejorProducto;
import com.politecnicomalaga.Factory.CriterioFactory;
import com.politecnicomalaga.Modelo.Producto;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        init();
        Scanner lector = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Selecciona un criterio:\n" +
                "1. Mejor Valorado.\n" +
                "2. Más Barato.\n" +
                "3. Mejor relación valoración/precio.");
        int eleccion = lector.nextInt();
        SelectorDeMejorProducto selector = CriterioFactory.getCriterio(eleccion);
        Criterio criterio = new Criterio();
        criterio.setSelectorDeMejorProducto(selector);
        System.out.println(criterio.getProductoSegunCriterio());
    }

    private static void init() {
        LoteDeProductos productos = LoteDeProductos.getInstance();
        Producto p1 = new Producto("OnePlus 7T",650.00, 4.1);
        Producto p2 = new Producto("Lenovo",500, 3.7);
        Producto p3 = new Producto("Asus",1000.00, 4.9); //mejor valorado
        Producto p4 = new Producto("Xiaomi",200.00, 4.7); //valoracion precio
        Producto p5 = new Producto("Apple",10000.00, 3);
        Producto p6 = new Producto("Blue",150, 3.5); //más barato
        productos.addProducto(p1);
        productos.addProducto(p2);
        productos.addProducto(p3);
        productos.addProducto(p4);
        productos.addProducto(p5);
        productos.addProducto(p6);
    }
}
