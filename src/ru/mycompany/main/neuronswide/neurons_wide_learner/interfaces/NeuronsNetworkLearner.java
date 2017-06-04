package ru.mycompany.main.neuronswide.neurons_wide_learner.interfaces;

import ru.mycompany.main.neuronswide.neuron_wide.interfaces.LearningSample;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.NeuronNetwork;

/**
 * Created by nick on 04.06.17.
 */
public interface NeuronsNetworkLearner {

     /**Классы расширяющие данныц интерфейс имеют мининимум одну открытую функцию
      * @param learningSamples набор обучающих семплов
      * @see LearningSample
      * */
     void doLearn(LearningSample[] learningSamples);

}

