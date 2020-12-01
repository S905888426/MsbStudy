package com.design.factory.abstractFactory.factory;

import com.design.factory.abstractFactory.basicObject.Food;
import com.design.factory.abstractFactory.basicObject.Vehicle;
import com.design.factory.abstractFactory.basicObject.Weapon;
import com.design.factory.abstractFactory.magic.Broom;
import com.design.factory.abstractFactory.magic.MagicStick;
import com.design.factory.abstractFactory.magic.MushRoom;

/**
 * 魔法世界抽象工厂
 */
public class MagicFactory extends AbstractFactory {
    @Override
    public Food createFood() {
        return new MushRoom();
    }

    @Override
    public Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    public Weapon createWeapon() {
        return new MagicStick();
    }
}
