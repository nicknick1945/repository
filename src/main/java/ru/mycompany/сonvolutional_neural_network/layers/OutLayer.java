package main.java.ru.mycompany.сonvolutional_neural_network.layers;

import main.java.ru.mycompany.neuron_wide.AbstractImpl.AbstractLayer;
import main.java.ru.mycompany.сonvolutional_neural_network.ConvolutionLearningSample;


/**
 * Это выходной слой , с ним нужно быть очень аккуратным
 * число связей должно соответствовать количеству масок в пред выходном слое
 * количесво нейровно должно соответствовать числу искомых образов
 * так же в пред выходной слой должен выдвать маски исключительно размера 1*1
 * для него подойдут ConvolutionNeurons
 */
public class OutLayer extends AbstractLayer {

    @Override
    public Object learnLevel(Object args) {

        ConvolutionLearningSample cls = (ConvolutionLearningSample)args;

        for (int i = 0 ; i < getNeurons().length ; i++){
        }

        return null ; //todo
    }

    protected Object recognizeFunction(Object object){
        Double[] arr = ((Double[][][]) object)[0][0];
        Double[] outArr = new Double[getNeurons().length];
        for(int j = 0 ; j< getNeurons().length ; j++){
            for(int i = 0 ; i < getNeurons()[j].getLinks().length ; i++){
                getNeurons()[j].getLinks()[i].setState(arr[i]);
            }
            outArr[j] = (Double) getNeurons()[j].getState();
        }
        return outArr;
    }
}
