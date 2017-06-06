package main.java.ru.mycompany.neuron_wide.exceprions.factoryExcptions;

/**
 * Created by Nick on 21.03.2017.
 */
public class IlligalTypeException extends Exception {

    @Override
    public String getMessage() {
        return "Данная фабрика не жет создавть обьекты данного типа, см реализацию фабрики";
    }
}
