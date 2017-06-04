package ru.mycompany.main.сonvolutional_neural_network;

import ru.mycompany.main.neuronswide.neuron_wide.interfaces.LearningSample;

/**
 * Created by nick on 24.05.17.
 */
public class ConvolutionLearningSample implements LearningSample {

    double[][] input;
    double[] out ;

    @Override
    public Object getInput() {
        return input;
    }

    @Override
    public Object getOut() {
        return out ;
    }

    public void setInput(double[][] input) {
        this.input = input;
    }

    public void setOut(double[] out) {
        this.out = out;
    }
}
