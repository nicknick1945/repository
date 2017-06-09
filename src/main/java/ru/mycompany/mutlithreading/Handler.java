package main.java.ru.mycompany.mutlithreading;

import main.java.ru.mycompany.mutlithreading.interfaces.Task;

/**
 * Created by nick on 07.06.17.
 */

/** Управляет вызовом
 * выполнения задач
 * @see Task
 * представляет собой поток в котором у задачи будет вызван метод action()
 * */
public class Handler extends Thread{

    private Task task;                  //Задача
    private ThreadsPool threadsPool;    //ссылка на пул потоков

    public void setTask(Task task){
        this.task = task;
    }

    @Override
    public void run(){

        try {
            action(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadsPool.addHandler(this);
    }

    protected void action(Task task) throws InterruptedException {
        task.action();
    }


    public void setThreadPool(ThreadsPool threadsPool) {
        this.threadsPool = threadsPool;
    }

}
