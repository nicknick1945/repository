package ru.mycompany.main.neuronswide.neuron_wide.AbstractImpl;

import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Link;

public abstract class AbstractEnterLink implements Link {

    double value = 0;
    public void setValue(double value){
        this.value = value;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
