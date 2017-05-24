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
     * может вернуть массив своих входов
     * @return массив входов
     *
     */
    Link[] getLinks();

    void setLinks(Link[] links);
}
