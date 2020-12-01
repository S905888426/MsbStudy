package com.tank.model;

import com.tank.GameModel;
import com.tank.GameObject;
import com.tank.ResourceMgr;

import java.awt.*;

/**
 * 爆炸
 * auther:
 * Date:2020/8/3122:03
 **/
public class Explode  extends GameObject {

    /**
     * 初始速度
     */
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();
    public int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;

        GameModel.getInstance().add(this);
    }

    public void paint(Graphics g) {

        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if(step >= ResourceMgr.explodes.length){
            GameModel.getInstance().remove(this);
        }



    }

    @Override
    public int getWitch() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

}
