package com.design.factory.abstractFactory;

import com.design.factory.abstractFactory.basicObject.Food;
import com.design.factory.abstractFactory.basicObject.Vehicle;
import com.design.factory.abstractFactory.basicObject.Weapon;
import com.design.factory.abstractFactory.factory.AbstractFactory;
import com.design.factory.abstractFactory.factory.ScienceFactory;

/**
 * 抽象工厂 DEMO
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory f = new ScienceFactory();

        Vehicle c =  f.createVehicle();
        c.go();
        Weapon w = f.createWeapon();
        w.shoot();
        Food b = f.createFood();
        b.printName();
    }
}
