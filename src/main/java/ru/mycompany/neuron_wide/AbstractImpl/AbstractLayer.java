package main.java.ru.mycompany.neuron_wide.AbstractImpl;


import main.java.ru.mycompany.neuron_wide.exceprions.layerExceptions.HaveNotPreviousLayerException;
import main.java.ru.mycompany.neuron_wide.exceprions.layerExceptions.HoveNotNextLayerException;
import main.java.ru.mycompany.neuron_wide.interfaces.Neuron;
import main.java.ru.mycompany.neuron_wide.interfaces.NeuronsLayer;


public abstract class AbstractLayer implements NeuronsLayer {

    private Neuron[] neurons ;
    private NeuronsLayer previousLayer;
    private NeuronsLayer nextLayer;

    @Override
    public Object doRecognize(Object sample) throws HaveNotPreviousLayerException {

        if (isFirstLevel()){
            return recognizeFunction(sample);
        }else{
            Object object = getPreviousLayer().doRecognize(sample);
            return recognizeFunction(object);
        }
    }

    //эта функция как раз доолжна проделовать всякие штуки с картами
    protected abstract Object recognizeFunction(Object object);

    @Override
    public abstract  Object learnLevel(Object args) ;

    @Override
    public int getOutputSize() {
        return neurons.length;
    }

    @Override
    public boolean hasNext() {
        return nextLayer == null;
    }

    @Override
    public boolean isFirstLevel() {
        return previousLayer == null;
    }

    @Override
    public boolean isLastLayer(){
        return nextLayer==null;
    }

    @Override
    public NeuronsLayer getNextLayer() throws HoveNotNextLayerException {
        if (!isLastLayer()){
            return nextLayer;
        }else {
            throw  new HoveNotNextLayerException();
        }

    }

    @Override
    public NeuronsLayer getPreviousLayer() throws HaveNotPreviousLayerException {
        if (!isFirstLevel()){
        return previousLayer;
        } else {
            throw new HaveNotPreviousLayerException() ;
        }
    }

    @Override
    public void setPreviousLayer(NeuronsLayer neuronsLayer) {
        this.previousLayer = neuronsLayer;
    }

    @Override
    public void setNextLayer(NeuronsLayer neuronsLayer) {
        this.nextLayer = neuronsLayer ;
    }

    @Override
    public Neuron[] getNeurons() {
        return neurons;
    }

    @Override
    public void setNeurons(Neuron[] neurons) {
        this.neurons = neurons;
    }


}
