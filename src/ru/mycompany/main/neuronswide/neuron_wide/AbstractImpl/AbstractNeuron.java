package ru.mycompany.main.neuronswide.neuron_wide.AbstractImpl;

import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Link;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Neuron;

public abstract class AbstractNeuron implements Neuron{

    private Link[] links;
    private double state = 0;

    protected abstract double doActivationFunction();

    @Override
    public double getState() {
         return doActivationFunction();
    }

    @Override
    public void setState() {
        this.state = state;
    }

    public Link[] getLinks() {
        return links;
    }

    public void setLinks(Link[] abstractLinks) {
        this.links = abstractLinks;
    }

}
