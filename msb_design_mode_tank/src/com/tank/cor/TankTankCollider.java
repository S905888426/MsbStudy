package com.tank.cor;

import com.tank.GameObject;
import com.tank.model.Tank;

/**
 * 坦克坦克碰撞器
 * auther:
 * Date:2020/9/2222:07
 **/
public class TankTankCollider implements Collider{

    @Override
    public boolean collider(GameObject o1, GameObject o2) {

        if(o1 instanceof Tank && o2 instanceof Tank){
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if(t1.getRectangle().intersects(t2.getRectangle())){
                t1.back();
                t2.back();
            }
        }

        return true;

    }

}
