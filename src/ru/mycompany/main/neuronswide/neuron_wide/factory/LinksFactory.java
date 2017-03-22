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
    public static Link[]  createLinks(int countLinks ,Class  linkImplClass) throws Exception{

        if (!isImplementedLinkInterface(linkImplClass)){
            throw new IlligalTypeException();
        }
        List<Link> links = new ArrayList<>();

        for (int i = 0; i < countLinks; i++){
            links.add( (Link) linkImplClass.newInstance());
        }

        return  (Link[]) links.toArray();
    }

    private  static boolean isImplementedLinkInterface(Class clazz_){
        for (Class clazz : clazz_.getInterfaces()){
            if (clazz.getName().equals(Link.class.getName())){
                return true;
            }
        }
        return false;
    }
}
