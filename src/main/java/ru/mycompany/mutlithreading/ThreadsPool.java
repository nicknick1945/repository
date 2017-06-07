package main.java.ru.mycompany.mutlithreading;

import main.java.ru.mycompany.mutlithreading.interfaces.Handler;
import main.java.ru.mycompany.mutlithreading.interfaces.Task;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by nick on 07.06.17.
 */
public class ThreadsPool {

    private Stack<Task> tasks;
    private Stack<Handler> handlers;

    public void setHandlers(Stack<Handler> handlers) {
        this.handlers = handlers;
    }


    public void start(){
        for (int i = 0 ; i < handlers.size() ; i++){
            Handler handler = handlers.pop();
            addHandler(handler);
        }
    }

    public void setTasks(Stack<Task> tasks){
        this.tasks = tasks;
    }

    void addTask(Task task){

        if (!handlers.empty()){
            Handler handler = handlers.pop();
            handler.setTask(task);
            handler.run();
        }else {
            tasks.push(task);
        }
    }

    synchronized void addHandler(Handler handler){

        if (!tasks.empty()){
            handler.setTask(tasks.pop());
            handler.setThreadPool(this);
            handler.run();
        }else {
            handlers.push(handler);
            finish();
        }
    }

    private void finish(){
        //todo сюда передать класс в котором происходит вызов и у него вызвать функцию finish
        System.out.println("Закончили работу ребятки");
    }
}
