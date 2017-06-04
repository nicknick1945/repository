package ru.mycompany.test.testNG;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mycompany.main.neuronswide.neuron_wide.factory.LinksFactory;
import ru.mycompany.main.neuronswide.neuron_wide.factory.NeuronsFactory;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Layers;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Neuron;
import ru.mycompany.main.сonvolutional_neural_network.ConvolutionLink;
import ru.mycompany.main.сonvolutional_neural_network.ConvolutionNeuralNetWork;
import ru.mycompany.main.сonvolutional_neural_network.ConvolutionNeuron;
import ru.mycompany.main.сonvolutional_neural_network.layers.ConvolutionLayer;
import ru.mycompany.main.сonvolutional_neural_network.layers.PoolLayer;
import ru.mycompany.main.сonvolutional_neural_network.layers.SubsamplingLayer;
import  static org.testng.Assert.*;


public class ConvalutionNeuronsNetworkTest {


    ConvolutionNeuralNetWork cnn ;      //нейросеть
    double[][][] enterArr;              //эмуляция входных данных

    @BeforeMethod()
    public void createNetWork() throws Exception {
        cnn= new ConvolutionNeuralNetWork();
        Layers layers =  cnn.getLayers();
        ConvolutionLayer convolutionLayer = new ConvolutionLayer();
        convolutionLayer.setNeurons(NeuronsFactory.createNeurons(10, ConvolutionNeuron.class));
        for(Neuron neuron:convolutionLayer.getNeurons()){
            neuron.setLinks(LinksFactory.createLinks(9, ConvolutionLink.class));
        }

        layers.addLayer(convolutionLayer);
        PoolLayer poolLayer = new PoolLayer();
        layers.addLayer(poolLayer);
        SubsamplingLayer subsamplingLayer = new SubsamplingLayer();
        layers.addLayer(subsamplingLayer);

        enterArr = new double[1][100][100];
        for (int i = 0; i < enterArr.length ; i++ ){
            for(int j = 0; j < enterArr[0].length; j++){
                for(int k = 0; k < enterArr[0][0].length; k++){
                    enterArr[i][j][k] = Math.random()*23;
                }
            }
        }

        ConvolutionLayer convolutionLayer1 = new ConvolutionLayer();

        convolutionLayer1.setNeurons(NeuronsFactory.createNeurons(10, ConvolutionNeuron.class));
        for(Neuron neuron:convolutionLayer1.getNeurons()){
            neuron.setLinks(LinksFactory.createLinks(9, ConvolutionLink.class));
        }

        layers.addLayer(convolutionLayer1);
        PoolLayer poolLayer1 = new PoolLayer();
        layers.addLayer(poolLayer1);
        SubsamplingLayer subsamplingLayer1 = new SubsamplingLayer();
        layers.addLayer(subsamplingLayer1);

    }

    @Test(description = "Проверка работы слоев вертки (на кождом наборе слоев " +
            ", размер карт должен уменьшаться в двое,наборы состоят из 3-х слоев)")
    public void test1() throws Exception {


        double[][][] resultArray  = (double[][][])cnn.doRecognize(enterArr);
        assertEquals(resultArray[0].length, enterArr[0].length/( ( cnn.getLayers().getSize() / 3 ) *2 ) );
        assertEquals(resultArray[0][0].length, enterArr[0][0].length/( ( cnn.getLayers().getSize()/3 ) *2 ) );

        System.out.println("hellow");
    }


}
