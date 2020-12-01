package com.tank.cor;

import com.tank.GameObject;

/**
 * 碰撞器
 * auther:
 * Date:2020/9/2222:05
 **/
public interface Collider {

    boolean collider(GameObject o1, GameObject o2);

}
