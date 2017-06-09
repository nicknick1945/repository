package main.java.ru.mycompany.mutlithreading.myRealization;

import main.java.ru.mycompany.mutlithreading.myRealization.exceptions.IlligalThreadsPulSterArgumentsException;
import main.java.ru.mycompany.mutlithreading.myRealization.interfaces.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.lang.Thread.sleep;

/**
 * Created by nick on 07.06.17.
 * <p>
 * Класс выполняющий переданные задачи в заданном колличестве потоков
 */
public class ThreadsPool {

    private Stack<Task> tasks;
    private List<Handler> handlers;


    public void start(Stack<Task> tasks, int countThread) throws Exception {
        this.tasks = tasks;
        handlers = createHandlers(countThread);

        int countHandlers = handlers.size();
        for (int i = 0; i < countHandlers; i++) {
            Handler handler = handlers.get(i);
            addHandler(handler);
        }

        while (!localFinish()) {
            sleep(1000);
        }

    }

    void addHandler(Handler handler) {


        if (!tasks.empty()) {
            handler.setTask(tasks.pop());
            if (!handler.isAlive()) {
                handler.setThreadPool(this);
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

        } else if (tasks == null && countHandlers >= 1) {
            throw new IlligalThreadsPulSterArgumentsException("не переданы задачи");
        } else if (tasks != null && countHandlers < 1) {
            throw new IlligalThreadsPulSterArgumentsException("события не могут быть выполнены клолличестве потоков <1");
        } else {
            throw new IlligalThreadsPulSterArgumentsException("не переданы задачи + \n " +
                    "события не могут быть выполнены клолличестве потоков <1");
        }
    }

}
