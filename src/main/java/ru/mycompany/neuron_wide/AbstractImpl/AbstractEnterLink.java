package main.java.ru.mycompany.neuron_wide.AbstractImpl;

import main.java.ru.mycompany.neuron_wide.interfaces.Link;

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
