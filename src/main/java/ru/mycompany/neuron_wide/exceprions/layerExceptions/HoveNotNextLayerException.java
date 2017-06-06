package main.java.ru.mycompany.neuron_wide.exceprions.layerExceptions;

/**
 * Ошибка отсутствия следующего слоя в внейросети
 * Created by Nick on 20.03.2017.
 */
public class HoveNotNextLayerException extends Exception {

    @Override
    public String getMessage() {
        return "У этй сети нет следующего уровня";
    }
}
