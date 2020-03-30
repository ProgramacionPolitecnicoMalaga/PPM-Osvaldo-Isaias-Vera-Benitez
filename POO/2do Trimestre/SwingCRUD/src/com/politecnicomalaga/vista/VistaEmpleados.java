package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorEmpleados;
import com.politecnicomalaga.modelo.Empleado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class VistaEmpleados {
    private JTextField txtPatron;
    private JButton btnBuscar, btnNuevoEmp, btnModificarEmp, btnBorrarEmp;
    private JTable tblEmpleados;
    private JPanel pnlEmpleados, pnlEmpBuscar, pnlAcciones;
    private ControladorEmpleados controlador;

    public VistaEmpleados(ControladorEmpleados controlador){
        this.controlador = controlador;
        actualizarTabla(controlador.getEmpleados());
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Coger contenido de txt field
                //Controlador busca empleados por patron
                //actualizar tabla
                String patron = txtPatron.getText();
                try {
                    ArrayList<Empleado> empleados = controlador.buscarPatron(patron);
                    actualizarTabla(empleados);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnNuevoEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoEmpleado nuevo = new NuevoEmpleado();
                try {
                    controlador.addEmpleado(nuevo.getDatos());
                    actualizarTabla(controlador.getEmpleados());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnModificarEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificarEmpleado modificar = new ModificarEmpleado();
                int row = tblEmpleados.getSelectedRow();
                int id = (Integer) tblEmpleados.getValueAt(row,0);
                String nombre = (String) tblEmpleados.getValueAt(row,1);
                int edad = (Integer) tblEmpleados.getValueAt(row,2);
                try {
                    controlador.modificarDatosEmp(modificar.getDatos(id,nombre,edad));
                    actualizarTabla(controlador.getEmpleados());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnBorrarEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BorrarEmpleado borrar = new BorrarEmpleado();
                int row = tblEmpleados.getSelectedRow();
                int id = (Integer) tblEmpleados.getValueAt(row,0);
                String nombre = (String) tblEmpleados.getValueAt(row,1);
                int edad = (Integer) tblEmpleados.getValueAt(row,2);
                try {
                    if (borrar.borrar(nombre,edad)){
                        controlador.borrarEmpleado(id);
                        actualizarTabla(controlador.getEmpleados());
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void actualizarTabla(ArrayList<Empleado> listaEmpleados){
        DefaultTableModel model = (DefaultTableModel) tblEmpleados.getModel();
        model.setRowCount(0);
        for (Empleado emp : listaEmpleados){
            Object[] datos = {emp.getId(),emp.getNombre(),emp.getEdad()};
            model.addRow(datos);
        }
    }

    private void createUIComponents() {
        tblEmpleados = new JTable();
        Object[] columnas = {"id","nombre","edad"};
        DefaultTableModel tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(columnas);
        tblEmpleados.setModel(tableModel);
    }

    public JPanel getPnlEmpleados(){
        return pnlEmpleados;
    }
}
