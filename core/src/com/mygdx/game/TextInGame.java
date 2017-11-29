package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Date;


public class TextInGame {
    private SpriteBatch batch;
    private BitmapFont font;



    public TextInGame(SpriteBatch batch)
    {
        this.batch = batch;
        font = new BitmapFont(Gdx.files.internal("font/my_font.fnt"),
                Gdx.files.internal("font/my_font.png"), false);

    }



    public void render(boolean selectGun)
    {
        font.setColor(Color.BLUE);
        font.draw(batch, "You Select:", 200, 550);


    }

}
