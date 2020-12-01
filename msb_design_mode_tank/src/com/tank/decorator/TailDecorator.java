package com.tank.decorator;

import com.tank.GameObject;

import java.awt.*;

/**
 * 加斜线装饰器
 * auther:
 * Date:2020/9/2721:14
 **/
public class TailDecorator extends GODecorator {

    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        
        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawLine(go.x, go.y, go.x + go.getWitch(), go.y + go.getHeight());
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
