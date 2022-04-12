package cn.tx;

import javax.swing.*;
import java.awt.*;

public class EnemyPlane extends Thread {
    public  GameFrame gf;
    public  int x,y;
    public  int width=50;
    public  int heigth=50;
    public  int speed=2;
    public Image img =new ImageIcon("img/10024.png").getImage();


    public EnemyPlane(int x, int y,GameFrame gf) {
        this.gf = gf;
        this.x = x;
        this.y = y;
    }


    public EnemyPlane(int x, int y, int width, int heigth,GameFrame gf) {
        this.gf = gf;
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
    }


    public void run(){
        while (true) {
            if(hit()){
                System.out.println("打中了!");
                this.speed=0;
                this.img=new ImageIcon("img/300350.png ").getImage();
                try{
                    this.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gf.enemys.remove(this);
                break;
            }
            if(this.y>=760){
                break;
            }
            try {
                    this.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }


    //碰撞检测
    public  boolean hit(){
        Rectangle myrect = new Rectangle(this.x,this.y,this.width,this.heigth);

        Rectangle rect=null;

        for(int i=0;i<gf.bullets.size();i++){
            Bullet bullet=gf.bullets.get(i);
            System.out.println("test hit");
            rect=new Rectangle(bullet.x,bullet.y-1,bullet.width,bullet.heigth);
            if(myrect.intersects(rect)){
                return true;
            }
        }
        return false;
    }




}
