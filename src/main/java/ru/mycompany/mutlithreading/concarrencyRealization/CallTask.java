package main.java.ru.mycompany.mutlithreading.concarrencyRealization;

import java.util.concurrent.Callable;

/**
 * Created by nick on 09.06.17.
 */
public abstract class CallTask<T extends Object> implements Callable<T> {

    @Override
    public abstract T call() throws Exception;
}
