package com.politecnicomalaga.dao;

import com.politecnicomalaga.modelo.Empleado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAO {
    private DBConn conn;

    public EmpleadoDAO() throws SQLException {
        conn = new DBConn();
    }

    public ArrayList<Empleado> buscarPorPatron(String patron) throws SQLException {
        ArrayList<Empleado> empleados = new ArrayList<>();
        ResultSet resultSet = conn.read("SELECT id,nombre,edad FROM Empleado WHERE nombre LIKE '%" + patron + "%'");
        while(resultSet.next()){
            empleados.add(generarEmpleado(resultSet));
        }
        return empleados;
    }

    public ArrayList<Empleado> getEmpleados() throws SQLException {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ResultSet result = conn.read("SELECT * FROM Empleado");
        while(result.next()){
            listaEmpleados.add(generarEmpleado(result));
        }
        return listaEmpleados;
    }

    public int crear(String nombre, int edad) throws SQLException {
        return conn.create("INSERT INTO Empleado(nombre,edad) VALUES ('"+nombre+"','"+edad+"')");
    }

    public int modificar(int id ,String nombre, int edad) throws SQLException {
        return conn.update("UPDATE Empleado SET nombre = '" +nombre+ "', edad = '" +edad+ "' WHERE id = '" +id+ "'");
    }

    public int eliminar(int id) throws SQLException {
        return conn.delete("DELETE FROM Empleado where id = '"+id+"'");
    }

    public Empleado generarEmpleado(ResultSet result) throws SQLException {
        return new Empleado(result.getInt("id"),result.getString("nombre"),result.getInt("edad"));
    }
}
