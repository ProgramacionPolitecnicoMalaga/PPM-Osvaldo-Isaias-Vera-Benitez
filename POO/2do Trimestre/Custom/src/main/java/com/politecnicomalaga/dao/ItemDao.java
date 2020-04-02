package com.politecnicomalaga.dao;

import com.politecnicomalaga.modelo.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class ItemDao {
    private DBConnector conn;

    public ItemDao() throws SQLException {
        conn = new DBConnector();
    }

    public ArrayList<Item> getItems() throws SQLException {
        ArrayList<Item> listaItems = new ArrayList<>();
        ResultSet result = conn.query("SELECT * FROM Entrada");
        while(result.next()){
            listaItems.add(generarItem(result));
        }
        return listaItems;
    }

    private Item generarItem(ResultSet result) throws SQLException {
        Date date = result.getDate("fecha");
        int id = result.getInt("id");
        String autor = result.getString("titulo");
        LocalDate fecha = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        String texto = result.getString("texto");
        String tema = result.getString("tema");
        return new Item(id,autor,fecha,texto,tema);
    }

    public int crear(String autor, String fecha, String texto, String tema) throws SQLException {
        return conn.update("INSERT INTO Entrada(titulo,fecha,texto,tema) VALUES ('"+autor+"','"+fecha+"','"+texto+"','"+tema+"')");
    }

    public int eliminar(int id) throws SQLException {
        return conn.update("DELETE FROM Entrada WHERE id = '"+id+"'");
    }

    public String[] getTemas() throws SQLException {
        String[] temp = {"Hey"};
        ResultSet result = conn.query("SHOW COLUMNS FROM Entrada LIKE 'tema'");
        while (result.next()){
            temp = splitTemas(result);
        }
        return temp;
    }

    private String[] splitTemas(ResultSet resultSet) throws SQLException {
        String enumValues = resultSet.getString("Type");
        String values = enumValues.substring(5,enumValues.length()-2);
        return values.replaceAll("'","").split(",");
    }

}
