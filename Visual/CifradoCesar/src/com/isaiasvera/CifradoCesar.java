package com.isaiasvera;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CifradoCesar {
    private JPanel panelMain;
    private JLabel Desplazamiento;
    private JTextField txtDesplazamiento;
    private JButton btnSeleccionar;
    private JLabel Codificar;
    private JTextField txtCodificar;
    private JButton btnCodificar;
    private JLabel Codificado;
    private JTextField txtCodificado;
    private JButton btnReset;
    static int n = -1;
    public final static int ABC = 27;
    static char[] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private String abc;

    public CifradoCesar() {
        btnSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtDesplazamiento.getText().equals("") && txtDesplazamiento.getText().matches("[0-9]*")) {
                    n = Integer.parseInt(txtDesplazamiento.getText());
                    btnSeleccionar.setEnabled(false);
                    txtDesplazamiento.setEnabled(false);
                }
            }
        });
        btnCodificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtCodificar.getText().equals("")) {
                    abc = txtCodificar.getText();
                    txtCodificado.setText(codificar(abc.toLowerCase()));
                }
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSeleccionar.setEnabled(true);
                txtDesplazamiento.setEnabled(true);
                txtCodificar.setText("");
                txtCodificado.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CifradoCesar");
        frame.setContentPane(new CifradoCesar().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static String codificar(String texto) {
        String temp1 = "";
        char temp2, temp3;
        int pos;
        for (int c = 0; c < texto.length(); c++) {
            temp2 = texto.charAt(c);
            if (temp2 != 32){
                pos = posicionEnABC(temp2);
                temp3 = abecedario[(pos + n) % ABC];
                temp1 += temp3;
            } else {
                temp1 += " ";
            }
        }
        return temp1;
    }

    static int posicionEnABC(char ch) {
        int temp = -1;
        for (int c = 0; c < ABC; c++) {
            if (ch == abecedario[c]) {
                temp = c;
            }
        }
        return temp;
    }
}
