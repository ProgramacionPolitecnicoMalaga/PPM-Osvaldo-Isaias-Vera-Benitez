package com.politecnicomalaga;

import com.politecnicomalaga.controlador.ControladorItem;
import com.politecnicomalaga.vista.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws SQLException {
        ControladorItem controlador = new ControladorItem();
        JFrame frame = new JFrame("Custom Rendering"); // Marco de la aplicación.
        frame.setContentPane(new VentanaPrincipal(controlador).getPanel()); // Alturas: nombre del Form enmarcado y de su clase correspondiente.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height - 200;
        int width = 500;
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width,200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
