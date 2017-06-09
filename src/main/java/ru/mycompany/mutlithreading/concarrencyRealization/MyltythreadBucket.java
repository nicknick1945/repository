package main.java.ru.mycompany.mutlithreading.concarrencyRealization;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by nick on 09.06.17.
 */
public class MyltythreadBucket {
    public static void calculate(Collection<CallTask<Object>> taskList, int countThreads) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(countThreads);
        List<Future<Object>> invokeAll = pool.invokeAll(taskList);
    }
}

