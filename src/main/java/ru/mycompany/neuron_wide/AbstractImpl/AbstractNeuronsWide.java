package main.java.ru.mycompany.neuron_wide.AbstractImpl;

import main.java.ru.mycompany.neuron_wide.exceprions.CannotRecognizeThisTypeException;
import main.java.ru.mycompany.neuron_wide.exceprions.layerExceptions.HaveNotPreviousLayerException;
import main.java.ru.mycompany.neuron_wide.interfaces.*;

public abstract class AbstractNeuronsWide implements NeuronNetwork {

    private static final int IMAGE_LENGTH = 128;
    private static final int IMAGE_HEIGHT = 188;
    private Layers layers;              // нейронные слои
    private int inputSize;              // размер входного векторв

    @Override
    public void doLearn(LearningSample learningSample) throws HaveNotPreviousLayerException {
        layers.learningLevels(learningSample);
    }

    @Override
    public Object doRecognize(Adapter adapter, Sample sample) throws HaveNotPreviousLayerException {
        return adapter.getValue(layers.doRecognize(sample));
    }

    @Override
    public Object doRecognize(Object sample) throws HaveNotPreviousLayerException, CannotRecognizeThisTypeException {

        if ( sample instanceof Double[][]){
            if ((((Double[][]) sample).length != IMAGE_HEIGHT) && (((Double[][]) sample)[0].length != IMAGE_LENGTH)) {
                throw new CannotRecognizeThisTypeException();
            }
        } else {
            throw new RuntimeException("не верный тип данных передан на вход нейронной сети");
        }
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
