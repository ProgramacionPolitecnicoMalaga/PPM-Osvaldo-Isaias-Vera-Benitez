package com.isaiasvera;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.BufferedReader;
import java.text.Normalizer;
import java.text.Normalizer.Form;

public class Productos {
    private final static int POSICION = 0, NOMBRE = 1, TIPO = 2, CANTIDAD = 3, PRECIO = 4;
    private JPanel panelMain;
    private JLabel Búsqueda;
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JTextArea txtResultado;
    private File file = new File("./productos.csv");
    private BufferedReader bReader;
    private String[] producto;
    private String delimeter = ";";


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
        int c = 0;
        boolean encontrado = false;

        while (!encontrado && c<producto.length){
            if (tieneDiacriticos(palabraABuscar)){
                if (producto[c].toLowerCase().contains(palabraABuscar.toLowerCase())){
                    mostrar();
                    encontrado = true;
                } else {
                    c++;
                }
            } else {
                if (palabraEncontrada(c,palabraABuscar)){
                    mostrar();
                    encontrado = true;
                } else {
                    c++;
                }
            }
        }
    }

    private boolean tieneDiacriticos (String temp){
        boolean tiene = false;
        String[] palabra;
        palabra = temp.split("");
        for (String esto: palabra) {
            if (esto.matches("[À-ž]")){
                tiene = true;
            }
        }
        return tiene;
    }

    private boolean palabraEncontrada(int c, String palabraABuscar){
        boolean esta = false;
        if (producto[c].toLowerCase().contains("ñ")){
            if (normalizarSinN(c).contains(palabraABuscar.toLowerCase())){
                esta = true;
            }
        }else {
            if (removeAccents(producto[c]).toLowerCase().contains(palabraABuscar.toLowerCase())){
                esta = true;
            }
        }
        return esta;
    }

    private String normalizarSinN(int c){
        int pos;
        String temp, ene;
        pos = producto[c].indexOf("ñ");
        temp = removeAccents(producto[c].toLowerCase());
        ene = temp.substring(0,pos) + "ñ" + temp.substring(pos+1);
        return ene;
    }

    private String removeAccents(String text) {
        return text == null ? null : Normalizer.normalize(text, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    private void mostrar(){
        txtResultado.append(producto[NOMBRE] + ", " + producto[TIPO] + ", " + producto[CANTIDAD] + ", " + producto[PRECIO] + "\n");
    }

}
