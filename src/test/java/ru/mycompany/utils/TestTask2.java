package test.java.ru.mycompany.utils;

import main.java.ru.mycompany.mutlithreading.concarrencyRealization.CallTask;

/**
 * Created by nick on 10.06.17.
 */
public class TestTask2<T> extends CallTask<T> {
    @Override
    public T call() throws Exception {
        for (int i = 0; i < 2000; i++) {
            int b = 123 * (12 + i);
            double c = Math.exp(-b);
            double d = Math.log(c);
        }
        return null;
    }
}
