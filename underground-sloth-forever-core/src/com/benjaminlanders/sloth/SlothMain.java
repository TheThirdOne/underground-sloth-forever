package com.benjaminlanders.sloth;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.sloth.helper.Assets;
import com.benjaminlanders.sloth.renderer.MainRenderer;
import com.benjaminlanders.sloth.renderer.Renderer;
import com.benjaminlanders.sloth.renderer.SplashScreen;
import com.benjaminlanders.sloth.renderer.StoryRenderer;

public class SlothMain implements ApplicationListener
{
	private SpriteBatch batch;
	private Renderer splash, animation, main;
	
	public static float height, width;
	
	@Override
	public void create()
	{		
		height = Gdx.graphics.getHeight();
		width = Gdx.graphics.getWidth();
		
		batch = new SpriteBatch();
		Assets.getImage(3);
		splash = new SplashScreen(batch, this, Assets.getImage(Assets.libGdx));
		animation = new StoryRenderer(batch, this, Assets.story0, 
				new int[]{Assets.story1 , Assets.story2, Assets.story3 , Assets.story4,
							Assets.story5, Assets.story6 , Assets.story7, Assets.story8});
		main = new MainRenderer(batch, this);
	}

	@Override
	public void dispose()
	{
		batch.dispose();
	}

	@Override
	public void render()
	{	
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		if(!splash.isFinished())
		{
			splash.render(Gdx.graphics.getDeltaTime());
		}else
		if(!animation.isFinished())
		{
			animation.render(Gdx.graphics.getDeltaTime());
		}else
		{
			main.render(Gdx.graphics.getDeltaTime());
		}
		batch.end();
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
