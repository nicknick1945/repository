package main.java.ru.mycompany.сonvolutional_neural_network.layers;

import main.java.ru.mycompany.neuron_wide.AbstractImpl.AbstractLayer;



/**данынй слой нужен для уменьшения размеров карт */
public class SubsamplingLayer extends AbstractLayer{

    @Override
    protected Object recognizeFunction(Object object) {

        double[][][] oldCards = (double[][][])object;
        int height =  oldCards[0].length/2 + oldCards[0].length%2 ;
        int widht = oldCards[0][0].length/2 + oldCards[0][0].length%2 ;
        double[][][] newCards = new double[oldCards.length][height][widht];

        for(int i = 0 ; i < oldCards.length ; i++ ){

            for(int y = 0 ; y < newCards[0].length ; y++ ){

                for( int x = 0 ; x < newCards[0][0].length ; x++ ){

                    double max  = 0 ;
                    double maxX = 0 ;
                    double maxY = 0 ;

                    if (2*y + 1 ==  oldCards[0].length){
                        maxY =  oldCards[i][2*y][2*x];
                    }else{
                        maxY = Math.max(oldCards[i][2*y][2*x],oldCards[i][2*y+1][2*x]);
                    }

                    if (2*x + 1 ==  oldCards[0][0].length){
                        maxX =  oldCards[i][2*y][2*x];
                    }else{
                        maxX = Math.max(oldCards[i][2*y][2*x],oldCards[i][2*y][2*x+1]);
                    }

                    max = Math.max(maxX,maxY);
                    newCards[i][y][x]  = max ;

                }

            }
        }

        return newCards;
    }

    @Override
    public Object learnLevel(Object args) {
        return null; //todo
    }
}
