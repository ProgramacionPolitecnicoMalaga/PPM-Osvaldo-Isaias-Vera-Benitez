import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws ParseException {
        Interfaz interfaz = new Interfaz();
        Manager mgr = new Manager();
        Scanner lector = new Scanner(System.in).useDelimiter("\n");
        String opcion = "";

        while(!opcion.equals("10")){
            int seleccion;
            SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
            interfaz.mostrarMenu();
            opcion = lector.next();

            switch (opcion){
                case "1":
                    interfaz.nuevaCategoriaMenu();
                    mgr.addNewCategory(lector.next());
                    break;
                case "2":
                    mgr.showCategories();
                    break;
                case "3":
                    interfaz.nuevaTareaMenu();
                    String nombre = lector.next();
                    Date date1 = format.parse(lector.next());
                    Categoria categoria = new Categoria(lector.next());
                    mgr.addNewTask(nombre, date1, categoria);
                    break;
                case "4":
                    mgr.showPendingTasks();;
                    break;
                case "5":
                    interfaz.eliminarTareaMenu();
                    mgr.showPendingTasks();
                    seleccion = lector.nextInt();
                    mgr.taskDone(seleccion);
                    break;
                case "6":
                    interfaz.seleccionarCategoria();
                    mgr.showCategories();
                    seleccion = lector.nextInt();
                    System.out.println(mgr.taskByCategory(seleccion));
                    break;
                case "7":
                    interfaz.tareasFechaMenu();
                    Date date2 = format.parse(lector.next());
                    System.out.println(mgr.showTaskByDate(date2));
                    break;
                case "8":
                    System.out.println(mgr.showTaskOnTime());
                    break;
                case "9":
                    System.out.println(mgr.showTaskDelayed());
                default:
                    System.out.println("Selección incorrecta");
            }

            /*
            if (opcion.equals("1")) {
                interfaz.nuevaCategoriaMenu();
                mgr.addNewCategory(lector.next());
            } else if (opcion.equals("2")) {
                mgr.showCategories();
            } else if (opcion.equals("3")) {
                interfaz.nuevaTareaMenu();
                Tarea tareaTemp = new Tarea();
                tareaTemp.setNombre(lector.next());
                Date date = format.parse(lector.next());
                tareaTemp.setFechaLimite(date);
                tareaTemp.setCategoria(new Categoria(lector.next()));
                mgr.addNewTask(tareaTemp);
            } else if (opcion.equals("4")) {
                mgr.showPendingTasks();
            } else if (opcion.equals("5")) {
                interfaz.eliminarTareaMenu();
                mgr.showPendingTasks();
                seleccion = lector.nextInt();
                mgr.taskDone(seleccion);
            } else if (opcion.equals("6")){
                interfaz.seleccionarCategoria();
                mgr.showCategories();
                seleccion = lector.nextInt();
                System.out.println(mgr.taskByCategory(seleccion));
            } else {
                System.out.println("incorrecta");
            }
            interfaz.mostrarMenu();
            opcion = lector.next();
*/
        }

    }
}
