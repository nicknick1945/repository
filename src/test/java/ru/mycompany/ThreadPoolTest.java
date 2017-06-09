package test.java.ru.mycompany;

import main.java.ru.mycompany.mutlithreading.Handler;
import main.java.ru.mycompany.mutlithreading.ThreadsPool;
import main.java.ru.mycompany.mutlithreading.exceptions.IlligalThreadsPulSterArgumentsException;
import main.java.ru.mycompany.mutlithreading.interfaces.Task;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.Stack;

/**
 * Created by nick on 07.06.17.
 */
public class ThreadPoolTest {

    Stack<Handler> handlers;
    Stack<Task> tasks;

    @BeforeTest
    private void createHandlersAndTasks() {

        handlers = new Stack<>();
        for (int i = 0; i < 5; i++) {
            handlers.push(new Handler());
        }

        tasks = new Stack<>();
        for (int i = 0; i < 100; i++) {
            tasks.push(new TestTask());
        }

    }

    @Test
    public void threadPoolTest() throws InterruptedException {
        ThreadsPool threadsPool = new ThreadsPool();

        try {
            threadsPool.start(tasks, 6);
            System.out.println("\n \n \n ///////////////Удачно//////////////////////////n \n \n \n ");
            tasks = new Stack<>();
            for (int i = 0; i < 100; i++) {
                tasks.push(new TestTask());
            }
            threadsPool.start(tasks, 6);
            System.out.println("\n \n \n ///////////////Удачно//////////////////////////n \n \n \n ");
            tasks = new Stack<>();
            for (int i = 0; i < 100; i++) {
                tasks.push(new TestTask());
            }
            threadsPool.start(tasks, 10);
            System.out.println("\n \n \n ///////////////Удачно//////////////////////////n \n \n \n ");
            threadsPool.start(tasks, 60);
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }

    @Test(description = "тестирование правильного выброса исключений")
    public void errorsTest(){
        int countPassedTest = 0;
        ThreadsPool threadsPool = new ThreadsPool();
        try {
            threadsPool.start(tasks,0);
        }catch (Exception e){
            if (e.getMessage().equals("события не могут быть выполнены клолличестве потоков <1")) {
                countPassedTest++;
            }
        }

        try {
            threadsPool.start(null,12);
        }catch (Exception e){
            if (e.getMessage().equals("не переданы задачи")) {
                countPassedTest++;
            }
        }

        try {
            threadsPool.start(null,0);
        }catch (Exception e){
            if (e.getMessage().equals(("не переданы задачи + \n" +
                    " события не могут быть выполнены клолличестве потоков <1"))) {
                countPassedTest++;
            }
        }

        Assert.assertEquals(3,countPassedTest);

    }


}
