package main.java.ru.mycompany.neuron_wide.AbstractImpl;

import main.java.ru.mycompany.neuron_wide.interfaces.Link;

public abstract class AbstractEnterLink implements Link {

    Double value = 0D;

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public Double getValue() {
        return 0D;
    }
}
