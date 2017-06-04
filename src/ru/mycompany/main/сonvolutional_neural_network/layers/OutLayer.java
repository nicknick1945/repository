package ru.mycompany.main.сonvolutional_neural_network.layers;

import ru.mycompany.main.neuronswide.neuron_wide.AbstractImpl.AbstractLayer;
import ru.mycompany.main.сonvolutional_neural_network.ConvolutionLearningSample;


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
        double[] arr = ((double[][][])object)[0][0];
        double[] outArr = new double[getNeurons().length];
        for(int j = 0 ; j< getNeurons().length ; j++){
            for(int i = 0 ; i < getNeurons()[j].getLinks().length ; i++){
                getNeurons()[j].getLinks()[i].setState(arr[i]);
            }
            outArr[j] = (double)getNeurons()[j].getState();
        }
        return outArr;
    }
}
