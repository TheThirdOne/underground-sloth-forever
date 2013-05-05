package com.benjaminlanders.sloth;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.sloth.controller.Controller;
import com.benjaminlanders.sloth.helper.Assets;
import com.benjaminlanders.sloth.renderer.MainRenderer;
import com.benjaminlanders.sloth.renderer.Renderer;
import com.benjaminlanders.sloth.renderer.SplashScreen;
import com.benjaminlanders.sloth.renderer.StoryRenderer;

public class SlothMain implements ApplicationListener
{
	private SpriteBatch batch;
	private Renderer splash, animation, main;
	private int state;
	private Controller controller;
	public static final int SPLASH  = 0, MENU = 1, STORY = 2, MAIN = 3;
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
							Assets.story5, Assets.story6},
				new int[]{Assets.storyText1 , Assets.storyText2, Assets.storyText3 , Assets.storyText4,
							Assets.storyText5, Assets.storyText6} );
		
		Assets.font = new BitmapFont();
		
		controller = new Controller();
		main = new MainRenderer(batch, this, controller);
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
		switch(state)
		{
			case SPLASH:
				if(!splash.isFinished())
				{
					splash.render(Gdx.graphics.getDeltaTime());
					break;
				}else
				{
					setState(STORY);
				}
			case MENU:
				
				break;
			case STORY:
				if(!animation.isFinished())
				{
					animation.render(Gdx.graphics.getDeltaTime());
					break;
				}else
				{
					setState(MAIN);
				}
			case MAIN:
				main.render(Gdx.graphics.getDeltaTime());
				break;
		}
	}
	public void setState(int state)
	{
		this.state = state;
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
