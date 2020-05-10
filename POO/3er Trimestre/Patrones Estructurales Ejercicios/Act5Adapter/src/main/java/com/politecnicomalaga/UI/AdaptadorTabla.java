package com.politecnicomalaga.UI;

import com.politecnicomalaga.modelo.Persona;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AdaptadorTabla extends AbstractTableModel {
    private String[] nombreColumnas = {"Nombre","Apellido","Edad"};
    private final static int COLUMNA_NOMBRE = 0;
    private final static int COLUMNA_APELLIDO = 1;
    private final static int COLUMNA_EDAD = 2;
    private List<Persona> personasList;

    public AdaptadorTabla(List<Persona> personasList){
        this.personasList = personasList;
    }
    @Override
    public int getRowCount() {
        return personasList.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if ((rowIndex > -1) && (rowIndex < personasList.size())){
            switch(columnIndex){
                case COLUMNA_NOMBRE: return personasList.get(rowIndex).getNombre();
                case COLUMNA_APELLIDO: return personasList.get(rowIndex).getApellido();
                case COLUMNA_EDAD: return personasList.get(rowIndex).getEdad();
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if ((rowIndex > -1) && (rowIndex < personasList.size())){
            if (columnIndex == COLUMNA_EDAD) personasList.get(rowIndex).setEdad((Integer) aValue);
            else if (columnIndex == COLUMNA_APELLIDO) personasList.get(rowIndex).setApellido((String) aValue);
            else if (columnIndex == COLUMNA_NOMBRE) personasList.get(rowIndex).setNombre((String) aValue);
        }
        fireTableCellUpdated(rowIndex,columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case COLUMNA_NOMBRE:
            case COLUMNA_APELLIDO: return String.class;
            case COLUMNA_EDAD: return Integer.class;
        }
        return null;
    }

    public void removeRow(int row){
        if ((row > -1) && (row < personasList.size())){
            int borrar = JOptionPane.showConfirmDialog(null,"¿Desea borrar la fila?","Borrado",JOptionPane.WARNING_MESSAGE);
            if (borrar == JOptionPane.OK_OPTION) {
                personasList.remove(row);
                fireTableRowsDeleted(row,row);
            }
        }
    }

    public void addRow(){
        personasList.add(new Persona("","",0));
        fireTableDataChanged();
    }
}
