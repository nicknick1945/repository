package ru.mycompany.main.neuronswide.neuron_wide.AbstractImpl;


import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Link;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Neuron;

public abstract class AbstractLink implements Link {

    private Neuron enterNeuron;     //нейрон выход которого подается на вход связи
    private double multiplexer;     // коффициент умножения , он же весовой коэффициент

    public double getValue (double enterValue){
            return  enterValue*multiplexer;
    }

    public double getMultiplexer() {
        return multiplexer;
    }

    public void setMultiplexer(double multiplexer) {
        this.multiplexer = multiplexer;
    }

    public Neuron getEnterNeuron() {
        return enterNeuron;
    }

    public void setEnterNeuron(Neuron enterNeuron) {
        this.enterNeuron = enterNeuron;
    }
}
