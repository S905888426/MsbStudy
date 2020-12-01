package com.tank.model;

import com.tank.*;
import com.tank.enums.DirEnum;

import java.awt.*;

/**
 * 子弹类
 * auther:
 * Date:2020/8/3122:03
 **/
public class Bullet extends GameObject {

    /**
     * 初始方向
     */
    public DirEnum dir;
    /**
     * 初始速度
     */
    public static final int SPEED = Integer.parseInt((String) PropertyMgr.get("bulletSpeed"));
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();

    public Rectangle rectangle = new Rectangle();

    /**
     * 子弹状态
     */
    public boolean living = true;

    public Group group = Group.BAD;

    public Bullet(int x, int y, DirEnum dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        GameModel.getInstance().add(this);
    }

    /**
     * 子弹本体
     * @param g
     */
    public void paint(Graphics g) {

        if(!living){
            GameModel.getInstance().remove(this);
        }

        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }

        move();

    }

    @Override
    public int getWitch() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    /**
     * 改变方向
     */
    public void move() {

        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        // update rectangle
        rectangle.x = this.x;
        rectangle.y = this.y;

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;

    }

    public void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
