package ru.mycompany.main.neuronswide.neuron_wide.exceprions.layerExceptions;

/**
 * Ошибка отсутстия предыдущего слоя в нейросети
 * Created by Коля on 20.03.2017.
 */
public class HaveNotPreviousLayerException extends Exception {

    @Override
    public String getMessage() {
        return "Этот слой уже является первым";
    }
}
