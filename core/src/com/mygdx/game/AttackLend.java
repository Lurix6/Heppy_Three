package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * Created by lurix on 02.06.17.
 */
public class AttackLend {
    private Rectangle rectangle;
    private Rectangle bulletRectangle;
    private boolean landIsFree = true;
    private Bullet bullet ;
    private boolean attack = false;

    public void setDeleteBullet(boolean deleteBullet) {
        this.deleteBullet = deleteBullet;
    }

    private boolean deleteBullet = false;
    private Texture myTexture = new Texture("guns.png"),bulletTexture = new Texture("bullet.png");
    private int x, y;


    public void render(SpriteBatch batch){
        if (landIsFree == false){
            batch.draw(myTexture, x , y);
        }
        if (attack == true){
            bullet.render(batch);
        }
        update();
    }
    private void update(){
        if (bullet.getX() > 590){
            createBullet();
            attack = false;
        }
        if (deleteBullet){
            bulletRectangle = null;
            deleteBullet = false;
        }
    }
    public Rectangle getBulletRectangle() {
         bulletRectangle = bullet.getBulletRectangle();
        return bulletRectangle;
    }



    public AttackLend(Rectangle rectangle) {
        this.rectangle = rectangle;
        createBullet();
    }
    private void createBullet(){
        bullet = new Bullet(bulletTexture,125, (int) (14 + rectangle.getY()));
    }

    public Rectangle getRectangle(){
        return rectangle;
    }

    public void setAttack(boolean attack) {
        this.attack = attack;
    }



    public void setLandIsFree(boolean landIsFree) {
        this.landIsFree = landIsFree;
    }

    public boolean isLandIsFree() {
        return landIsFree;

    }

    public void setX(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
