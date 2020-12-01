package com.tank.cor;

import com.tank.*;
import com.tank.model.Bullet;
import com.tank.model.Wall;

/**
 * 子弹和墙碰撞器
 * auther:
 * Date:2020/9/2222:07
 **/
public class BulletWallCollider implements Collider{

    @Override
    public boolean collider(GameObject o1, GameObject o2) {

        if(o1 instanceof Bullet && o2 instanceof Wall){
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;

            if(b.rectangle.intersects(w.rect)){
                b.die();
            }

        } else if(o1 instanceof Wall && o2 instanceof Bullet){
            return collider(o2, o1);
        }

        return true;


    }

}
