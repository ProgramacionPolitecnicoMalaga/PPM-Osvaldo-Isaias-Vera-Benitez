package com.isaiasvera;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class Tirada {
    private JPanel panelMain, panelAppTitle, panelImage, panelActions, panelStats, panelNTiradas, panelCara, panelCruz;
    private JButton btnTirar, btnRepetir, btnLimpiar;
    private JLabel Titulo1, labelTotalTiradas, labelTotalCara, labelTotalCruz, labelPorcentajeCara, labelPorcentajeCruz;
    private JFormattedTextField txtNumeroTiradas;
    private JTextField txtTotalTiradas, txtTotalCara, txtTotalCruz, txtPorcentajeCara, txtPorcentajeCruz;
    private int contadorTiradas = 0, contadorCara = 0, contadorCruz = 0;
    private double porcentajeCara = 0.0, porcentajeCruz = 0.0;


    public Tirada() throws IOException {
        BufferedImage coinhead, cointail, allAtOnce;
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(1);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);
        txtNumeroTiradas.setFormatterFactory(factory);

        coinhead = ImageIO.read(new File("./src/com/isaiasvera/imgs/eurocoinhead.png"));
        cointail = ImageIO.read(new File("./src/com/isaiasvera/imgs/eurocointail.png"));
        allAtOnce = ImageIO.read(new File("./src/com/isaiasvera/imgs/tentado.png"));
        JLabel labelPic = new JLabel();
        ImageIcon iconTail = new ImageIcon(cointail.getScaledInstance(400,400, Image.SCALE_FAST));
        ImageIcon iconHead = new ImageIcon(coinhead.getScaledInstance(400, 400, Image.SCALE_FAST));
        ImageIcon iconAll = new ImageIcon(allAtOnce.getScaledInstance(400, 76, Image.SCALE_FAST));


        panelImage.add(labelPic);

        btnTirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomNumber;
                randomNumber = randomNumber();
                contadorTiradas++;
                if (randomNumber == 0){
                    labelPic.setIcon(iconHead);
                    contadorCara++;
                    txtTotalCara.setText(String.valueOf(contadorCara));
                    calcularPorcentajes();
                } else {
                    labelPic.setIcon(iconTail);
                    contadorCruz++;
                    txtTotalCruz.setText(String.valueOf(contadorCruz));
                    calcularPorcentajes();
                }
                txtTotalTiradas.setText(String.valueOf(contadorTiradas));
//                tirarMoneda (labelPic, iconTail, iconHead, iconAll);
            }
        });
        btnRepetir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalTiradas, random;
                try {
                    totalTiradas = (Integer) txtNumeroTiradas.getValue();
                    contadorTiradas += totalTiradas;
                    labelPic.setIcon(iconAll);
                    txtTotalTiradas.setText(String.valueOf(contadorTiradas));
                    for (int c = 0; c < totalTiradas; c++){
                        random = randomNumber();
                        if (random == 0){
                            contadorCara++;
                            txtTotalCara.setText(String.valueOf(contadorCara));
                            calcularPorcentajes();
                        } else {
                            contadorCruz++;
                            txtTotalCruz.setText(String.valueOf(contadorCruz));
                            calcularPorcentajes();
                        }
                    }
                } catch (NullPointerException ex){
                    System.out.println("Cuadro de número de tiradas vacío.");
                }
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField[] fields = new JTextField[] {txtTotalTiradas, txtTotalCara, txtTotalCruz, txtPorcentajeCara, txtPorcentajeCruz};
                for (JTextField field: fields){
                    field.setText("");
                }
                contadorTiradas = contadorCara = contadorCruz = 0;
                txtNumeroTiradas.setValue(null);
                labelPic.setIcon(null);
            }
        });
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Tirada");
        frame.setContentPane(new Tirada().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private int randomNumber(){
        return new Random().ints(0, 2).findAny().getAsInt();
    }

/*    private void tirarMoneda (JLabel labelPic, ImageIcon iconTail, ImageIcon iconHead, ImageIcon iconAll){
        int randomNumber;
        randomNumber = randomNumber();
        contadorTiradas++;
        if (randomNumber == 0){
            if (txtNumeroTiradas < 1){
                labelPic.setIcon(iconHead);
            }

            contadorCara++;
            txtTotalCara.setText(String.valueOf(contadorCara));
            calcularPorcentajes();
        } else {
            if (txtNumeroTiradas < 1){
                labelPic.setIcon(iconTail);
            }

            contadorCruz++;
            txtTotalCruz.setText(String.valueOf(contadorCruz));
            calcularPorcentajes();
        }
        txtTotalTiradas.setText(String.valueOf(contadorTiradas));
    }*/

    private void calcularPorcentajes (){
        DecimalFormat formato = new DecimalFormat("#.00");

        if (contadorCara != 0){
            porcentajeCara = ((double) contadorCara / (double) contadorTiradas) * 100;
            txtPorcentajeCara.setText(String.valueOf(formato.format(porcentajeCara)));
        } else {
            porcentajeCara = Double.MIN_VALUE;
        }

        if (contadorCruz != 0){
            porcentajeCruz = ((double) contadorCruz / (double) contadorTiradas) * 100;
            txtPorcentajeCruz.setText(String.valueOf(formato.format(porcentajeCruz)));
        } else {
            porcentajeCruz = Double.MIN_VALUE;
        }
    }

}
