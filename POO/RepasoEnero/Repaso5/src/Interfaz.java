public class Interfaz {
    public void mostrarMenu(){
        System.out.println("Selecciona una opción:\n" +
                "1- Crear una nueva categoría.\n" +
                "2- Mostrar las categorías existentes.\n" +
                "3- Crear una nueva tarea.\n" +
                "4- Consultar las tareas pendientes.\n" +
                "5- Eliminar una tarea (completada).\n" +
                "6- Consultar las tareas de una categoría.\n" +
                "7- Consultar las tareas en una fecha.\n" +
                "8- Consultar las tareas en tiempo.\n" +
                "9- Consultar las tareas retrasadas.\n" +
                "10- Terminar\n"
        );
    }
    public void nuevaCategoriaMenu(){
        System.out.println("Escribe el nombre de la categoría que deseas crear: ");
    }
    public void nuevaTareaMenu(){
        System.out.println("Escribe el nombre, la fecha (dd-mm-yyyy) y la categoría (en ese orden) de la tarea que deseas crear: ");
    }
    public void eliminarTareaMenu(){
        System.out.println("Escribe el nombre de la tarea que deseas eliminar: ");
    }
    public void seleccionarCategoria(){
        System.out.println("Seleccione una categoría: ");
    }
    public void realizadoCorrectamenteMenu(){
        System.out.println("Cambios realizados correctamente");
    }
}
