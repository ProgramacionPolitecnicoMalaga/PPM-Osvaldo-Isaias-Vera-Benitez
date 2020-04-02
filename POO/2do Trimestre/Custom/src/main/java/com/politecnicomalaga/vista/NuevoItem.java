package com.politecnicomalaga.vista;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Objects;

public class NuevoItem extends JDialog{
    private JPanel pnlNuevoItem, pnlTitulo, pnlValues1, pnlValues2;
    private JLabel lblTitulo, lblAutor, lblTema;
    private JTextField txtAutor, txtTexto;
    private JComboBox cbTema;
    private JPanel pnlActions;
    private JButton btnAceptar, btnCancelar;
    private String autor, texto, fecha, tema;

    public NuevoItem() {
        setContentPane(pnlNuevoItem);
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
        pnlNuevoItem.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        autor = txtAutor.getText();
        texto = txtTexto.getText();
        fecha = getFecha();
        tema = getTema();
        setVisible(false);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public String[] getDatos(String[] temas){
        generarListaTemas(temas);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        dispose();
        return new String[]{autor,fecha,texto,tema};
    }

    private String getTema() {
        return Objects.requireNonNull(cbTema.getSelectedItem()).toString();
    }

    private String getFecha() {
        return LocalDate.now().toString();
    }

    public void generarListaTemas(String[] temas){
        cbTema.insertItemAt("",0);
        cbTema.setSelectedIndex(0);
        for (String str : temas){
            cbTema.addItem(str);
        }
    }
}
