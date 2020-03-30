package com.politecnicomalaga.vista;

import javax.swing.*;
import java.awt.event.*;

public class NuevoEmpleado extends JDialog{
    private JPanel pnlNuevoEmp, pnlTitulo, pnlToFill, pnlActions;
    private JLabel lblTitulo, lblNombre, lblEdad;
    private JTextField txtNombre, txtEdad;
    private JButton btnAceptar, btnCancelar;
    private String edad, nombre;

    public NuevoEmpleado(){
        setContentPane(pnlNuevoEmp);
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
        pnlNuevoEmp.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        nombre = txtNombre.getText();
        edad = txtEdad.getText();
        setVisible(false);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public String[] getDatos(){
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        dispose();
        return new String[]{nombre,edad};
    }
}
