package com.politecnicomalaga.UI;

import com.politecnicomalaga.Controlador.ControladorMensajes;
import com.politecnicomalaga.Controlador.ControladorSesiones;
import com.politecnicomalaga.DataTransfer.DataTransfer;
import com.politecnicomalaga.Modelo.Credencial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class VistaEscritura {
    private JPanel panelEscritura,panelMensaje,panelActions;
    private JButton btnEnviar;
    private JComboBox cbDestinatarios;
    private JLabel lblTitulo;
    private JTextField txtTitulo;
    private JTextArea txtMensaje;
    private ControladorMensajes conMensajes;
    private DataTransfer datos;

    public VistaEscritura(MultiPanel multiPanel, ControladorMensajes conMensajes, ControladorSesiones conSesiones) {
        this.conMensajes = conMensajes;
        datos = new DataTransfer();

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datos.put("destinatario",conMensajes.getCredencialByName((String) cbDestinatarios.getSelectedItem()).getId());
                datos.put("remitente",conMensajes.getCredencialByName(conSesiones.getPropiedad("nickname")).getId());
                datos.put("titulo",txtTitulo.getText());
                datos.put("texto",txtMensaje.getText());
                datos.put("enviado",true);
                try {
                    conMensajes.addMensaje(datos);
                    multiPanel.notificarCambio(MultiPanel.LECTURA);
                } catch (SQLException | NoSuchAlgorithmException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        panelEscritura.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                cargarDestinatarios();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                cbDestinatarios.removeAllItems();
                txtTitulo.setText("");
                txtMensaje.setText("");
            }
        });
    }

    public void cargarDestinatarios(){
        for (Credencial c : conMensajes.getUsuarios()){
            cbDestinatarios.addItem(c.getName());
        }
    }

    public JPanel getPanel(){
        return panelEscritura;
    }
}
