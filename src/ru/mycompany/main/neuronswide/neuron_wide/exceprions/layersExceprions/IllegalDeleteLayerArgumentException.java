package ru.mycompany.main.neuronswide.neuron_wide.exceprions.layersExceprions;

/** Ошибка удаления нейронного слоя по индексу , такого гиндекса нету
 * Created by Коля on 19.03.2017.
 */
public class IllegalDeleteLayerArgumentException extends Exception {

    @Override
    public String getMessage() {
        return "Указан неверный индекс удаления нейронного слоя ";
    }


}
