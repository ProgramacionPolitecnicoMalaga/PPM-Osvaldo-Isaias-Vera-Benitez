package com.politecnicomalaga.UI;

import com.politecnicomalaga.Controlador.ControladorMensajes;
import com.politecnicomalaga.Controlador.ControladorSesiones;
import com.politecnicomalaga.Modelo.Credencial;
import com.politecnicomalaga.Modelo.Mensaje;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.TreeMap;

public class VistaLectura {
    private JPanel panelLectura, panelRemitente,panelMensaje;
    private JLabel lblRemitentes,lblTitulo,lblMensaje;
    private JPanel panelTitulo,panelTexto;
    private JLabel lblTexto;
    private JScrollPane jspRemitentes;
    private JPanel pnlHEY;
    private JTable tablaRemitentes;
    private ControladorMensajes conMensajes;
    private ControladorSesiones conSesiones;
    private TreeMap<Timestamp, Mensaje> mensajes;
    private DefaultTableModel tableModel;

    public VistaLectura(ControladorMensajes conMensajes, ControladorSesiones conSesiones) throws NoSuchAlgorithmException, SQLException, IOException {
        this.conMensajes = conMensajes;
        this.conSesiones = conSesiones;
        mensajes = new TreeMap<>();
        ListSelectionModel listSelectionModel = tablaRemitentes.getSelectionModel();

        TableColumnModel columnModel = tablaRemitentes.getColumnModel();
        columnModel.removeColumn(columnModel.getColumn(2));

        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!listSelectionModel.isSelectionEmpty()){
                    Mensaje mensaje = (Mensaje) tablaRemitentes.getModel().getValueAt(tablaRemitentes.getSelectedRow(),2);
                    lblTitulo.setText(mensaje.getTitulo());
                    lblTexto.setText(mensaje.getTexto());
                }
            }
        });


        panelLectura.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                try {
                    System.out.println("Shown");
                    cargarRemitentes();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                lblTitulo.setText("");
                lblTexto.setText("");
            }
        });
    }

    public void cargarMensajes() {
        String user = conSesiones.getPropiedad("nickname");
        int id_user = conMensajes.getCredencialByName(user).getId();
        for (Mensaje msj : conMensajes.getMensajesByDestinatario(id_user)){
            mensajes.put(msj.getFecha_hora(),msj);
        }
    }

    public void cargarRemitentes() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tablaRemitentes.getModel();
        model.setRowCount(0);
        String user = conSesiones.getPropiedad("nickname");
        int id_user = conMensajes.getCredencialByName(user).getId();
        if (conMensajes.hayMensajes(id_user)) {
            cargarMensajes();
            for(Timestamp tmp : mensajes.keySet()){
                Credencial credencial = conMensajes.getCredencialByID(mensajes.get(tmp).getId_remitente());
                Object[] temp = {credencial.getName(),tmp.toString(),mensajes.get(tmp)};
                model.addRow(temp);
            }
        } else {
            System.out.println("No hay mensajes");
        }
    }

    public JPanel getPanel(){
        return panelLectura;
    }

    private void createUIComponents() {
        tablaRemitentes = new JTable();
        Object[] columnas = {"Remitente","Fecha","Credencial"};
        tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(columnas);
        tablaRemitentes.setModel(tableModel);
        tablaRemitentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
