package com.design.factory.abstractFactory.factory;

import com.design.factory.abstractFactory.basicObject.Food;
import com.design.factory.abstractFactory.basicObject.Vehicle;
import com.design.factory.abstractFactory.basicObject.Weapon;

/**
 * 基础抽象工厂
 */
public abstract class AbstractFactory {
    public abstract Food createFood();
    public abstract Vehicle createVehicle();
    public abstract Weapon createWeapon();
}
