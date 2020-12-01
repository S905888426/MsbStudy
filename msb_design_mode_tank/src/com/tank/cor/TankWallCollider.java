package com.tank.cor;

import com.tank.GameObject;
import com.tank.model.Tank;
import com.tank.model.Wall;

/**
 * 坦克和墙碰撞器
 * auther:
 * Date:2020/9/2222:07
 **/
public class TankWallCollider implements Collider{

    @Override
    public boolean collider(GameObject o1, GameObject o2) {

        if(o1 instanceof Tank && o2 instanceof Wall){
            Tank t = (Tank) o1;
            Wall w = (Wall) o2;

            if(t.rectangle.intersects(w.rect)){
                t.back();
            }

        } else if(o1 instanceof Wall && o2 instanceof Tank){
            return collider(o2, o1);
        }

        return true;


    }

}
