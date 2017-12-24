package main.java.ru.mycompany.neuron_wide.interfaces;


import main.java.ru.mycompany.neuron_wide.exceprions.linkExceptions.HaveNotDeltaException;

/**
 * Интерфейс для связи нейрона
 */
public interface Link {
    /**Функция возврата результата(state*multiplexer)*/
    Double getValue();
    /**Функция установки сосотояния*/
    void setState(double state);
    /**Функция получения вев нейрона */
    Double getMultiplexer();
    /**Функия установкивеса нейрона */
    void setMultiplexer(double multiplexer);
    /**Функция корректировки веса связи*/
    void correctWidth(double delta) throws HaveNotDeltaException;
}
