package main.java.ru.mycompany.neurons_wide_learner.AbstractImpl;

import main.java.ru.mycompany.neuron_wide.interfaces.LearningSample;
import main.java.ru.mycompany.neuron_wide.interfaces.Neuron;
import main.java.ru.mycompany.neuron_wide.interfaces.NeuronNetwork;
import main.java.ru.mycompany.neuron_wide.interfaces.NeuronsLayer;
import main.java.ru.mycompany.neurons_wide_learner.exceptions.NotMatchCountNeuronsOutAndSamplOut;
import main.java.ru.mycompany.neurons_wide_learner.interfaces.NeuronsNetworkLearner;

/**
 * Created by nick on 04.06.17.
 */
public class NeuronsNetworkLearnerAbstractImpl implements NeuronsNetworkLearner{

    /**Ошибки нейронов на каждом из уровней при обратном распространении ошибки*/
    private Double[] neuronError;
    /**Ошибки каждой всязи на каждом из уровней*/
    private Double[][] linksErrors;
    /**Собственно нейросеть*/
    private NeuronNetwork neuronNetwork;
    //Коэффициент скорости обученя
    private Double learningSpeed = 0.001;

    /**
     * конструктор в качестве аргумента получаем нейросеть
     */
    public NeuronsNetworkLearnerAbstractImpl(NeuronNetwork neuronNetwork) {
        this.neuronNetwork = neuronNetwork;
    }

    @Override
    public void doLearn(LearningSample[] learningSample) {

    }

    @Override
    public void doLearn(LearningSample[] learningSamples, int countEpoch) {
        for(int i = 0 ; i < countEpoch ; i ++ ){
            learnEpoch(learningSamples);
        }
    }

    /**Этпоха обучения для обучения без лимита эпох,
     * обучение ведется до тех пор пока разнца между требуемым вызодом
     * и реальных не станем меньше переменной delta
     * @patam delta ошибка при одстижении которой прекращается обучение
     *
     * */
    protected void learnLimitedEpoch(LearningSample[] learningSamples,Double delta){

    }

    /**метод поднятия ошибки , зополняет массив ошибок каждого уровня*/
    protected void upError(){

    }

    /**метод корректировки весов*/
    protected void correctingWidth(){

    }

    /**Эпоха обучения для метода обучения с лимитированным колличеством эпох*/
    protected double[] learnEpoch(LearningSample[] learningSamples){
        return null; // todo переписать когда напиешь функцию
    }

    protected double getLearningSpeed(){
        return learningSpeed;
    }

    protected void setLearningSpeed(Double learnSpeed){
        this.learningSpeed = learnSpeed;
    }

    /**Функция рассчета ошики уровня */
    protected Double[] calculateLayerErrors(NeuronsLayer neuronsLayer, Double[] targerResult) throws Exception {

        Neuron[] neurons = neuronsLayer.getNeurons();
        Double[] errors = new Double[neurons.length];

        if (neurons.length != targerResult.length) {
            throw  new NotMatchCountNeuronsOutAndSamplOut();
        }

        for(int i = 0; i < neurons.length; i++) {
            errors[i] = targerResult[i] - (Double) neurons[i].getState();
        }
        return errors;
    }

}
