package com.politecnicomalaga.controlador;

import com.politecnicomalaga.dao.EmpleadoDAO;
import com.politecnicomalaga.modelo.Empleado;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ControladorEmpleados {
    public ArrayList<Empleado> getEmpleados(){
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        try {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            listaEmpleados = empleadoDAO.getEmpleados();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaEmpleados;
    }

    public ArrayList<Empleado> buscarPatron(String patron) throws SQLException {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        try {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            listaEmpleados = empleadoDAO.buscarPorPatron(patron);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaEmpleados;
    }

    public void addEmpleado(String[] datos) throws SQLException {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        empleadoDAO.crear(datos[0],Integer.parseInt(datos[1]));
    }

    public void modificarDatosEmp(String[] datos) throws SQLException {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        empleadoDAO.modificar(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]));
    }

    public void borrarEmpleado(int id) throws SQLException {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        empleadoDAO.eliminar(id);
    }
}
