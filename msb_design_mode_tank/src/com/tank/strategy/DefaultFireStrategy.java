package com.tank.strategy;

import com.tank.model.Bullet;
import com.tank.model.Tank;

/**
 * 默认子弹策略
 * auther:
 * Date:2020/9/1522:30
 **/
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        //装饰模式应用
//      GameModel.getInstance().add(new TailDecorator(new RectDecorator(new Bullet(bX, bY, t.dir, t.group))));

        new Bullet(bX, bY, t.dir, t.group);
    }
}
