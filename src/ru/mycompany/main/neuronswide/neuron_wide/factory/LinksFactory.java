package ru.mycompany.main.neuronswide.neuron_wide.factory;

import ru.mycompany.main.neuronswide.neuron_wide.exceprions.factoryExcptions.IlligalTypeException;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Link;
import ru.mycompany.main.neuronswide.neuron_wide.interfaces.Neuron;

import java.util.ArrayList;
import java.util.List;

/** Сознает свзяси
 * Created by Nick on 20.03.2017.
 */

public class LinksFactory {

    public static Link[] createLinks(int countLinks, Class linkImplClass) throws Exception {

        Link[] links = new Link[countLinks];
        boolean isPlus = true;
        for (int i = 0; i < countLinks; i++) {
            try {
                links[i] = ((Link) linkImplClass.newInstance());
                links[i].setMultiplexer(isPlus?Math.random()*2:-Math.random()*2);
                isPlus = !isPlus;
            }catch (Exception e){
                throw new IlligalTypeException();
            }
        }
        return links;
    }
}


