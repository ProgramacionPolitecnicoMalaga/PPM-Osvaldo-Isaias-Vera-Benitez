package com.politecnicomalaga.modelo;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ItemPanel extends JPanel implements ListCellRenderer<Item> {

    private JLabel lblAutor;
    private JLabel lblFecha;
    private JLabel lblTema;
    private JTextArea txtAreaTexto;
    public ItemPanel(){
        setOpaque(true);

        //setMinimumSize(new Dimension(100,100));
        setLayout(new BorderLayout(10,10));

        lblAutor = new JLabel();
        lblFecha = new JLabel();
        lblTema = new JLabel();
        txtAreaTexto = new JTextArea();
        txtAreaTexto.setWrapStyleWord(true);
        txtAreaTexto.setLineWrap(true);

        Border margenAutorFechaTema = new EmptyBorder(5,10,5,10);
        Border margenTexto = new EmptyBorder(0,10,20,10);
        lblAutor.setBorder(margenAutorFechaTema);
        lblFecha.setBorder(margenAutorFechaTema);
        lblTema.setBorder(margenAutorFechaTema);
        txtAreaTexto.setBorder(margenTexto);

        add(lblAutor, BorderLayout.PAGE_START);
        add(lblTema, BorderLayout.WEST);
        add(txtAreaTexto, BorderLayout.SOUTH);
        add(lblFecha, BorderLayout.EAST);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Item> jList, Item item, int i, boolean isSelected, boolean cellHasFocus) {
        lblTema.setOpaque(true);
        lblAutor.setText(item.getAutor());
        lblFecha.setText(item.getFecha().toString());
        lblTema.setText(item.getTema());
        txtAreaTexto.setText(item.getTexto());
        txtAreaTexto.setSize(jList.getWidth(),Short.MAX_VALUE);

        if (isSelected){
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(Color.WHITE);
        }

        if (cellHasFocus){
            txtAreaTexto.setFont(new Font("SansSerif",Font.BOLD,12));
            txtAreaTexto.setBackground(Color.LIGHT_GRAY);
            lblTema.setBackground(selectorColorTema(item.getTema()));
        } else {
            txtAreaTexto.setFont(new Font("SansSerif",Font.PLAIN,10));
            txtAreaTexto.setBackground(Color.WHITE);
            lblTema.setBackground(Color.WHITE);
        }

        return this;
    }

    private Color selectorColorTema(String tema){
        Color color = null;
        switch (tema) {
            case "IT":
                color = new Color(0, 128, 0);
                break;
            case "Desarrollo":
                color = new Color(52, 152, 235);
                break;
            case "Mantenimiento":
                color = new Color(184, 114, 22);
                break;
            case "General":
                color = new Color(135, 135, 135);
                break;
        }
        return color;
    }
}
