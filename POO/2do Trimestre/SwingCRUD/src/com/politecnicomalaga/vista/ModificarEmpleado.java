package com.politecnicomalaga.vista;

import javax.swing.*;
import java.awt.event.*;

public class ModificarEmpleado extends JDialog{
    private JPanel pnlModificarEmp, pnlTitulo, pnlDatosActuales, pnlDatosNuevos, pnlActions;
    private JLabel lblTitulo, lblTitulo2, lblNombre1, lblEdad1, lblTitulo3, lblNombre2, lblEdad2;
    private JButton btnAceptar, btnCancelar;
    private JTextField txtNombre, txtEdad, txtNombreNuevo, txtEdadNuevo;
    private String nombre,edad;

    public ModificarEmpleado(){
        setContentPane(pnlModificarEmp);
        setModal(true);
        getRootPane().setDefaultButton(btnAceptar);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
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
        pnlModificarEmp.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        nombre = txtNombreNuevo.getText();
        edad = txtEdadNuevo.getText();
        setVisible(false);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public String[] getDatos(int idAct, String nombreOld, int edadOld){
        txtNombre.setText(nombreOld);
        txtEdad.setText(String.valueOf(edadOld));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        dispose();
        return new String[]{String.valueOf(idAct),nombre,edad};
    }
}
