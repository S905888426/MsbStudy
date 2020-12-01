package com.tank.model;

import com.tank.*;
import com.tank.enums.DirEnum;
import com.tank.strategy.DefaultFireStrategy;
import com.tank.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * 坦克类
 * auther:
 * Date:2020/8/3121:35
 **/
public class Tank extends GameObject {

    public int oldx, oldy;

    /**
     * 初始方向
     */
    public DirEnum dir = DirEnum.DOWN;
    /**
     * 初始速度
     */
    public static final int SPEED = 5;

    public static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankU.getHeight();

    public Rectangle rectangle = new Rectangle();

    private Random random = new Random();

    private  boolean living = true;

    public Group group = Group.BAD;

    /**
     * 停止状态
     */
    public boolean moving = true;

    public FireStrategy fs;

    public Tank(int x, int y, DirEnum dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        if(group == Group.GOOD) {

            String goodFsName = (String) PropertyMgr.get("goodFs");
            try {
                fs = (FireStrategy) Class.forName(goodFsName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            fs = new DefaultFireStrategy();
            String badFsName = (String) PropertyMgr.get("badFs");
            try {
                fs = (FireStrategy) Class.forName(badFsName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        GameModel.getInstance().add(this);

    }

    /**
     * 发射子弹
     */
    public void fire() {
        fs.fire(this);
    }

    /**
     * 坦克本体
     * @param g
     */
    public void paint(Graphics g) {
        if(!living){
            GameModel.getInstance().remove(this);
        }

        switch (dir){
            case LEFT:
                g.drawImage( this.group == Group.GOOD? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankU : ResourceMgr.badTankU , x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
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

        oldx = x;
        oldy = y;

        if(!moving) return ;

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


        if(this.group == Group.BAD && random.nextInt(100) > 95) this.fire();

        if(this.group == Group.BAD && random.nextInt(100) > 90) randomDir();

        //边界检测
        boundsCheck();

        // update rectangle
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    public void boundsCheck() {
        if (this.x < 2) x = 2;
        if (this.y < 28) y = 28;
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) x = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;

    }

    public void randomDir() {

       this.dir = DirEnum.values()[random.nextInt(4)];

    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public DirEnum getDir() {
        return dir;
    }

    public void setDir(DirEnum dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
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

    public void back(){
        this.x = this.oldx;
        this.y = this.oldy;
    }

}
