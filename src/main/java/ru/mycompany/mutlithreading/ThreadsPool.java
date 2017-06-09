package main.java.ru.mycompany.mutlithreading;

import main.java.ru.mycompany.mutlithreading.exceptions.IlligalThreadsPulSterArgumentsException;
import main.java.ru.mycompany.mutlithreading.interfaces.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nick on 07.06.17.
 *
 * Класс выполняющий переданные задачи в заданном колличестве потоков
 */
public class ThreadsPool {

    private Stack<Task> tasks;
    private List<Handler> handlers;


    public void start(Stack<Task> tasks, int countThread) throws Exception {
        this.tasks = tasks;
        try {
            handlers = createHandlers(countThread);
        }catch (Exception e){
            throw e;
        }

        int countHandlers = handlers.size();
        for (int i = 0; i < countHandlers; i++) {
            Handler handler = handlers.get(i);
            addHandler(handler);
        }

        while (!localFinish()) {
            Thread.currentThread().sleep(1000);
        }

    }

    void addHandler(Handler handler) {


        if (!tasks.empty()) {
            handler.setTask(tasks.pop());
            handler.setThreadPool(this);
            if (!handler.isAlive()) {
                handler.start();
            } else {
                handler.run();
            }
        } else {
            localFinish();
        }

    }

    public boolean localFinish() {
        return tasks.empty();
    }

    private List<Handler> createHandlers(int countHandlers) throws Exception {
        if (countHandlers >= 1 && tasks != null) {
            List<Handler> createdHandlers = new ArrayList<>();
            for (int i = 0; i < countHandlers; i++) {
                createdHandlers.add(new Handler());
            }
            return createdHandlers;

        }else if (tasks == null && countHandlers >= 1){
            throw new IlligalThreadsPulSterArgumentsException("не переданы задачи");
        }else if (tasks != null && countHandlers <1 ){
            throw new IlligalThreadsPulSterArgumentsException("события не могут быть выполнены клолличестве потоков <1");
        }else  {
            throw new IlligalThreadsPulSterArgumentsException("не переданы задачи + \n " +
                    "события не могут быть выполнены клолличестве потоков <1");
        }
    }

}
