package main.java.ru.mycompany.mutlithreading.myRealization.interfaces;

/**
 * @create by nick on 07.06.17.

 * Это интерфейс для задачи , выполняемой пулом потоков
 *  чтобы пул потоков мог выполнить стэк задач , все переданные ему задачи
 *  должны расширять этот интерфейс
 * */
public interface Task {

    /** действие которое будет выполнено в отдельном потоке*/
    void action();
}
