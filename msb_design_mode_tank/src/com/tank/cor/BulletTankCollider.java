package com.tank.cor;

import com.tank.model.Bullet;
import com.tank.model.Explode;
import com.tank.GameObject;
import com.tank.model.Tank;

/**
 * 坦克子弹碰撞器
 * auther:
 * Date:2020/9/2222:07
 **/
public class BulletTankCollider implements Collider{

    @Override
    public boolean collider(GameObject o1, GameObject o2) {

        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;

            if(b.group == t.getGroup()) return false;

            if(b.rectangle.intersects(t.rectangle)){
                t.die();
                b.die();
                int ex = t.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
                int ey = t.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
                new Explode(ex, ey);

                return true;
            }



        } else if(o1 instanceof Tank && o2 instanceof Bullet){
            return collider(o2, o1);
        }

        return true;


    }

}
