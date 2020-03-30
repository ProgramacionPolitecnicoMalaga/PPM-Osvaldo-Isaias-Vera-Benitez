package Modelo;

public class Persona {
    String nombreApellido;

    public Persona(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    @Override
    public String toString() {
        return "Ey.Persona{" +
                "nombreApellido='" + nombreApellido + '\'' +
                '}' + "\n";
    }
}
