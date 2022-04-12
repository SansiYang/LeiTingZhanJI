package cn.tx;

import javax.swing.*;
import java.awt.*;

public class Bullet {
    int x,y;
    int width=10,heigth=10;
    int speed=10;
    public Image image=new ImageIcon("img/30021.png").getImage();

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bullet(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
    }
}
