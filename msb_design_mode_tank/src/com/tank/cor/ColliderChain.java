package com.tank.cor;

import com.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * 责任链
 * auther:
 * Date:2020/9/2222:47
 **/
public class ColliderChain implements Collider{

    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain(){
        add(new BulletTankCollider());
        add(new TankTankCollider());
        add(new BulletWallCollider());
        add(new TankWallCollider());
    }


    public void add(Collider c){
        colliders.add(c);
    };

    public boolean collider(GameObject o1, GameObject o2) {

        for(int i = 0; i < colliders.size(); i++){
            // 返回值为 false 表示碰撞对象已经消失 不需要判断下一个碰撞器，不加入责任链中
            if(!colliders.get(i).collider(o1, o2)){
                return false;
            }
        }

        return true;
    }

}
