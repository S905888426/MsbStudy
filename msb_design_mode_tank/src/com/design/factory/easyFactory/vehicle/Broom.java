package com.design.factory.easyFactory.vehicle;

import com.design.factory.easyFactory.Moveable;

/**
 * 交通工具
 * 扫帚
 */
public class Broom implements Moveable {

    @Override
    public void go() {
        System.out.println("broom flying chuachuachua .....");
    }
}
