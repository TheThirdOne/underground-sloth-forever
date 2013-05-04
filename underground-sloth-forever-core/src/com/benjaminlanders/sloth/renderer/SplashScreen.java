package com.benjaminlanders.sloth.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.sloth.renderer.Renderer;
import com.benjaminlanders.sloth.SlothMain;

public class SplashScreen extends Renderer
{
	TextureRegion splash;
	float timeElapsed = 0;
	public static final float END_TIME=2;

	public SplashScreen(SpriteBatch batch, SlothMain reference,TextureRegion splash)
	{
		super(batch, reference);
		this.splash = splash;
		
	}

	public void render(float delta)
	{
		batch.begin();
		timeElapsed += delta;
		batch.draw(splash, 0,0, SlothMain.width, SlothMain.height);
		batch.end();
	}
	public boolean isFinished()
	{
		return timeElapsed > END_TIME;
	}


}
