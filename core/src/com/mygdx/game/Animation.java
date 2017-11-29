package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import java.util.Date;
import java.util.Random;


public class Animation {
    Random r = new Random();
    private Texture myTexture;
    private int x = 640;
    private int path;
    static Date start;
    int positionAddNew;
    private com.badlogic.gdx.math.Rectangle rectangleAnimation;



    public Animation(Texture myTexture , int path) {
        this.myTexture = myTexture;

        this.path = path;
        positionAddNew = r.nextInt(580)+400;
        rectangleAnimation = new com.badlogic.gdx.math.Rectangle(640,path*60,myTexture.getWidth(),myTexture.getHeight());
    }

    public void render(SpriteBatch batch){

        batch.draw(myTexture,x,path*60);
        update();
    }


    public int getX() {
        return x;
    }

    public com.badlogic.gdx.math.Rectangle getRectangleAnimation() {
        update();
        return rectangleAnimation;
    }

    public int getPath() {
        return path;
    }

    private void update(){
        x--;
        rectangleAnimation = new com.badlogic.gdx.math.Rectangle(x,path*60,myTexture.getWidth(),myTexture.getHeight());


    }

}
