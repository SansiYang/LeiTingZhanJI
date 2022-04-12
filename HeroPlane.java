package cn.tx;

import javax.swing.*;
import java.awt.*;

public class HeroPlane extends Thread {

    //飞机的初始坐标
    int x=230,y=600;

    //飞机的大小
    int width=70,heigth=70;

    //飞机移动的速度
    int speed=10;

    //飞机的图片
    Image img=new ImageIcon("img/10013.png").getImage();

    //定义方向键的标志
    boolean up,down,left,right;

    //无参构造方法
    public HeroPlane() {
    }

    //有参构造方法
    public HeroPlane(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
    }

    public void run(){
        while (true){
            if(up){
                y-=speed;
            }
            if(down){
                y+=speed;
            }
            if(left){
                x-=speed;
            }
            if(right){
                x+=speed;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
