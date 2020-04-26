package com.politecnicomalaga.DAO;

import com.politecnicomalaga.Modelo.Mensaje;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class MensajeDAO {
    private DBConnector conn;

    public MensajeDAO() throws SQLException {
        conn = new DBConnector();
    }

    public ArrayList<Mensaje> getMensajes() throws SQLException {
        ArrayList<Mensaje> listaMensajes = new ArrayList<>();
        ResultSet result = conn.query("SELECT * FROM Mensaje");
        while(result.next()){
            listaMensajes.add(generarMensaje(result));
        }
        return listaMensajes;
    }

    private Mensaje generarMensaje(ResultSet result) throws SQLException {
        int destinatario = result.getInt("id_destinatario");
        int remitente = result.getInt("id_remitente");
        String titulo = result.getString("titulo");
        String mensaje = result.getString("texto");
        Timestamp fecha_hora = result.getTimestamp("fecha_hora");
        return new Mensaje(destinatario,remitente,titulo,mensaje,fecha_hora);
    }

    public ArrayList<Mensaje> getMensajesByUser(int destinatario) throws SQLException {
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        ResultSet resultSet = conn.query("SELECT * FROM Mensaje WHERE id_destinatario = '"+destinatario+"'");
        while (resultSet.next()){
            mensajes.add(generarMensaje(resultSet));
        }
        return mensajes;
    }

    public int crear(int destinatario, int remitente, String titulo, String mensaje, Timestamp fecha_hora) throws SQLException {
        return conn.update("INSERT INTO Mensaje VALUES('"+destinatario+"','"+remitente+"','"+titulo+"','"+mensaje+"','"+fecha_hora+"')");
    }
}
