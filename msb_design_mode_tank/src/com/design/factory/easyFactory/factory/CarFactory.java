package com.design.factory.easyFactory.factory;

import com.design.factory.easyFactory.Moveable;
import com.design.factory.easyFactory.vehicle.Car;

/**
 * 汽车的工厂类
 */
public class CarFactory {
    public Moveable create() {
        System.out.println("a car created!");
        return new Car();
    }
}
