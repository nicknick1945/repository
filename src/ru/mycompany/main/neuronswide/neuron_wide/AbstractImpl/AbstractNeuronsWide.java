package ru.mycompany.main.neuronswide.neuron_wide.AbstractImpl;

import ru.mycompany.main.neuronswide.neuron_wide.exceprions.layerExceptions.HaveNotPreviousLayerException;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.*;

public abstract class AbstractNeuronsWide implements NeuronWide {

    private Layers layers;              // нейронные слои
    private int inputSize;              // размер входного векторв

    @Override
    public void doLearn(LearningSample learningSample) {
        layers.learningLevels(learningSample);
    }

    @Override
    public Object doRecognize(Adapter adapter, Sample sample) throws HaveNotPreviousLayerException {
        return adapter.getValue(layers.doRecognize(sample));
    }

    @Override
    public Object doRecognize(Object sample) throws HaveNotPreviousLayerException {
        return layers.doRecognize(sample);
    }

/////////////////////////////геттеры сеттеры //////////////////////////////

    public void setLayers(Layers layers){
        this.layers = layers;
    }

    public Layers getLayers(){
        return layers;
    }

    public int getInputSize() {
        return inputSize;
    }

    public void setInputSize(int inputSize) {
        this.inputSize = inputSize;
    }
}
