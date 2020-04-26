package com.politecnicomalaga;

import com.politecnicomalaga.Controlador.ControladorMensajes;
import com.politecnicomalaga.UI.Principal;

import javax.swing.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws IOException, SQLException, NoSuchAlgorithmException {
        ControladorMensajes controlador = new ControladorMensajes();
        JFrame frame = new JFrame("Mensajes");
        frame.setContentPane(new Principal(controlador).getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
