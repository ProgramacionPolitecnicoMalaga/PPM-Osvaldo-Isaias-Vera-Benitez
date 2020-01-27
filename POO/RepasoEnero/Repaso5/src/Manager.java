import java.util.ArrayList;

public class Manager {
    Interfaz ui = new Interfaz();
    private ArrayList<Categoria> categoryList = new ArrayList<>();
    private ArrayList<Tarea> taskList = new ArrayList<>();

    public void addNewCategory(String categoryName) {
        categoryList.add(new Categoria(categoryName));
        ui.realizadoCorrectamenteMenu();
    }

    public void addNewTask(Tarea tarea){
        taskList.add(tarea);
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
            if (task.getCategoria().getNombre().equals(categoryList.get(categoryPos).getNombre())){
                temp.add(task);
            }
        }
        return temp;
    }
}
