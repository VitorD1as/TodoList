package services;

import entities.Task;
import entities.TaskStatus;

import java.util.ArrayList;
import java.util.List;

public class TaskServices {
    List<Task> listTask = new ArrayList<>();

    public void addTask(Task task){
        listTask.add(task);
        System.out.println("Task adicionada com sucesso!");
    }

    public void listTask(){
        if(listTask.isEmpty()){
            System.out.println("Não há nada na lista!");
        } else{
            for (Task task : listTask) {
                System.out.println(task);
            }
        }
    }

    public void markAsCompleted(long id){
        for (Task task : listTask) {
            if(task.getId() == id){
                task.setTaskStatus(TaskStatus.COMPLETED);
                return;
            }
            System.out.println("Essa task não existe!");
        }
    }

    public void removeTask(long id) {
        Task taskToRemove = null;
        for (Task task : listTask) {
            if(task.getId() == id){
                taskToRemove = task;
                break;
            }
        }

        if(taskToRemove != null){
            listTask.remove(taskToRemove);
            System.out.println("Task removida com sucesso!");
        } else{
            System.out.println("Esse id não existe!");
        }
    }
}
