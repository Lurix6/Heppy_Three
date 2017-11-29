package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by lurix on 31.05.17.
 */
public class InputHandlet {
    public static boolean passedUp(){
       return Gdx.input.isKeyPressed(Input.Keys.UP);
    }
    public static boolean passedDown(){
        return Gdx.input.isKeyPressed(Input.Keys.DOWN);
    }
    public static boolean passedLeft(){
        return Gdx.input.isKeyPressed(Input.Keys.LEFT);
    }
    public static boolean passedRight(){return Gdx.input.isKeyPressed(Input.Keys.RIGHT);}
    public static int getMousePositionX(){
        return Gdx.input.getX();
    }
    public static int getMousePositionY(){
        return Gdx.graphics.getHeight()-Gdx.input.getY();
    }
    public static boolean mousClik(){return Gdx.input.justTouched();}
}
