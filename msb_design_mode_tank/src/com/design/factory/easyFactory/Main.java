package com.design.factory.easyFactory;

import com.design.factory.easyFactory.factory.CarFactory;

/**
 * 简单工厂(工厂方法) DEMO
 */
public class Main {
    public static void main(String[] args) {
        Moveable m = new CarFactory().create();
        m.go();
    }
}
