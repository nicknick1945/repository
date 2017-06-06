package main.java.ru.mycompany.сonvolutional_neural_network;

import main.java.ru.mycompany.neuron_wide.AbstractImpl.AbstractNeuronLayers;
import main.java.ru.mycompany.neuron_wide.exceprions.layersExceprions.DeleteLayerException;
import main.java.ru.mycompany.neuron_wide.exceprions.layersExceprions.IllegalAddLayerArgumentException;
import main.java.ru.mycompany.neuron_wide.interfaces.Adapter;
import main.java.ru.mycompany.neuron_wide.interfaces.NeuronsLayer;
import main.java.ru.mycompany.neuron_wide.interfaces.Sample;


/**Класс реализующий список нейронных слоев*/
public class LayersContainer extends AbstractNeuronLayers {

    public LayersContainer() throws Exception {

    }

    @Override
    public void addLayer(int position, NeuronsLayer layer) throws IllegalAddLayerArgumentException {

    }

    @Override
    public void deleteLevel(NeuronsLayer neuronsLayer) throws DeleteLayerException {

    }

    @Override
    public Adapter doRecognize(Adapter adapter, Sample sample) {
        return null;
    }

}
