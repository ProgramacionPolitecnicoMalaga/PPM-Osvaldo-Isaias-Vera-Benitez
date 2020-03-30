package com.politecnicomalaga.vista;

import javax.swing.*;
import java.awt.event.*;

public class BorrarEmpleado extends JDialog{
    private JPanel pnlBorrarEmp, pnlCentral, pnlActions;
    private JLabel lblTitulo, lblNombre, lblEdad;
    private JButton btnBorrar, btnCancelar;
    private JTextField txtNombre, txtEdad;
    private boolean aceptaBorrar = false;

    public BorrarEmpleado(){
        setContentPane(pnlBorrarEmp);
        setModal(true);
        getRootPane().setDefaultButton(btnBorrar);

        btnBorrar.addActionListener(new ActionListener() {
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
        pnlBorrarEmp.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        aceptaBorrar = true;
        setVisible(false);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public boolean borrar(String nombreOld, int edadOld){
        txtNombre.setText(nombreOld);
        txtEdad.setText(String.valueOf(edadOld));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        dispose();
        return aceptaBorrar;
    }
}
