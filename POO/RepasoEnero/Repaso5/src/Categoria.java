import java.util.ArrayList;

public class Categoria {
    private String nombre;

    public Categoria() {
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return "Categoria: " + nombre + "\n";
    }
}
