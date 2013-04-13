package com.benjaminlanders.sloth.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.sloth.renderer.Renderer;
import com.benjaminlanders.sloth.SlothMain;

public class SplashScreen extends Renderer
{
	Texture splash;
	float timeElapsed = 0;
	public static final float END_TIME=2;

	public SplashScreen(SpriteBatch batch, SlothMain reference,Texture splash)
	{
		super(batch, reference);
		this.splash = splash;
		
	}

	public void render(float delta)
	{
		timeElapsed += delta;
		batch.begin();
		batch.draw(splash, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
	}
	public boolean isFinished()
	{
		return timeElapsed > END_TIME;
	}


}
