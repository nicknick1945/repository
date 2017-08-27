package main.java.ru.mycompany.neuron_wide.factory;

import main.java.ru.mycompany.neuron_wide.exceprions.factoryExcptions.IlligalTypeException;
import main.java.ru.mycompany.neuron_wide.interfaces.Link;

/** Сознает свзяси
 * Created by Nick on 20.03.2017.
 */

public class LinksFactory {

    private static final int MAX_LINK_WIDTH = 2;

    public static Link[] createLinks(int countLinks, Class linkImplClass) throws Exception {

        Link[] links = new Link[countLinks];
        boolean isPlus = true;      //добавлен для того чтобы веса инициализировались равномерно от -2 до 2

        for (int i = 0; i < countLinks; i++) {
            try {
                links[i] = ((Link) linkImplClass.newInstance());
                links[i].setMultiplexer(isPlus ? Math.random() * MAX_LINK_WIDTH : -Math.random() * MAX_LINK_WIDTH);
                isPlus = !isPlus;
            }catch (Exception e){
                throw new IlligalTypeException();
            }
        }
        return links;
    }
}


