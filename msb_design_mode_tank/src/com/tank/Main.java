package com.tank;

import com.tank.enums.DirEnum;

/**
 * 主程序
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame frame = new TankFrame();

        while (true){
            Thread.sleep(50);
            frame.repaint();
        }

    }

}
