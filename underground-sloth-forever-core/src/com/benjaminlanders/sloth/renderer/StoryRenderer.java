package com.benjaminlanders.sloth.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.sloth.SlothMain;
import com.benjaminlanders.sloth.helper.Assets;

public class StoryRenderer extends Renderer
{
	int background;
	int[] story;
	int state;
	float stateTime;
	
	public StoryRenderer(SpriteBatch batch, SlothMain reference, int background, int[] story)
	{
		super(batch, reference);
		this.story = story;
		this.background = background;
	}

	@Override
	public void render(float delta)
	{
		if(Gdx.input.justTouched())
		{
			state++;
		}
		if(state < 2)
		{
			batch.draw(Assets.getImage(background), 0,0, SlothMain.width, SlothMain.height);
		}
		else
		{
			batch.draw(Assets.getImage(Assets.background), 0,0, SlothMain.width, SlothMain.height);
		}
		if(state < 8)
		{
			batch.draw(Assets.getImage(story[state]), 0,0, SlothMain.width, SlothMain.height);
		}

	}

	@Override
	public boolean isFinished()
	{
		// TODO Auto-generated method stub
		return state >= 8;
	}

}
