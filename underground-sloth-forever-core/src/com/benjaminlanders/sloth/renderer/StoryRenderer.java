package com.benjaminlanders.sloth.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.sloth.SlothMain;
import com.benjaminlanders.sloth.helper.Assets;

public class StoryRenderer extends Renderer
{
	int background;
	int[] story, text;
	int state;
	float stateTime;
	BitmapFont font;
	
	public StoryRenderer(SpriteBatch batch, SlothMain reference, int background, int[] story,int[] text)
	{
		super(batch, reference);
		this.story = story;
		this.background = background;
		font = new BitmapFont();
		font.setScale(SlothMain.width/600,SlothMain.height/400);
		this.text = text;
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
		if(state < 6)
		{
			batch.draw(Assets.getImage(story[state]), 0,0, SlothMain.width, SlothMain.height);
			font.draw(batch, Assets.getString(text[state]), 0, SlothMain.height);
		}

	}

	@Override
	public boolean isFinished()
	{
		// TODO Auto-generated method stub
		return state >= 6;
	}

}
