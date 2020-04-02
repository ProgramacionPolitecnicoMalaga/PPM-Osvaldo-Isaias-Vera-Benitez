package com.politecnicomalaga.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {
    private final static String url = "jdbc:mysql://vps794137.ovh.net:3306/CustomRenderer";
    private final static String user = "isaias";
    private final static String password = "isaias";
    private Connection conn;

    public DBConnector() throws SQLException {
        conn = DriverManager.getConnection(url,user,password);
    }

    public Connection getConn(){
        return conn;
    }

    public ResultSet query(String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeQuery();
    }

    public int update(String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeUpdate();
    }
}