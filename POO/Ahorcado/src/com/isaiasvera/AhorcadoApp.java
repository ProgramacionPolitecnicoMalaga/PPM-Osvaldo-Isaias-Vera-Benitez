package com.isaiasvera;
import java.util.Scanner;
public class AhorcadoApp {
    static private String[] adivinar1;
    static private String[] adivinar2;
    static private String palabra;
    static private int tam = -1;
    static private int con = 0;
    static private int vidas = 5;
    static private String letrasIntroducidas = "";

    static void inicializar (String[] palabra){
        for (int c = 0; c<adivinar1.length; c++){
            palabra[c] = " _ ";
        }
    }

/*    static void mostrarIntroducidas(){
        System.out.println("Letras introducidas: " + letrasIntroducidas);
    }

    static void letraIntroducida(String temp){
        if (letrasIntroducidas.equals("")){
            letrasIntroducidas += temp;
        }
        int tmp = letrasIntroducidas.length();
        for (int c = 0; c <= tmp; c++){
            if (!temp.equals(letrasIntroducidas.charAt(c))){
                letrasIntroducidas += temp;
            }
        }
    }*/

    static int tamanoPalabra(String palabra) {
        return palabra.length();
    }

    static void menu1() {
        System.out.println("Introduce la palabra a adivinar");
    }

    static void menu2() {
        System.out.println("Introduce letra");
    }

    static void buscarLetraEnPalabra(String temp1) {
        for (int c = 0; c < tam; c++){
            if (temp1.equals(adivinar1[c])){
                adivinar2[c] = temp1;
                con++;
            }
        }
    }
    static void comprobarLetraEnPalabra(String temp1){
        boolean esta = false;
        for (int c = 0; c < tam; c++){
            if (temp1.equals(adivinar1[c])){
                esta = true;
            }
        }
        if (temp1.equals("")){
            esta = true;
        }
        if (!esta){
            vidas--;
        }
    }
    static void mostrarAdivinados(){
        for (int c = 0; c < tam; c++){
            System.out.print(adivinar2[c]);
        }
        System.out.println();
    }
    static void mostrarVidas(){
        System.out.println("Vidas: " + vidas);
    }
    static boolean juegoTerminado(){
        boolean terminado = false;
        if (con == tam){
            terminado = true;
            System.out.println("Ganador");
        } else if (vidas == 0){
            terminado = true;
            System.out.println("Perdedor");
        }
        return terminado;
    }
    public static void main(String[] args) {
        String temp1 = "";
        Scanner lector = new Scanner(System.in);
        menu1();
        palabra = lector.nextLine();
        tam = tamanoPalabra(palabra);
        adivinar1 = new String[tam];
        adivinar1 = palabra.split("");
        adivinar2 = new String[tam];
        inicializar(adivinar2);

        while (!juegoTerminado()){
            menu2();
            mostrarVidas();
            temp1 = lector.nextLine();
//            letraIntroducida(temp1);
            comprobarLetraEnPalabra(temp1);
            buscarLetraEnPalabra(temp1);
            mostrarAdivinados();
//            mostrarIntroducidas();
        }
    }
}
