package main.java.ru.mycompany.neuron_wide.exceprions;

/**
 * Created by nick on 27.05.17.
 */
public class CannotRecognizeThisTypeException extends Exception {

    @Override
    public String getMessage() {
        return "object to recognize must be 'double[][][] with size [*][128][128]'";
    }
}
