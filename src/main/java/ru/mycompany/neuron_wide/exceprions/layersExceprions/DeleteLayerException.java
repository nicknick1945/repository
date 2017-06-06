package main.java.ru.mycompany.neuron_wide.exceprions.layersExceprions;

/**
 * Ошибка удаления нейронного слоя
 * Created by Коля on 20.03.2017.
 */
public class DeleteLayerException extends  Exception {

    @Override
    public String getMessage() {
        return " Нельзя удалить слой , так ка слой отсутствует";
    }

}
