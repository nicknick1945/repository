package main.java.ru.mycompany.neurons_wide_learner.exceptions;

/**
 * Created by nick on 04.06.17.
 */
public class NotMatchCountNeuronsOutAndSamplOut extends Exception {

    @Override
    public String getMessage() {
        return "не совпадает количество выходов нейронной сети , " +
                "с количеством выходов в обучающей выборке";
    }
}
