package com.politecnicomalaga.UI;

import com.politecnicomalaga.Controlador.ControladorMensajes;
import com.politecnicomalaga.Controlador.ControladorSesiones;
import com.politecnicomalaga.DataTransfer.DataTransfer;
import com.politecnicomalaga.Modelo.Credencial;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class InicioSesion extends JDialog{
    private JPanel panelInicioSesion,panelAcceder;
    private JLabel lblAcceder,lblUsuario,lblPassword;
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnAceptar;
    private JPanel panelActions;
    private ControladorMensajes controlador;
    private ControladorSesiones sesion;
    private MultiPanel multiPanel;

    public InicioSesion(MultiPanel multiPanel, ControladorSesiones sesion, ControladorMensajes controlador){
        this.controlador = controlador;
        this.sesion = sesion;
        this.multiPanel = multiPanel;
        setContentPane(panelInicioSesion);
        setModal(true);
        getRootPane().setDefaultButton(btnAceptar);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (SQLException | NoSuchAlgorithmException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        panelInicioSesion.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        setLocationRelativeTo(SwingUtilities.getRoot(null));
        pack();
        setVisible(true);
    }

    private void onOK() throws SQLException, NoSuchAlgorithmException, IOException {
        DataTransfer datos = new DataTransfer();
        if (controlador.usuarioExiste(txtUsuario.getText())){
            sesion.setPropiedad("nickname",txtUsuario.getText());
            sesion.guardar();
            Credencial credencial = controlador.getCredencialByName(sesion.getPropiedad("nickname"));
            datos.put("password",txtPassword.getText());
            datos.put("credential",credencial);
            if (controlador.comprobarPassword(datos)){
                multiPanel.notificarCambio(MultiPanel.LECTURA);
                dispose();
            } else {
                System.out.println("Password incorrecto");
            }
        } else {
            System.out.println("Usuario incorrecto");
        }
    }

    private void onCancel(){
        dispose();
        System.exit(0);
    }
}
