package com.politecnicomalaga.Controlador;

import com.politecnicomalaga.Algoritmo.Algoritmo;
import com.politecnicomalaga.Algoritmo.GenerarAlgoritmo;
import com.politecnicomalaga.DAO.CredencialDAO;
import com.politecnicomalaga.DAO.MensajeDAO;
import com.politecnicomalaga.DataTransfer.DataTransfer;
import com.politecnicomalaga.Modelo.Credencial;
import com.politecnicomalaga.Modelo.Credenciales;
import com.politecnicomalaga.Modelo.Mensaje;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorMensajes {
    private MensajeDAO mensajeDAO;
    private CredencialDAO credencialDAO;
    private Credenciales credenciales;

    public ControladorMensajes() throws SQLException {
        mensajeDAO = new MensajeDAO();
        credencialDAO = new CredencialDAO();
        credenciales = new Credenciales();
        cargarUsuarios();
    }

    private void cargarUsuarios() throws SQLException {
        credenciales.addCredenciales(credencialDAO.getCredenciales());
    }

    public ArrayList<Credencial> getUsuarios(){
        return credenciales.getListaCredenciales();
    }

    public ArrayList<Mensaje> getMensajesByDestinatario(int destinatario){
        ArrayList<Mensaje> mensajes =  new ArrayList<>();
        try {
            mensajes = mensajeDAO.getMensajesByUser(destinatario);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return mensajes;
    }

    public Credencial getCredencialByID(int id){
        return credenciales.getCredencialByID(id);
    }

    public Credencial getCredencialByName(String name){
        return credenciales.getCredencialByName(name);
    }

    public boolean comprobarPassword(DataTransfer datos) throws NoSuchAlgorithmException {
        DataTransfer data = new DataTransfer();
        Credencial credencial = (Credencial) datos.get("credential");
        String password = (String) datos.get("password");
        String hash = credencial.getHash();
        String salt = credencial.getSalt();
        data.put("password",password);
        data.put("passwordHash",hash);
        data.put("salt",salt);
        Algoritmo algoritmo = GenerarAlgoritmo.getAlgoritmo(credencial.getAlgorithm());
        return algoritmo.checkPassword(data);
    }

    public boolean usuarioExiste(String name) {
        return getCredencialByName(name) != null;
    }

    public void addMensaje(DataTransfer mensaje) throws SQLException {
        int destinatario = (Integer) mensaje.get("destinatario");
        int remitente = (Integer) mensaje.get("remitente");
        String titulo = (String) mensaje.get("titulo");
        String texto = (String) mensaje.get("texto");
        mensajeDAO.crear(destinatario,remitente,titulo,texto, new Timestamp(System.currentTimeMillis()));
    }

    public boolean hayMensajes(int id_destinatario) throws SQLException {
        return mensajeDAO.getMensajesByUser(id_destinatario) != null;
    }

    public void addCredencial(String name, String password) throws SQLException, NoSuchAlgorithmException {
        Algoritmo algoritmo = GenerarAlgoritmo.getAlgoritmo(1);
        String hash = algoritmo.getPasswordHash(password);
        String salt = algoritmo.getSalt();
        credencialDAO.crear(name,hash,1, salt );
    }

}
