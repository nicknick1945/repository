package main.java.ru.mycompany.neurons_wide_learner.exceptions;

/**
 * Created by nick on 04.06.17.
 */
public class HaveNotNeurnsWideExceprion extends Exception {

    @Override
    public String getMessage() {
        return "У обучающей выборки отсутствует нейросеть";
    }
}
