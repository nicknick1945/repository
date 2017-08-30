package main.java.ru.mycompany.сonvolutional_neural_network;

import main.java.ru.mycompany.neuron_wide.interfaces.LearningSample;

/**
 * Created by nick on 24.05.17.
 */
public class ConvolutionLearningSample implements LearningSample {

    Double[][] input;
    Double[] out;

    @Override
    public Object getInput() {
        return input;
    }

    @Override
    public Object getOut() {
        return out ;
    }

    public void setInput(Double[][] input) {
        this.input = input;
    }

    public void setOut(Double[] out) {
        this.out = out;
    }
}
