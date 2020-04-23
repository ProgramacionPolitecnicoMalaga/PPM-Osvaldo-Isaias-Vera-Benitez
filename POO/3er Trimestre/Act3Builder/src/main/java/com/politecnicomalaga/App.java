package com.politecnicomalaga;

import com.politecnicomalaga.Servicio.Servicio;
import com.politecnicomalaga.Builder.ServicioBuilder;
import com.politecnicomalaga.Builder.ServicioDirector;

import java.util.Scanner;

public class App {
    public static Servicio servicio;
    public static void main(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Elija un pack:\n" +
                "1. Pack básico\n" +
                "2. Pack romance\n" +
                "3. Pack familiar\n" +
                "4. Pack padres relajados\n" +
                "5. Pack deluxe\n" +
                "6. Pack deluxe familiar\n");

        int pack = lectorTeclado.nextInt();

        ServicioBuilder servicioBuilder = new ServicioBuilder();
        ServicioDirector servicioDirector = new ServicioDirector(servicioBuilder);

        switch (pack){
            case 1:
                servicio = servicioDirector.packBasico();
                break;
            case 2:
                servicio = servicioDirector.packRomance();
                break;
            case 3:
                servicio = servicioDirector.packFamiliar();
                break;
            case 4:
                servicio = servicioDirector.packPadresRelajados();
                break;
            case 5:
                servicio = servicioDirector.packDeluxe();
                break;
            case 6:
                servicio = servicioDirector.packDeluxeFamiliar();
                break;
        }

        System.out.println(servicio);
    }
}
