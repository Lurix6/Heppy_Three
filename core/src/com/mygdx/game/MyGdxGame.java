package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Date;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	private Date start = new Date();
	GameManeger maneger ;
	private float x,y ;


	@Override
	public void create () {
		Animation.start = start;
		batch = new SpriteBatch();
		maneger = new GameManeger(batch);
		maneger.crete();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		maneger.render(batch);
		batch.end();
	}
	public void update(){
		if (InputHandlet.passedDown())y--;
		if (InputHandlet.passedUp())y++;
		if (InputHandlet.passedRight())x++;
		if (InputHandlet.passedLeft())x--;

	}


}
