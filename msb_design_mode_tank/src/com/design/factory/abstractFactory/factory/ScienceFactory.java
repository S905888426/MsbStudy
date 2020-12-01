package com.design.factory.abstractFactory.factory;


import com.design.factory.abstractFactory.basicObject.Food;
import com.design.factory.abstractFactory.basicObject.Vehicle;
import com.design.factory.abstractFactory.basicObject.Weapon;
import com.design.factory.abstractFactory.science.Bread;
import com.design.factory.abstractFactory.science.Car;
import com.design.factory.abstractFactory.science.Firearm;

/**
 * 科学世界抽象工厂
 */
public class ScienceFactory extends AbstractFactory {
    @Override
    public Food createFood() {
        return new Bread();
    }

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapon createWeapon() {
        return new Firearm();
    }
}
