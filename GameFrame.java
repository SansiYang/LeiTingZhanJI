package cn.tx;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;


public class GameFrame extends JFrame {

    HeroPlane heroPlane;

    //定义子弹集合
    Vector<Bullet>bullets=new Vector<>();
    //定义敌机集合
    Vector<EnemyPlane>enemys=new Vector<>();

    GameFrame frame;

    public GameFrame(){
        frame=this;
        //创建英雄机
        heroPlane=new HeroPlane();
        heroPlane.start();
        //设置窗体的宽高
        this.setSize(500,760);
        //标题
        this.setTitle("雷霆战机");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //窗口可见
        this.setVisible(true);


        //添加线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();





       // 产生敌机的线程
        Random r=new Random();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    EnemyPlane enemyPlane = new EnemyPlane(r.nextInt(500),0,frame);
                    enemyPlane.start();
                    enemys.add(enemyPlane);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

    public void paint(Graphics g){
      //  System.out.println("绘制画板");
        //画背景
        BufferedImage image = (BufferedImage) this.createImage(this.getSize().width,this.getSize().height);
        //高效缓存的画笔
        Graphics bi=image.getGraphics();
        bi.drawImage(new ImageIcon("img/MAP02_01.png").getImage(),0,0,null);
        bi.drawImage(heroPlane.img,heroPlane.x,heroPlane.y,heroPlane.width,heroPlane.heigth,null);

        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet=bullets.get(i);
            if(bullet.y>0)
                bi.drawImage(bullet.image,bullet.x,bullet.y-=bullet.speed,bullet.width,bullet.heigth,null);
            else
                bullets.remove(bullet);
        }

        //画敌机
        for (int i = 0; i < enemys.size(); i++) {
            EnemyPlane ep=enemys.get(i);
            if(ep.y<760)
                bi.drawImage(ep.img,ep.x,ep.y+=ep.speed,ep.width,ep.heigth,null);
            else
                enemys.remove(ep);
        }


        //生效
        g.drawImage(image,0,0,null);
    }

    public static void main(String[]args){
        GameFrame frame=new GameFrame();
        Player player=new Player(frame);
        frame.addKeyListener(player);
    }

}
