import java.util.Date;

public class Tarea {
    private String nombre;
    private Categoria categoria;
    private Date fechaLimite;
    private boolean done;

    public Tarea (){
    }

    public Tarea(String nombre, Date fechaLimite, Categoria categoria) {
        this.nombre = nombre;
        this.fechaLimite = fechaLimite;
        this.categoria = categoria;
        done = false;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Nombre Tarea: " + nombre + ", Fecha Límite: " + fechaLimite + ", " + categoria;
    }
}