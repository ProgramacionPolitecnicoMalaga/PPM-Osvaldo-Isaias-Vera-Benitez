package com.politecnicomalaga.UI;

import com.politecnicomalaga.Controlador.ControladorMensajes;
import com.politecnicomalaga.Controlador.ControladorSesiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class Principal implements MultiPanel{
    private final String LECTURA = "Panel Lectura";
    private final String ESCRITURA = "Panel Escritura";
    private JPanel pnlPrincipal, panelMenu, panelIntercambio;
    private JMenu menuAcciones;
    private JMenuBar menuBar;
    private JMenuItem menuLectura, menuEscritura, menuCerrarSesion;
    private VistaEscritura vistaEscritura;
    private VistaLectura vistaLectura;
    private ControladorMensajes controlador;
    private ControladorSesiones sesion;

    public Principal(ControladorMensajes controlador) throws IOException, SQLException, NoSuchAlgorithmException {
        this.controlador = controlador;
        sesion = new ControladorSesiones();

        menuBar.setVisible(false);
        vistaEscritura = new VistaEscritura(this,controlador,sesion);
        vistaLectura = new VistaLectura(controlador,sesion);

        panelIntercambio.add(vistaEscritura.getPanel(),ESCRITURA);
        panelIntercambio.add(vistaLectura.getPanel(),LECTURA);

        comprobarSesion();

        menuEscritura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notificarCambio(MultiPanel.ESCRITURA);
            }
        });

        menuLectura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notificarCambio(MultiPanel.LECTURA);
            }
        });

        menuCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sesion.borrarDatos();
                    notificarCambio(MultiPanel.LOGIN);
                } catch (IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public JPanel getPanel(){
        return pnlPrincipal;
    }

    @Override
    public void notificarCambio(int cambio){
        CardLayout cardLayout = (CardLayout) panelIntercambio.getLayout();
        switch (cambio){
            case MultiPanel.LECTURA:
                cardLayout.show(panelIntercambio,LECTURA);
                menuBar.setVisible(true);
                break;
            case MultiPanel.ESCRITURA:
                cardLayout.show(panelIntercambio,ESCRITURA);
                break;
            case MultiPanel.LOGIN:
                menuBar.setVisible(false);
                iniciarSesion();
                break;
        }
    }

    public void comprobarSesion(){
        if (sesion.getPropiedad("nickname") != null){
            notificarCambio(MultiPanel.LECTURA);
        }else {
            iniciarSesion();
        }
    }

    public void iniciarSesion(){
        InicioSesion inicioSesion = new InicioSesion(this,sesion,controlador);
    }
}
