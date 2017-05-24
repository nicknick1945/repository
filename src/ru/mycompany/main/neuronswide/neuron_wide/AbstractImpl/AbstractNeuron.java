package ru.mycompany.main.neuronswide.neuron_wide.AbstractImpl;

import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Link;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Neuron;

public abstract class AbstractNeuron implements Neuron{

    private Link[] links;

    protected double doActivationFunction() {
        double summ = 0;
        for (Link link : getLinks()) {
            summ = summ + link.getValue();
        }
        return 1 / (1 + Math.exp(-summ));
    }

    @Override
    public Object getState() {
         return doActivationFunction();
    }



    public Link[] getLinks() {
        return links;
    }

    public void setLinks(Link[] links) {
        this.links = links;
    }

}
