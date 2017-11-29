package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by lurix on 31.05.17.
 */
public class GameMap {
    SpriteBatch batch;
    Texture bigGras = new Texture("big_gras.png");

    public GameMap(SpriteBatch batch) {
        this.batch = batch;
    }

    public void render() {
        batch.draw(bigGras,0,0);
    }
}
