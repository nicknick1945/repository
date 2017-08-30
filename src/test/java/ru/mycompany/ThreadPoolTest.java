package test.java.ru.mycompany;

import main.java.ru.mycompany.mutlithreading.concarrencyRealization.CallTask;
import main.java.ru.mycompany.mutlithreading.concarrencyRealization.MyltythreadBucket;
import main.java.ru.mycompany.mutlithreading.myRealization.ThreadsPool;
import main.java.ru.mycompany.mutlithreading.myRealization.interfaces.Task;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.java.ru.mycompany.utils.TestTask;
import test.java.ru.mycompany.utils.TestTask2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

/**
 * Created by nick on 07.06.17.
 */
public class ThreadPoolTest {

    Stack<Task> tasks;
    Collection<CallTask<Object>> callTasks;

    @BeforeTest
    private void createHandlersAndTasks() {

        tasks = new Stack<>();
        for (int i = 0; i < 1000; i++) {
            tasks.push(new TestTask());
        }

        callTasks = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            callTasks.add(new TestTask2<>());
        }

    }

    @Test
    public void timeMultyThreadsMyRealization() {
        try {
            ThreadsPool threadsPool = new ThreadsPool();
            tasks = new Stack<>();
            for (int i = 0; i < 1000; i++) {
                tasks.push(new TestTask());
            }
            System.out.println("4 мои потока");
            System.out.println(Instant.now());
            threadsPool.start(tasks, 4);
            System.out.println(Instant.now());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void timeMultyThreadsConcarrancy() {
        try {
            System.out.println("время работы 4 потоков с помощью конкарренси:");
            System.out.println(Instant.now());
            MyltythreadBucket.calculate(callTasks, 4);
            System.out.println(Instant.now());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test(description = "тестирование правильного выброса исключений")
    public void errorsTest() {
        int countPassedTest = 0;
        ThreadsPool threadsPool = new ThreadsPool();
        try {
            threadsPool.start(tasks, 0);
        } catch (Exception e) {
            if (e.getMessage().equals("события не могут быть выполнены клолличестве потоков <1")) {
                countPassedTest++;
            }
        }

        try {
            threadsPool.start(null, 12);
        } catch (Exception e) {
            if (e.getMessage().equals("не переданы задачи")) {
                countPassedTest++;
            }
        }

        try {
            threadsPool.start(null, 0);
        } catch (Exception e) {
            if (e.getMessage().equals(("не переданы задачи + \n" +
                    " события не могут быть выполнены клолличестве потоков <1"))) {
                countPassedTest++;
            }
        }

        Assert.assertEquals(3, countPassedTest);

    }


}
