package main.java.ru.mycompany.neuron_wide.interfaces;


import main.java.ru.mycompany.neuron_wide.exceprions.layerExceptions.HaveNotPreviousLayerException;

public interface Layers {

    /**Добавление нецронного слоя в нейросеть
     * @param neuronsLayer добавляемый нейронны слой
     * @throws Exception обработка ошибок
     */
    void addLayer(NeuronsLayer neuronsLayer) throws  Exception;

    /**
     * Добавление нейронного слоя в конкретню позицию
     * @param position позиция
     * @param layer слой
     * @throws Exception обработка исключений
     */
    void addLayer(int position, NeuronsLayer layer) throws Exception;

    /**
     * Удаление уровня оп индексу
     * @param index индекс
     * @throws Exception обрабокта исключений
     */
    void deleteLevel(int index) throws  Exception;

    /**
     * Удаление переданного слоя из нейросети
     * @param neuronsLayer нецронный слой , который необходимо удалить
     * @throws Exception обаботка исключений
     */
    void deleteLevel(NeuronsLayer neuronsLayer) throws Exception;

    /**
     * Обучить слои , для каждого слоя будет вызвана его обучающая функция
     * @param learningSample обучающий фрагмент
     */
    void learningLevels(LearningSample learningSample) throws HaveNotPreviousLayerException;

    /**
     *  Функция которая вызавает непосредственно основной функционал нейросети  ,а именно анализировать входные значения
     * @param sample обработать данные
     * @return массив значений с выходного слоя нейронов
     */
     Object doRecognize(Object sample) throws HaveNotPreviousLayerException;

    /** Функция которая вызавает непосредственно основной функционал нейросети  ,а именно анализировать входные значения
     * только в этом случае вернет преобрахованное значение
     * @param adapter адаптер
     * @param sample входные данные
     * @return вернет обьект адаптер
     */
    Adapter doRecognize(Adapter adapter ,Sample sample);

    public int getSize();


}
