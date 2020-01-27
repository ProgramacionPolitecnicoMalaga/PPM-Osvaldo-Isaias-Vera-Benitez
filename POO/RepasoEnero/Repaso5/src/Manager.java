import java.util.ArrayList;
import java.util.Date;

public class Manager {
    private Interfaz ui = new Interfaz();
    private ArrayList<Categoria> categoryList = new ArrayList<>();
    private ArrayList<Tarea> taskList = new ArrayList<>();

    public void addNewCategory(String categoryName) {
        categoryList.add(new Categoria(categoryName));
        ui.realizadoCorrectamenteMenu();
    }

    public void addNewTask(String name, Date date, Categoria categoria){
        if (categoryList.contains(categoria)){
            taskList.add(new Tarea(name,date,categoria));
        } else {
            categoryList.add(categoria);
            taskList.add(new Tarea(name,date,categoria));
        }
        ui.realizadoCorrectamenteMenu();
    }

    public void showCategories(){
        for (Categoria cate : categoryList){
            System.out.println(categoryList.indexOf(cate) + "- " + cate);
        }
    }

    public void showPendingTasks() {
        for (Tarea task : taskList){
            if (!task.isDone()){
                System.out.println(taskList.indexOf(task) + "- " + task);
            }
        }
    }

    public void taskDone (int taskPosition){
        taskList.get(taskPosition).setDone(true);
        ui.realizadoCorrectamenteMenu();
    }

    public ArrayList<Tarea> taskByCategory(int categoryPos) {
        ArrayList<Tarea> temp = new ArrayList<>();
        for (Tarea task : taskList){
            if (task.getCategoria().equals(categoryList.get(categoryPos))){
                temp.add(task);
            } else {
                ui.noTareasCategoriaMenu();
            }
        }
        return temp;
    }

    public ArrayList<Tarea> showTaskByDate(Date date) {
        ArrayList<Tarea> temp = new ArrayList<>();
        for (Tarea task : taskList){
            if (task.getFechaLimite().compareTo(date) == 0){
                temp.add(task);
            } else {
                ui.noTareasFechaMenu();
            }
        }
        return temp;
    }

    public ArrayList<Tarea> showTaskOnTime() {
        ArrayList<Tarea> temp = new ArrayList<>();
        for (Tarea task : taskList){
            if (task.getFechaLimite().compareTo(new Date()) > 0){
                temp.add(task);
            } else {
                ui.noTareasFechaMenu();
            }
        }
        return temp;
    }

    public ArrayList<Tarea> showTaskDelayed() {
        ArrayList<Tarea> temp = new ArrayList<>();
        for (Tarea task : taskList){
            if (task.getFechaLimite().compareTo(new Date()) < 0){
                temp.add(task);
            } else {
                ui.noTareasFechaMenu();
            }
        }
        return temp;
    }
}
