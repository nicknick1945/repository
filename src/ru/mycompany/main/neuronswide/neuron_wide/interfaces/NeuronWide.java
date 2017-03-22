package ru.mycompany.main.neuronswide.neuron_wide.interfaces;

/**
 * Интерфейс реализации собственно самой нейросети
 */
public interface NeuronWide {

    /**
     * Функция обучения нейросети
     * @param learningSample обуающий семпл
     */
    void doLearn(LearningSample learningSample);

    /**
     * Функция которая вызавает непосредственно основной функционал нейросети  ,а именно анализировать входные значения
     * @param adapter адаптер
     * @param sample входные данные
     * @return возвращает данные преобразованные с помощью адаптера
     */
    Adapter doRecognize(Adapter adapter ,Sample sample);

    /**
     * Функция которая вызавает непосредственно основной функционал нейросети  ,а именно анализировать входные значения
     * @param sample Входные данные
     * @return набор данных полученные в выходных нейронов
     */
    double[] doRecognize(Sample sample);

}
