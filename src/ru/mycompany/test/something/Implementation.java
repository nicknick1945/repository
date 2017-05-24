package ru.mycompany.test.something;

public class Implementation implements SomeInterface {

    Implementation(){}


    @Override
    public void boring1() {
        System.out.println("вызван скучный метод 1 ");
    }

    @Override
    public void boring2() {
        System.out.println("вызван скучный метод 2 ");
    }

    @Override
    public void boring3() {
        System.out.println("вызван скучный метод 3 ");
    }

    @Override
    public void boring4() {
        System.out.println("вызван скучный метод 4 ");
    }

    @Override
    public void interesting() {
        System.out.println("Вызван интерестный метод ");
    }
}
