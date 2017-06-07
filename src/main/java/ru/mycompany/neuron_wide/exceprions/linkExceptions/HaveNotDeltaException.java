package main.java.ru.mycompany.neuron_wide.exceprions.linkExceptions;

/**
 * Created by nick on 07.06.17.
 */
public class HaveNotDeltaException extends Exception {

    @Override
    public String getMessage(){
        return "для данной связи не посчитана величина коррекстировки веса";
    }
}
