package main.java.ru.mycompany.mutlithreading.interfaces;

import main.java.ru.mycompany.mutlithreading.ThreadsPool;

/**
 * Created by nick on 07.06.17.
 */
public interface Handler extends Runnable {
    void setThreadPool(ThreadsPool threadPool);
    void setTask(Task task);
}
