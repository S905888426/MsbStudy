package com.tank;


import com.tank.enums.DirEnum;
import com.tank.model.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * auther:
 * Date:2020/8/2521:56
 **/
public class TankFrame extends Frame {

    GameModel gm = GameModel.getInstance();



    public static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;


    public TankFrame(){
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setResizable(false);
        this.setTitle("tank war");
        this.setVisible(true);

        //添加键盘监听事件
        this.addKeyListener(new MyKeyListener());

        // 关闭窗口监听事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 双重缓存 解决窗口闪烁问题
     */
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * 画笔
     * @param g
     */
    @Override
    public void paint(Graphics g) {

        gm.paint(g);



    }

    class MyKeyListener extends KeyAdapter{

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        /**
         * 按下按键监听事件
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
             int key = e.getKeyCode();
             switch (key){
                 case KeyEvent.VK_LEFT:
                     bL = true;
                     break;
                 case KeyEvent.VK_UP:
                     bU = true;
                     break;
                 case KeyEvent.VK_RIGHT:
                     bR = true;
                     break;
                 case KeyEvent.VK_DOWN:
                     bD = true;
                     break;
                 case KeyEvent.VK_CONTROL:
                     gm.getMainTank().fire();
                     break;
                 default:
                     break;
             }

             setMainTankDir();

        }

        /**
         * 按键松开监听事件
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;

            }

            setMainTankDir();
            
        }

        private void setMainTankDir() {
            Tank myTank = gm.getMainTank();

            if(!bL && !bU && !bR && !bD){
                myTank.setMoving(false);
            }else{
                myTank.setMoving(true);
                if(bL) myTank.setDir(DirEnum.LEFT);
                if(bU) myTank.setDir(DirEnum.UP);
                if(bR) myTank.setDir(DirEnum.RIGHT);
                if(bD) myTank.setDir(DirEnum.DOWN);
            }




        }

    }

}
