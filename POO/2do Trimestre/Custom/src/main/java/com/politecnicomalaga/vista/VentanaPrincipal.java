package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorItem;
import com.politecnicomalaga.modelo.ItemPanel;
import com.politecnicomalaga.modelo.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class VentanaPrincipal {
    private JPanel pnlMain;
    private JButton btnEliminar;
    private JButton btnNuevo;
    private JList lstItems;
    private ControladorItem controlador;
    private DefaultListModel<Item> lstModel;

    public VentanaPrincipal(ControladorItem controlador) throws SQLException {
        this.controlador = controlador;
        lstModel = new DefaultListModel<>();
        //insertarEjemplos();
        actualizarLista(controlador.getItems());



        lstItems.setModel(lstModel);
        lstItems.setCellRenderer(new ItemPanel());

        lstItems.setFixedCellWidth(pnlMain.getWidth());

        lstItems.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Estiramos la celda a 1000 px de altura
                lstItems.setFixedCellHeight(1000);
                // Asignamos el valor -1 para que se recalcule la altura
                lstItems.setFixedCellHeight(-1);
            }
        });

        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoItem nuevoItem = new NuevoItem();
                try {
                    String[] temp = nuevoItem.getDatos(controlador.getTemas());
                    System.out.println(Arrays.toString(temp));
                    System.out.println(temp.length);
                    if (temp[0] != null){
                        System.out.println("Entra");
                        controlador.addItem(temp);
                        actualizarLista(controlador.getItems());
                    }
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BorrarItem borrarItem = new BorrarItem();
                int id = lstModel.getElementAt(lstItems.getSelectedIndex()).getId();
                String titulo = lstModel.getElementAt(lstItems.getSelectedIndex()).getAutor();
                String texto = lstModel.getElementAt(lstItems.getSelectedIndex()).getTexto();
                String tema = lstModel.getElementAt(lstItems.getSelectedIndex()).getTema();
                try {
                    if (borrarItem.borrar(titulo,tema,texto)){
                        controlador.deleteItem(id);
                        actualizarLista(controlador.getItems());
                    }
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    private void actualizarLista(ArrayList<Item> items) {
        lstModel.clear();
        for (Item item : items){
            lstModel.addElement(item);
        }
    }

    public Container getPanel() {
        return pnlMain;
    }

    private void insertarEjemplos() throws SQLException {
        /*String[] item1 = {"Juan Morales",LocalDate.of(2020,3,13).toString(),"Aplicado el parche #1128 desde Jonatino/patch-1. Resultado aparentemente correcto","IT"};
        String[] item2 = {"José Muñoz",LocalDate.of(2020,3,14).toString(),"Los equipos del despacho A33 están esperando la recogida. El equipo de mantenimiento ya lo sabe","Mantenimiento"};
        String[] item3 = {"Juan Morales",LocalDate.of(2020,3,14).toString(),"El servidor de aplicaciones del DC-2 está haciendo dando servicio intermitente. ¿Problema de la red?","Desarrollo"};
        String[] item4 = {"Redes Admin",LocalDate.of(2020,3,15).toString(),"Problema con el switch P-2 solucionado. Módulo SFP cambiado. El servidor de aplicaciones debería ir bien ya","General"};
        String[] item5 = {"Juan Morales",LocalDate.of(2020,3,16).toString(),"Necesitamos un servidor de despliegue para la aplicación de mensajería.","Desarrollo"};
        String[] item6 = {"José Muñoz",LocalDate.of(2020,3,16).toString(),"¿Qué configuración debería tener el servidor de despliegue para la aplicación de mensajería? Enviar a admin@seragul.es","IT"};
        controlador.addItem(item1);
        controlador.addItem(item2);
        controlador.addItem(item3);
        controlador.addItem(item4);
        controlador.addItem(item5);
        controlador.addItem(item6);*/
    }
}
