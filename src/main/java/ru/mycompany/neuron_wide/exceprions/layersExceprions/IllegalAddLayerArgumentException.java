package main.java.ru.mycompany.neuron_wide.exceprions.layersExceprions;

/**
 * Ошибка . Неправильный индекс вставки нейронного слоя
 * Created by Коля on 19.03.2017.
 */
public class IllegalAddLayerArgumentException extends Exception {

    @Override
    public String getMessage() {
        return "Указан неверный индекс для вставки нейронного слоя ";
    }

}
