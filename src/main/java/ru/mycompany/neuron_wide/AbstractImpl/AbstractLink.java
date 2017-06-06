package main.java.ru.mycompany.neuron_wide.AbstractImpl;


import main.java.ru.mycompany.neuron_wide.interfaces.Link;

public abstract class AbstractLink implements Link {

    double state = 0 ;
    private double multiplexer;     // коффициент умножения , он же весовой коэффициент

    public double getValue (){
            return multiplexer*state;   //todo подумать головой
    }

    public double getMultiplexer() {
        return multiplexer;
    }

    public void setMultiplexer(double multiplexer) {
        this.multiplexer = multiplexer;
    }

    @Override
    public void setState(double state) {
        this.state = state;
    }


}