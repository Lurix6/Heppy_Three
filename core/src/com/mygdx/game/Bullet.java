package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by lurix on 04.06.17.
 */
public class Bullet {
    private Texture myTexture;
    private Rectangle bulletRectangle;
    private int x,y;

    public int getX() {
        return x;
    }

    public Bullet(Texture myTexture, int x, int y) {
        this.myTexture = myTexture;
        this.x = x;
        this.y = y;
        bulletRectangle = new Rectangle(x,y,myTexture.getWidth(),myTexture.getHeight());
    }
    public void render(SpriteBatch batch){
        batch.draw(myTexture,x,y);
        update();
    }

    public Rectangle getBulletRectangle() {
        return bulletRectangle;
    }

    public void update(){
        x= x+10;
        bulletRectangle.set(x,y,myTexture.getWidth(),myTexture.getHeight());

    }
}
