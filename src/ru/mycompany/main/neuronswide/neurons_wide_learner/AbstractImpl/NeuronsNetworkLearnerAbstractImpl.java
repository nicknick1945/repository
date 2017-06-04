package ru.mycompany.main.neuronswide.neurons_wide_learner.AbstractImpl;

import ru.mycompany.main.neuronswide.neuron_wide.interfaces.LearningSample;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.NeuronNetwork;
import ru.mycompany.main.neuronswide.neurons_wide_learner.interfaces.NeuronsNetworkLearner;

/**
 * Created by nick on 04.06.17.
 */
public class NeuronsNetworkLearnerAbstractImpl implements NeuronsNetworkLearner{

    /**Ошибки нейронов на каждом из уровней при обратном распространении ошибки*/
    private double[] neuronError;
    /**Ошибки каждой всязи на каждом из уровней*/
    private double[][] linksErrors;
    /**Собственно нейросеть*/
    private NeuronNetwork neuronNetwork;

    /**конструктор в качестве аргумента полкчаем нейросеть*/
    public NeuronsNetworkLearnerAbstractImpl(NeuronNetwork neuronNetwork) {
        this.neuronNetwork = neuronNetwork;
    }

    @Override
    public void doLearn(LearningSample[] learningSample) {

    }

    private void upError(){

    }

    private void corectingWidth(){

    }

    private void learnEpohe(){

    }
}
