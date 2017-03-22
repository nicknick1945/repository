package ru.mycompany.test.layers;


import java.time.Instant;
import java.util.Date;

public class LayersTest {


    public static void  main(String[] args) throws Exception {



        RemovedTest removedTest = new RemovedTest();

        if(removedTest.testRemoved()){
            System.out.println("Тест удачен");
        }else  {
            System.out.println((char)27 + "[31m" + Date.from(Instant.now())+ " Тест не пройден");
        }

        log("здесь выведена красная надпись");

    }

    private  static void log(String message){
        System.out.println((char)27 + "[31m" + Date.from(Instant.now())+" " + message);
    }




}
