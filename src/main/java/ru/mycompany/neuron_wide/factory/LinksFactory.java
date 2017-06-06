package main.java.ru.mycompany.neuron_wide.factory;

import main.java.ru.mycompany.neuron_wide.exceprions.factoryExcptions.IlligalTypeException;
import main.java.ru.mycompany.neuron_wide.interfaces.Link;

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


