package test.java.ru.mycompany;

import main.java.ru.mycompany.mutlithreading.interfaces.Task;

/**
 * Created by nick on 07.06.17.
 */
public class TestTask implements Task {
    @Override
    public void action() throws InterruptedException {
        Thread.sleep(200);
        System.out.println(Thread.currentThread().getName()+":я работаю");
    }
}
