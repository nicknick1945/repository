package ru.mycompany.test.layers;

import ru.mycompany.main.neuronswide.neuron_wide.AbstractImpl.AbstractLayer;
import ru.mycompany.main.neuronswide.neuron_wide.AbstractImpl.AbstractNeuronLayers;
import ru.mycompany.main.neuronswide.neuron_wide.exceprions.layersExceprions.DeleteLayerException;
import ru.mycompany.main.neuronswide.neuron_wide.exceprions.layersExceprions.IllegalAddLayerArgumentException;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Adapter;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.NeuronsLayer;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Sample;

public class RemovedTest {

    public boolean testRemoved() throws Exception {

        AbstractNeuronLayers abstractNeuronLayers = new AbstractNeuronLayersImpl();

        AbstractLayerImpl layer1 = new AbstractLayerImpl();
        abstractNeuronLayers.addLayer(layer1);
        AbstractLayerImpl layer2 = new AbstractLayerImpl();
        abstractNeuronLayers.addLayer(layer2);
        AbstractLayerImpl layer3 = new AbstractLayerImpl();
        abstractNeuronLayers.addLayer(layer3);
        AbstractLayerImpl layer4 = new AbstractLayerImpl();
        abstractNeuronLayers.addLayer(layer4);
        AbstractLayerImpl layer5 = new AbstractLayerImpl();
        abstractNeuronLayers.addLayer(layer5);
        AbstractLayerImpl layer6 = new AbstractLayerImpl();
        abstractNeuronLayers.addLayer(layer6);

        System.out.println("Значения заданы ");
        try {
            abstractNeuronLayers.deleteLevel(-1);
        }catch (Exception e){
            System.out.println(e.getMessage());

        }

        try {
            abstractNeuronLayers.deleteLevel(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

        try {
            abstractNeuronLayers.deleteLevel(4);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;

    }




    private class AbstractLayerImpl extends AbstractLayer {

        @Override
        public void learnLevel(Object[]... args) {

        }
    }

    private class AbstractNeuronLayersImpl  extends AbstractNeuronLayers{

        @Override
        public void addLayer(int position, NeuronsLayer layer) throws IllegalAddLayerArgumentException {
        }

        @Override
        public void deleteLevel(NeuronsLayer neuronsLayer) throws DeleteLayerException {
        }

        @Override
        public double[] doRecognize(Sample sample) {
                return new double[0];
        }

        @Override
        public Adapter doRecognize(Adapter adapter, Sample sample) {
            return null;
        }

        @Override
        public void bindLayers(NeuronsLayer layer1, NeuronsLayer layer2) {

        }
    }


}
