import com.politecnicomalaga.controlador.ControladorEmpleados;
import com.politecnicomalaga.vista.VistaEmpleados;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Empleados");
        ControladorEmpleados controlador = new ControladorEmpleados();
        frame.setContentPane(new VistaEmpleados(controlador).getPnlEmpleados());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
