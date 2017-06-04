package ru.mycompany.main.neuronswide.neurons_wide_learner.AbstractImpl;

import ru.mycompany.main.neuronswide.neuron_wide.interfaces.*;
import ru.mycompany.main.neuronswide.neurons_wide_learner.exceptions.NotMatchCountNeuronsOutAndSamplOut;
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
    //Коэффициент скорости обученя
    private double learningSpeed = 0.001;

    /**конструктор в качестве аргумента полкчаем нейросеть*/
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
    protected void learnLimitedEpoch(LearningSample[] learningSamples,double delta){

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

    protected void setLearningSpeed(double learnSpeed){
        this.learningSpeed = learnSpeed;
    }

    /**Функция рассчета ошики уровня */
    protected double[] calculateLayerErrors(NeuronsLayer neuronsLayer,double[] targerResult) throws Exception {

        Neuron[] neurons = neuronsLayer.getNeurons();
        double[] errors = new double[neurons.length];

        if (neurons.length != targerResult.length) {
            throw  new NotMatchCountNeuronsOutAndSamplOut();
        }

        for(int i = 0 ; i < neurons.length ; i ++){
            errors[i] = targerResult[i] - (double)neurons[i].getState();
        }
        return errors;
    }

}
