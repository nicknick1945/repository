package main.java.ru.mycompany.neuron_wide.AbstractImpl;


import main.java.ru.mycompany.neuron_wide.exceprions.linkExceptions.HaveNotDeltaException;
import main.java.ru.mycompany.neuron_wide.interfaces.Link;
import org.testng.annotations.DataProvider;

public abstract class AbstractLink implements Link {

    private Double state = null;
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

    /**метод корректировки веса , так как для упрощения сделаем всего один поток ,
     *  то можно хранить состояние до следующего вызова*/
    @Override
    public synchronized void  correctWidth(double delta) throws HaveNotDeltaException {

        multiplexer = multiplexer + delta;

    }

}
