package com.tank.strategy;

import com.tank.model.Bullet;
import com.tank.model.Tank;
import com.tank.enums.DirEnum;

/**
 * 特殊子弹策略 - 四个方向发射子弹
 * auther:
 * Date:2020/9/1522:56
 **/
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        DirEnum[] dirs = DirEnum.values();
        for(DirEnum dir : dirs){
            new Bullet(bX, bY, dir, t.group);
        }

        new Bullet(bX, bY, t.dir, t.group);
    }
}
