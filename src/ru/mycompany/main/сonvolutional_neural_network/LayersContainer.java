package ru.mycompany.main.сonvolutional_neural_network;

import ru.mycompany.main.neuronswide.neuron_wide.AbstractImpl.AbstractNeuronLayers;
import ru.mycompany.main.neuronswide.neuron_wide.exceprions.layersExceprions.DeleteLayerException;
import ru.mycompany.main.neuronswide.neuron_wide.exceprions.layersExceprions.IllegalAddLayerArgumentException;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Adapter;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.NeuronsLayer;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Sample;


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
