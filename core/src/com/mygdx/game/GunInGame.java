package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by lurix on 01.06.17.
 */
public class GunInGame {
    private Texture img;
    private Rectangle rectangle;
    private int x,y;
    private boolean attack = false;

    public void setImg(Texture img) {
        this.img = img;
    }

    public Rectangle getRectangle() {
        rectangle = new Rectangle(x,y,img.getWidth(),img.getHeight());
        return rectangle;
    }
    public GunInGame(Texture img, int x, int y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }
    public void render(SpriteBatch batch){
        batch.draw(img,x,y);
    }
}
