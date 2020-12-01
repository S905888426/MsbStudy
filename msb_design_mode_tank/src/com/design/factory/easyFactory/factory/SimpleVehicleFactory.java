package com.design.factory.easyFactory.factory;

import com.design.factory.easyFactory.vehicle.Broom;
import com.design.factory.easyFactory.vehicle.Car;

/**
 * 简单工厂的可扩展性不好
 * 交通工具的工厂类
 */
public class SimpleVehicleFactory {
    public Car createCar() {
        //before processing
        return new Car();
    }

    public Broom createBroom() {
        return new Broom();
    }
}
