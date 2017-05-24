package ru.mycompany.test.something;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MethodSelector implements InvocationHandler {

    private Object proxied;

    public MethodSelector (Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("interesting")){
            System.out.println("Proxy Detected  interesting method");
        }else System.out.println("говно ваш метод");
        return method.invoke(proxied,args);
    }
}


