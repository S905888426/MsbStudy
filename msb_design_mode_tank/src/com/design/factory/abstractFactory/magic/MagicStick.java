package com.design.factory.abstractFactory.magic;

import com.design.factory.abstractFactory.basicObject.Weapon;

/**
 * 魔法世界
 * 武器 -- 魔法棒
 */
public class MagicStick extends Weapon {
    public void shoot() {
        System.out.println("diandian....");
    }
}
