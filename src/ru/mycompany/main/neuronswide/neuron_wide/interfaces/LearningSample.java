package ru.mycompany.main.neuronswide.neuron_wide.interfaces;


/**
 * Интерфейс для сэмпла обучения , содержит входное и соответствующее ему выходное значение
 */
public interface LearningSample {
    /**
     * @return вернем массив обьектов со входными значениями
     */
    Object[] getInput();

    /**
     * @return вернем масив обьектов требуемого выхода
     */
    double[] getOut();

}
