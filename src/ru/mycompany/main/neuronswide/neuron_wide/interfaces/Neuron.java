package ru.mycompany.main.neuronswide.neuron_wide.interfaces;

/**
 *  Сам нейрон
 */
public interface Neuron {

    /**
     * вернуть состояние состояние после применения активирующицй фкнции
     * @return
     */
    Object getState();

    /**
     * а это я чет не совсем понял нахрена придумал
     */
    void setState();

    /**
     * может вернуть массив своих входов(для обучения полезно например)
     * @return массив входов
     *
     */
    Link[] getLinks();


}
