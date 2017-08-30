package main.java.ru.mycompany.сonvolutional_neural_network.layers;

import main.java.ru.mycompany.neuron_wide.AbstractImpl.AbstractLayer;

/**этот слой предназначен для уменьшения колличества карт фактически он ничего не распознает*/
public class PoolLayer extends AbstractLayer {

    @Override
    protected Object recognizeFunction(Object object) {

        Double[][][] oldCards = (Double[][][]) object;
        Double[][][] newCards = new Double[oldCards.length / 2 + oldCards.length % 2][][];

        for (int i = 0 ; i<newCards.length ; i++){

            if( (2*i + 1) == oldCards.length){
                newCards[i] = convalutions(oldCards[2*i],oldCards[2*i]);
            }else{
                newCards[i] = convalutions(oldCards[2*i],oldCards[2*i+1]);
            }

        }

        return  newCards;
    }

    @Override
    public Object learnLevel(Object args) {
        return null; //todo
    }

    //свертка вдух карт в одну методом выбором максимального из элементов двух соседних карт
    private Double[][] convalutions(Double[][] card1, Double[][] card2) {

        Double[][] newCard = new Double[card1.length][card1[0].length];

        for(int i= 0 ;i < newCard.length ; i++){

            for (int j = 0 ; j< newCard[0].length ; j++){

                newCard[i][j] = Math.max(card1[i][j],card2[i][j]);

            }
        }

        return newCard;
    }


}
