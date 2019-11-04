package com.isaiasvera;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.BufferedReader;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.HashMap;

public class Productos {
    private final static int POSICION = 0;
    private final static int NOMBRE = 1;
    private final static int TIPO = 2;
    private final static int CANTIDAD = 3;
    private final static int PRECIO = 4;
    private JPanel panelMain;
    private JLabel Búsqueda;
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JTextArea txtResultado;
    private File file = new File("./productos.csv");
    private BufferedReader bReader;
    private String[] producto;
    private String delimeter = ";";

    private String removeAccents(String text) {
        return text == null ? null : Normalizer.normalize(text, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public Productos() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText("");
                String linea;
                String palabraABuscar;
                try {
                    bReader = new BufferedReader(new FileReader(file));
                    while ((linea = bReader.readLine()) != null) {
                        producto = linea.split(delimeter);
                        palabraABuscar = txtBuscar.getText();
                        if (!palabraABuscar.equals("")){
                            buscar(palabraABuscar);
                        }
                    }
                } catch (IOException a){
                    a.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Productos");
        frame.setContentPane(new Productos().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void buscar(String palabraABuscar){
        int encontrado = 0;
        for (int c = 0; c < producto.length; c++){
            if (encontradoEnProducto(normalizarPalabraBusqueda(palabraABuscar), normalizarContenido(c))){
                encontrado++;
            }
        }
        if (encontrado > 0){
            txtResultado.append(producto[NOMBRE] + ", " + producto[TIPO] + ", " + producto[CANTIDAD] + ", " + producto[PRECIO] + "\n");
        }
    }

    private boolean encontradoEnProducto(String palabraNormalizada, String normalizarContenido){
        boolean esta = false;
        if (normalizarContenido.contains(palabraNormalizada)){
            esta = true;
        }
        return esta;
    }

    private String normalizarPalabraBusqueda(String palabraABuscar){
        String palabraNormalizada;
        if (palabraABuscar.toLowerCase().contains("ñ")){
            palabraNormalizada = palabraABuscar;
        } else {
            palabraNormalizada = removeAccents(palabraABuscar.toLowerCase());
        }
        return palabraNormalizada;
    }

    private String normalizarContenido(int c){
        String temp, normalizar;
        int posicion;
        char especial = 'ñ';
        if (producto[c].toLowerCase().contains("ñ")){
            posicion = producto[c].indexOf("ñ");
            temp = removeAccents(producto[c].toLowerCase());
            normalizar = temp.substring(0,posicion) + especial + temp.substring(posicion+1);
        } else {
            normalizar = removeAccents(producto[c].toLowerCase());
        }
        return normalizar;
    }

}
