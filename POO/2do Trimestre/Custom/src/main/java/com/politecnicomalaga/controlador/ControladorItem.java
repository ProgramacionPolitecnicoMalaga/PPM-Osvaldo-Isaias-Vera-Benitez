package com.politecnicomalaga.controlador;

import com.politecnicomalaga.dao.ItemDao;
import com.politecnicomalaga.modelo.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorItem {
    private ItemDao itemDao;

    public ControladorItem() throws SQLException {
        itemDao = new ItemDao();
    }

    public ArrayList<Item> getItems(){
        ArrayList<Item> listaItems =  new ArrayList<>();
        try {
            listaItems = itemDao.getItems();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listaItems;
    }

    public String[] getTemas() throws SQLException {
        return itemDao.getTemas();
    }

    public void addItem(String [] datos) throws SQLException{
        itemDao.crear(datos[0],datos[1],datos[2],datos[3]);
    }

    public void deleteItem(int id) throws SQLException{
        itemDao.eliminar(id);
    }
}
