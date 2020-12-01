package com.tank.strategy;

import com.tank.model.Tank;

/**
 * 发射子弹策略
 * auther:
 * Date:2020/9/1522:29
 **/
public interface FireStrategy {

    void fire(Tank t);

}
