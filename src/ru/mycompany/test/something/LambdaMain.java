package ru.mycompany.test.something;

import java.lang.reflect.Proxy;

/**
 * Created by nick on 03.04.17.
 */
public class LambdaMain {


    public static void main(String[] args) {

        SomeInterface proxyInstance =(SomeInterface) Proxy.newProxyInstance(
                SomeInterface.class.getClassLoader()
                ,new Class[]{SomeInterface.class}
                ,new MethodSelector(new Implementation())
        );

        proxyInstance.boring1();
        proxyInstance.boring2();
        proxyInstance.boring3();
        proxyInstance.boring4();
        proxyInstance.interesting();

    }

}
