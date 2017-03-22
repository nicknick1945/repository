package ru.mycompany.main.neuronswide.neuron_wide.factory;


import ru.mycompany.main.neuronswide.neuron_wide.exceprions.factoryExcptions.IlligalTypeException;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Neuron;

import java.util.ArrayList;
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

        if (!isImplementedNeuronInterface(neuronsImplClass)){
            throw  new IlligalTypeException();
        }
        List<Neuron> neurons = new ArrayList<>();
        for (int i = 0; i < countNeurons; i++){
            neurons.add( (Neuron) neuronsImplClass.newInstance());
        }

        return  (Neuron[]) neurons.toArray();
    }


    private  static boolean isImplementedNeuronInterface(Class clazz_){
        for (Class clazz : clazz_.getInterfaces()){
            if (clazz.getName().equals(Neuron.class.getName())){
                return true;
            }
        }
        return false;
    }

}
