package com.tank;

import java.awt.*;

/**
 * auther:
 * Date:2020/9/2221:43
 **/
public abstract class GameObject {

    public int x, y;

    public abstract void paint(Graphics g);

    public abstract int getWitch();
    public abstract int getHeight();

}
