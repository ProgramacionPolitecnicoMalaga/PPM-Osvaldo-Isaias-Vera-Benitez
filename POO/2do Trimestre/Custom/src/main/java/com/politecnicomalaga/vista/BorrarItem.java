package com.politecnicomalaga.vista;

import javax.swing.*;
import java.awt.event.*;

public class BorrarItem extends JDialog{
    private JPanel pnlBorrarItem,pnlTitulo, pnlValues1, pnlValues2, pnlActions;
    private JLabel lblTitulo, lblAutor, lblTema;
    private JTextField txtAutor,txtTema, txtTexto;
    private JButton btnBorrar,btnCancelar;
    private boolean aceptaBorrar = false;

    public BorrarItem(){
        setContentPane(pnlBorrarItem);
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
        pnlBorrarItem.registerKeyboardAction(new ActionListener() {
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

    public boolean borrar(String titulo, String tema, String texto){
        txtAutor.setText(titulo);
        txtTema.setText(tema);
        txtTexto.setText(texto);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        dispose();
        return aceptaBorrar;
    }
}
