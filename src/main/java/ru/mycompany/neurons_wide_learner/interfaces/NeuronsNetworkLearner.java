package main.java.ru.mycompany.neurons_wide_learner.interfaces;

import main.java.ru.mycompany.neuron_wide.interfaces.LearningSample;
/**
 * Created by nick on 04.06.17.
 */
public interface NeuronsNetworkLearner {

     /**Классы расширяющие данныц интерфейс имеют мининимум одну открытую функцию
      * @param learningSamples набор обучающих семплов
      * @see LearningSample
      * */
     void doLearn(LearningSample[] learningSamples);


     /**Классы расширяющие данныц интерфейс имеют мининимум одну открытую функцию
      * @param learningSamples набор обучающих семплов
      * @see LearningSample
      *
      * @param countEpoch количество эпох обучения на  каждый обучающий сэмпл,
      * так как в некоторых случаях нейронная сеть может никогда недостигнуть требуемх значений
      * */

     void doLearn(LearningSample[] learningSamples, int countEpoch);
}

