package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by lurix on 04.06.17.
 */
public class MenuGans {
    private Texture activeTexture, passiveTexture;
    private int x,y;
    private boolean active = true;
    private Rectangle myRectangle;

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {

        return active;
    }

    public Rectangle getMyRectangle() {
        return myRectangle;
    }

    public MenuGans(Texture texture, int x, int y) {
        this.activeTexture = texture;
        this.x = x;
        this.y = y;
        myRectangle = new Rectangle(x,y,activeTexture.getWidth(),activeTexture.getHeight());
        passiveTexture = new Texture("blood.png");
    }

    public void render(SpriteBatch batch) {
        if (active){
            batch.draw(activeTexture,x,y);
        }else {
            batch.draw(passiveTexture,x,y);
        }

    }
}
