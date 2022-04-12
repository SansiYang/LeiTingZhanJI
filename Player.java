package cn.tx;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends KeyAdapter {

    GameFrame frame;

    public  Player(GameFrame frame){
        this.frame=frame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();
        //上下左右：38，40，37，39
        switch (keyCode){
            case 38:
                frame.heroPlane.up=true;
                break;
            case 40:
                frame.heroPlane.down=true;
                break;
            case 37:
                frame.heroPlane.left=true;
                break;
            case 39:
                frame.heroPlane.right=true;
                break;
            case 96:
               addBullet();
                break;
        }
        super.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode=e.getKeyCode();
        //上下左右：38，40，37，39
        switch (keyCode){
            case 38:
                frame.heroPlane.up=false;
                break;
            case 40:
                frame.heroPlane.down=false;
                break;
            case 37:
                frame.heroPlane.left=false;
                break;
            case 39:
                frame.heroPlane.right=false;
                break;
        }
        super.keyReleased(e);
    }
    public void addBullet(){
        frame.bullets.add(new Bullet(frame.heroPlane.x+5,frame.heroPlane.y-20));
    }

}
