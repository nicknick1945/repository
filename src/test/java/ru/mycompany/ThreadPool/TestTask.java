package test.java.ru.mycompany.ThreadPool;

import main.java.ru.mycompany.mutlithreading.AbstractTask;
import main.java.ru.mycompany.neuron_wide.AbstractImpl.AbstractEnterLink;

/**
 * Created by nick on 07.06.17.
 */
public class TestTask extends AbstractTask{
    @Override
    public void action() throws InterruptedException {
        wait(1000);
        System.out.println(Thread.currentThread().getName()+":я работаю");
    }
}
