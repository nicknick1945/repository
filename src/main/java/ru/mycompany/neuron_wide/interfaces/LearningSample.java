package main.java.ru.mycompany.neuron_wide.interfaces;


/**
 * Интерфейс для сэмпла обучения , содержит входное и соответствующее ему выходное значение
 */
public interface LearningSample {
    /**
     * @return вернем массив обьектов со входными значениями
     */
    Object getInput();

    /**
     * @return вернем масив обьектов требуемого выхода
     */
    Object getOut();

    void setInput(Double[][] input);

    void setOut(Double[] out);
}
