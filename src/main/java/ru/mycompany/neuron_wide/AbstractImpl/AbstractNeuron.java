package main.java.ru.mycompany.neuron_wide.AbstractImpl;

import main.java.ru.mycompany.neuron_wide.interfaces.Link;
import main.java.ru.mycompany.neuron_wide.interfaces.Neuron;

public abstract class AbstractNeuron implements Neuron{

    private Link[] links;


    protected Double doActivationFunction() {
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

    public void correctWidth(Double errorSum, Double learnSpeed) {
        for (Link link : links) {
            Double odlMultiplexer = link.getMultiplexer();
            Double newMultiplexer = odlMultiplexer + ((Double) getState() * (1D - (Double) getState())) * errorSum * learnSpeed;
            link.setMultiplexer(newMultiplexer);
        }
    }


    public Link[] getLinks() {
        return links;
    }

    public void setLinks(Link[] links) {
        this.links = links;
    }

}
