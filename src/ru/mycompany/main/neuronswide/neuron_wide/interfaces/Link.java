package ru.mycompany.main.neuronswide.neuron_wide.interfaces;


/**
 * Интерфейс для связи нейрона
 */
public interface Link {

    double getValue();
    void setState(double state);
    double getMultiplexer() ;
    void setMultiplexer(double multiplexer);
}
