package com.isaiasvera;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Objects;

public class CarroCompras {
    private JPanel panelMain, panelTitulo, panelTipoProducto, panelProducto, panelCantidadComprar, panelResumen, panelResumenCantidadPrecio, panelProductosTotal, panelPrecioProductosTotal;
    private JLabel labelTitulo1, txtTipoProducto, labelProducto, labelCantidad, labelTotalPTotal, labelTotalPrecio;
    private JComboBox cbTipoProducto, cbProducto;
    private JSpinner spnCantidad;
    private JButton btnComprar;
    private JScrollPane scrollPane;
    private JTable table1;
    private JTextField txtProductosTotal, txtTotalPrecio;
    private JPanel panelActions;
    private File file = new File("./src/com/isaiasvera/productos.csv");
    private HashMap<String, String> tipo = new HashMap<String, String>();
    private HashMap<String, String> productoYCantidad = new HashMap<String, String>();
    private HashMap<String, String> productoYTipo = new HashMap<String, String>();
    private HashMap<String, Double> productoYPrecio = new HashMap<String, Double>();
    private final static int NOMBRE = 1, TIPO = 2, CANTIDAD = 3, PRECIO = 4;
    private DecimalFormat formato = new DecimalFormat("#.00");

    public CarroCompras (){
        almacenarDatos();
        cargarTipos();
        SpinnerModel model = new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1);
        spnCantidad.setModel(model);

        DefaultTableModel tableModel = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){return false;}
        };
        tableModel.addColumn("Cantidad");
        tableModel.addColumn("Producto");
        tableModel.addColumn("Precio unitario");
        tableModel.addColumn("Precio total");
        table1.setModel(tableModel);
        table1.getColumn("Cantidad").setMaxWidth(80);
        table1.getColumn("Precio unitario").setMinWidth(165);
        table1.getColumn("Precio unitario").setMaxWidth(180);
        table1.getColumn("Precio total").setMinWidth(165);
        table1.getColumn("Precio total").setMaxWidth(180);


        cbTipoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbProducto.removeAllItems();
                String temp;
                temp = Objects.requireNonNull(cbTipoProducto.getSelectedItem()).toString();
                if (temp.equals("Todos")){
                    for (String product: productoYCantidad.keySet()){
                        cbProducto.addItem(product);
                    }
                } else {
                    for (String product: productoYTipo.keySet()){
                        if (productoYTipo.get(product).equals(temp)){
                            cbProducto.addItem(product);
                        }
                    }
                }
            }
        });

        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int temp = 0;
                if (!Objects.equals(cbTipoProducto.getSelectedItem(), "")){
                    temp = (Integer) spnCantidad.getValue();
                    agregarATabla(temp, tableModel);
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("CarroCompras");
        frame.setContentPane(new CarroCompras().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void almacenarDatos(){
        String linea, delimeter = ";";
        String[] producto;
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(file));
            while ((linea = bReader.readLine()) != null){
                producto = linea.split(delimeter);
                tipo.put(producto[TIPO], producto[NOMBRE]);
                productoYTipo.put(producto[NOMBRE], producto[TIPO]);
                productoYCantidad.put(producto[NOMBRE], producto[CANTIDAD]);
                productoYPrecio.put(producto[NOMBRE],Double.valueOf(producto[PRECIO].replaceAll(",", ".")));
            }
        } catch (IOException a){
            a.printStackTrace();
        }
    }

    private void cargarTipos(){
        cbTipoProducto.insertItemAt("",0);
        cbTipoProducto.setSelectedIndex(0);
        cbTipoProducto.addItem("Todos");
        for (String tipo: tipo.keySet()){
            cbTipoProducto.addItem(tipo);
        }
    }

    private void agregarATabla (int temp, DefaultTableModel tableModel){
        double precioUni = productoYPrecio.get(cbProducto.getSelectedItem());
        tableModel.addRow(new Object[]{temp, cbProducto.getSelectedItem(), precioUni, precioUni * temp});
        actualizarPrecioCantidad();
    }

    private void actualizarPrecioCantidad(){
        int temp = table1.getRowCount();
        int cantidad = 0;
        double precio = 0.0;
        for (int c = 0; c < temp; c++){
            cantidad += (Integer) table1.getValueAt(c,0);
            precio += (Double) table1.getValueAt(c,3);
        }
        txtProductosTotal.setText(String.valueOf(cantidad));
        txtTotalPrecio.setText(String.valueOf(formato.format(precio)).replaceAll(",", ".") + " €");
    }

}
