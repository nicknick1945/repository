package main.java.ru.mycompany.сonvolutional_neural_network.layers;

import main.java.ru.mycompany.neuron_wide.AbstractImpl.AbstractLayer;
import main.java.ru.mycompany.neuron_wide.interfaces.Link;
import main.java.ru.mycompany.neuron_wide.interfaces.Neuron;


public class ConvolutionLayer extends AbstractLayer {

    @Override
    public Object learnLevel(Object args) {
      return null ; //todo
    }

    //напомню , что трехмерный массив , потому , что тут может быть много двумерных карт признаков
    @Override
    protected Object recognizeFunction(Object object) {
        Double[][][] arr = (Double[][][]) object;      // массив карт с предыдущего слоя
        int countNewCards = getNeurons().length*arr.length;     //количество карт , которое планирутся получить
        Double[][][] newCards = new Double[countNewCards][arr[0].length][arr[0][0].length];
        int cardСounter = 0;// порядковый номер вставляемой карты


        for (Neuron neuron : getNeurons()) {
            //выполнить для всех карт
            for (Double[][] anArr : arr) {

                Double[][] newCard = new Double[anArr.length][anArr[0].length];
                Double[][] cardToPars = cardConventing(anArr);

                Link[] links = neuron.getLinks();

                for (int y = 1; y < cardToPars.length - 1; y++) {

                    for (int x = 1; x < cardToPars[0].length - 1; x++) {

                        //установим значения на связи нейрона
                        links[0].setState(cardToPars[y - 1][x - 1]);
                        links[1].setState(cardToPars[y - 1][x]);
                        links[2].setState(cardToPars[y - 1][x + 1]);
                        links[3].setState(cardToPars[y][x - 1]);
                        links[4].setState(cardToPars[y][x]);
                        links[5].setState(cardToPars[y][x + 1]);
                        links[6].setState(cardToPars[y + 1][x - 1]);
                        links[7].setState(cardToPars[y + 1][x]);
                        links[8].setState(cardToPars[y + 1][x + 1]);

                        newCard[y - 1][x - 1] = (double) neuron.getState();

                    }

                }

                newCards[cardСounter] = newCard;
                cardСounter++;

            }

        }

        return newCards;

    }

    /*этот метод преобразует карту , в карту большего размера для избежания краевых эффектов*/
    private Double[][] cardConventing(Double[][] card) {

        Double[][] conventedCard = new Double[card.length + 2][card[0].length + 2];

        for (int y = 0 ; y < card.length ; y++) {
            System.arraycopy(card[y], 0, conventedCard[y + 1], 1, card.length);
        }

        for (int y = 0 ; y < card.length ; y++){
            conventedCard[y+1][0] = card[y][0];
            conventedCard[y+1][conventedCard[0].length-1] = card[y][card.length-1];
        }

        for (int x = 0 ; x < card[0].length ; x++){
            conventedCard[0][x+1] = card[0][x];
            conventedCard[conventedCard.length-1][x+1] = card[card.length-1][x];
        }
        conventedCard[0][0] = card[0][0];
        conventedCard[conventedCard.length-1][conventedCard[0].length-1] = card[card.length-1][card[0].length-1];
        conventedCard[0][conventedCard[0].length-1] = card[0][card[0].length-1];
        conventedCard[conventedCard.length-1][0] = card[card.length-1][0];

        return conventedCard;
    }

}
