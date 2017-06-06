package main.java.ru.mycompany.neuron_wide.interfaces;

import main.java.ru.mycompany.neuron_wide.exceprions.CannotRecognizeThisTypeException;
import main.java.ru.mycompany.neuron_wide.exceprions.layerExceptions.HaveNotPreviousLayerException;

/**
 * Интерфейс реализации собственно самой нейросети
 */
public interface NeuronNetwork {

    /**
     * Функция обучения нейросети
     * @param learningSample обуающий семпл
     */
    void doLearn(LearningSample learningSample) throws HaveNotPreviousLayerException;

    /**
     * Функция которая вызавает непосредственно основной функционал нейросети  ,а именно анализировать входные значения
     * @param adapter адаптер
     * @param sample входные данные
     * @return возвращает данные преобразованные с помощью адаптера
     */
    Object doRecognize(Adapter adapter ,Sample sample) throws HaveNotPreviousLayerException;

    /**
     * Функция которая вызавает непосредственно основной функционал нейросети  ,а именно анализировать входные значения
     * @param sample Входные данные
     * @return набор данных полученные в выходных нейронов
     */
    Object doRecognize(Object sample) throws HaveNotPreviousLayerException, CannotRecognizeThisTypeException;

}
