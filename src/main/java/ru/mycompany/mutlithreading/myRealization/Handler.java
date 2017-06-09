package main.java.ru.mycompany.mutlithreading.myRealization;

import main.java.ru.mycompany.mutlithreading.myRealization.interfaces.Task;

/**
 * Created by nick on 07.06.17.
 */

/**
 * Управляет вызовом
 * выполнения задач
 *
 * @see Task
 * представляет собой поток в котором у задачи будет вызван метод action()
 */
public class Handler extends Thread {

    private Task task;                  //Задача
    private ThreadsPool threadsPool;    //ссылка на пул потоков

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
            action(task);
        threadsPool.addHandler(this);
    }

    protected void action(Task task) {
        task.action();
    }

    public void setThreadPool(ThreadsPool threadsPool) {
        this.threadsPool = threadsPool;
    }

}
