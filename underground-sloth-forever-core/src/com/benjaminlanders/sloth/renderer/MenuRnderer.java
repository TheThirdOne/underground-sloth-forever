package com.benjaminlanders.sloth.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.sloth.renderer.Renderer;
import com.benjaminlanders.sloth.SlothMain;

public class MenuRnderer extends Renderer
{
	boolean isFinished = false;
	
	public MenuRnderer(SpriteBatch batch, SlothMain reference)
	{
		super(batch, reference);
		
	}

	@Override
	public void render(float delta)
	{
		
	}

	@Override
	public boolean isFinished()
	{
		return false;
	}

}
