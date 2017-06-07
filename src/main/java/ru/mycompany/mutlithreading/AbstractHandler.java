package main.java.ru.mycompany.mutlithreading;

import main.java.ru.mycompany.mutlithreading.interfaces.Handler;
import main.java.ru.mycompany.mutlithreading.interfaces.Task;

/**
 * Created by nick on 07.06.17.
 */
public abstract class AbstractHandler implements Handler{

    private Task task;
    private ThreadsPool threadsPool;

    public void setTask(Task task){
        this.task = task;
    }

    @Override
    public void run(){
        doLearn(task);
        threadsPool.addHandler(this);
    }

    protected void doLearn(Task task){
        task.action();
    }

    @Override
    public void setThreadPool(ThreadsPool threadsPool) {
        this.threadsPool = threadsPool;
    }

}
