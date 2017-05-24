package ru.mycompany.main.neuronswide.neuron_wide.factory;


import ru.mycompany.main.neuronswide.neuron_wide.exceprions.factoryExcptions.IlligalTypeException;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Neuron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Класс фабрика нейронов */
public class NeuronsFactory {

    /**Функция создаёт нейроны передаваемого класса , в переданном колличестве
     * @param countNeurons требуемое колличество нейронов
     * @param neuronsImplClass класс требуемого нейрона
     * @return массив нейронов
     * @throws Exception ну пока не будем запариваться пусть будет так на ui выведем
     *  getMessage () (
     *  он переопределен для каждого из исключений , которые генерятся )
     */
    public static Neuron[] createNeurons(int countNeurons,Class neuronsImplClass) throws Exception {

        Neuron[] neurons   = new Neuron[countNeurons];
        for (int i = 0; i < countNeurons; i++){
            try {
                neurons[i] = ( (Neuron) neuronsImplClass.newInstance());
            }
            catch (Exception e ){
                throw new IlligalTypeException();
            }
        }

        return neurons;
    }
}
