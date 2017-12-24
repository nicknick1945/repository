package main.java.ru.mycompany.neuron_wide.interfaces;

/**
 *  Сам нейрон
 */
public interface Neuron {

    /**
     * вернуть состояние состояние после применения активирующицй фкнции
     * @return
     */
    Object getState();


    /**
     * может вернуть массив своих входов
     * @return массив входов
     *
     */
    Link[] getLinks();

    /**
     * Функция корректировки весов для связей при
     * соединенных к нейрону
     *
     * @param errorSum   общаю ошибка приходящаяся на нейрон
     * @param learnSpeed кожффициент скорости обучения
     */
    void correctWidth(Double errorSum, Double learnSpeed);

    /**
     * Функция добавления связей нейрону
     *
     * @param links
     */
    void setLinks(Link[] links);
}
