package test.java.ru.mycompany.utils;

import main.java.ru.mycompany.mutlithreading.myRealization.interfaces.Task;

/**
 * Created by nick on 07.06.17.
 */
public class TestTask implements Task {
    @Override
    public void action() {
        //Thread.sleep(200);

        for (int i = 0; i < 2000; i++) {
            int b = 123 * (12 + i);
            double c = Math.exp(-b);
            double d = Math.log(c);
        }
//        System.out.println(Thread.currentThread().getName()+":я работаю");
    }
}
