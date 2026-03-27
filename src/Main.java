import entities.Task;
import services.TaskServices;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TaskServices taskServices = new TaskServices();

        while(true) {
            menu();
            System.out.println("Escreva a opção que você deseja: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch(choose){
                case 1:
                    System.out.println("Escreva o título da tarefa: ");
                    String title = sc.nextLine();
                    System.out.println("Escreva a descrição da tarefa: ");
                    String description = sc.nextLine();
                    System.out.println("Escreva o id correspondente a Task");
                    long id = sc.nextLong();
                    sc.nextLine();
                    Task task = new Task(title, description, id);
                    taskServices.addTask(task);
                    break;

                case 2: taskServices.listTask();
                break;
                case 3:
                    System.out.println("Digite o id da task que você quer concluir: ");
                    long choosedId = sc.nextLong();
                    taskServices.markAsCompleted(choosedId);
                    break;
                case 4:
                    System.out.println("Digite o id da task que você quer remover: ");
                    long removeId = sc.nextLong();
                    taskServices.removeTask(removeId);
                    break;
                case 5:
                    return;
            }
        }
    }

    public static void menu(){
        System.out.println("----------SEU TODO LIST-------------");
        System.out.println("1- Adicionar tarefa");
        System.out.println("2- Listar tarefas");
        System.out.println("3- Marcar como concluida!");
        System.out.println("4- Remover tarefas");
        System.out.println("5- Sair");
    }
}