package com.tank.decorator;

import com.tank.GameObject;

import java.awt.*;

/**
 * 装饰器模式 应用
 * auther:
 * Date:2020/9/27 21:12
 **/
public abstract class GODecorator  extends GameObject {

    GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);


}
