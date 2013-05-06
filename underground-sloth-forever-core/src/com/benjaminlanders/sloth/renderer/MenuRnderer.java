package com.benjaminlanders.sloth.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.sloth.helper.Assets;
import com.benjaminlanders.sloth.renderer.Renderer;
import com.benjaminlanders.sloth.SlothMain;

public class MenuRnderer extends Renderer
{
	boolean isFinished = false;
	String[] levelNames = {"Level 1: The Learning", "Level 2: The Learning", "Level 3: The Learning",
			"Level 4: The Learning", "Level 5: The Learning", "Level 6: The Learning"};
	public static final int col = 3, row = 3;
	
	public MenuRnderer(SpriteBatch batch, SlothMain reference)
	{
		super(batch, reference);
		
	}

	@Override
	public void render(float delta)
	{
		detectSelection();
		batch.begin();
		renderBackground();
		renderTitle();
		renderNames();
		batch.end();
	}

	@Override
	public boolean isFinished()
	{
		return isFinished;
	}
	
	public void renderBackground()
	{
		batch.draw(Assets.getImage(Assets.menuBackground), 0, 0, SlothMain.width, SlothMain.height);
	}
	public void renderTitle()
	{
		Assets.font.setScale(3);
		Assets.font.draw(batch, "Levels", SlothMain.width/2 - Assets.font.getBounds("Levels").width/2, SlothMain.height*.99f);
	}
	public void renderNames()
	{
		Assets.font.setScale(.7f);
		for(int i = 0; i < levelNames.length; i++)
		{
			renderName(levelNames[i],i%col,(int )i / col);
		}
	}
	public void renderName(String name, int x, int y)
	{
		Assets.font.draw(batch, name, .7f*SlothMain.width*x/(col-1) + .15f*SlothMain.width - Assets.font.getBounds(name).width/2, .8f*SlothMain.height*(row-y)/row - .1f*SlothMain.height );
	}
	public int detectSelection()
	{
		if(Gdx.input.justTouched())
		{
			for(int i = 0; i < levelNames.length; i++)
			{
				if(detectCollide(levelNames[i],i%col,(int )i / col))
				{
					Gdx.app.log("info", "" + i);
					return i;
				}
			}
		}
		return -1;
	}
	public boolean detectCollide(String name, int x, int y)
	{
		//System.out.println(Gdx.graphics.getWidth() + " " + SlothMain.width);
		float inX  = Gdx.input.getX()/((float) Gdx.graphics.getWidth());
		float inY = 1 - Gdx.input.getY()/((float) Gdx.graphics.getHeight());
		
		float trueX = (.7f*SlothMain.width*x/(col-1) + .15f*SlothMain.width - Assets.font.getBounds(name).width/2)/SlothMain.width;
		float trueY = (.8f*SlothMain.height*(row-y)/row - .1f*SlothMain.height)/SlothMain.height;
		
		float width = Assets.font.getBounds(name).width/SlothMain.width;
		float height = Assets.font.getBounds(name).height/SlothMain.height;
		
		if(inX > trueX && inY < trueY && inX < trueX + width && inY > trueY - height)
		{
			return true;
		}
		return false;
		
	}
}
