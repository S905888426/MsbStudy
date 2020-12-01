package com.tank.decorator;

import com.tank.GameObject;

import java.awt.*;

/**
 * 加方框装饰器
 * auther:
 * Date:2020/9/2721:14
 **/
public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;

        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawRect(super.go.x, super.go.y, super.go.getWitch(), super.go.getHeight());
        g.setColor(c);

    }

    @Override
    public int getWitch() {
        return super.go.getWitch();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }

}
