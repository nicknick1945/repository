package ru.mycompany.main.neuronswide.neuron_wide.interfaces;


import ru.mycompany.main.neuronswide.neuron_wide.exceprions.layerExceptions.HaveNotPreviousLayerException;
import ru.mycompany.main.neuronswide.neuron_wide.exceprions.layerExceptions.HoveNotNextLayerException;

/**
 * Нецронный слой
 */
public interface NeuronsLayer {

    /**
     * усанавливает для текущего слоя предыдущий
     * @param neuronsLayer нейронный слой
     */
    void setPreviousLayer(NeuronsLayer neuronsLayer);

    /**
     * устанавливает для текущего нейронного слоя слой neuronusLayer как следующий
     * @param neuronsLayer
     */
    void setNextLayer(NeuronsLayer neuronsLayer);

    /**
     * @return Возвратит предшествующи слой , если таковой имется
     * @throws HaveNotPreviousLayerException
     */
    NeuronsLayer getPreviousLayer() throws HaveNotPreviousLayerException;

    /**
     * @return возвратит следующий слой , если таковой имеется
     * @throws HoveNotNextLayerException
     */
    NeuronsLayer getNextLayer() throws HoveNotNextLayerException;

    /**
     * обучить текущий слой нейронов (одна эпоха обучения)
     * @param args
     */
    void learnLevel(Object[] ... args);

    /**
     * @return вернёт количестве выходов данного слоя (оно равно колличеству нейронов в слое)
     */
    int getOutputSize();

    /** Устанавливает нейроны с слой
     * @param neurons набор нейронов
     */
    void setNeurons(Neuron[] neurons);

    /**
     *
     * @return вернёт true если это не последний слой , иначе false
     */
    boolean hasNext();

    /**
     * @return вернёт true если это первый слой , иначе false
     */
    boolean isFirstLevel();

    /**
     * @return вернёт true если это последни нейронный слой , иначе false
     */
    boolean isLastLayer();

    /**
     * @return возвращает массив нейронов данного слоя
     */
    Neuron[] getNeurons();


}
