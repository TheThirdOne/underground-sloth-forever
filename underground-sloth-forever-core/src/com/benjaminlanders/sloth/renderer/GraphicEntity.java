package com.benjaminlanders.sloth.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.sloth.helper.Graphics;

/**
 * Used to group animations
 * @author Benjamin Landers
 */
public class GraphicEntity
{
	public float rotation,x,y;
	protected AnimationUnit[] units;
	public int[] xCenter, yCenter;
	
	public GraphicEntity(int size)
	{
		units = new AnimationUnit[size];
		xCenter = new int[size];
		yCenter = new int[size];
	}
	public GraphicEntity(AnimationUnit[] units)
	{
		this(units.length);
		this.units = units;
	}
	
	public void render(SpriteBatch batch)
	{
		AnimationUnit unit;
		for(int i = 0; i < units.length;i++)
		{
			unit = units[i];	
			Graphics.draw(batch,unit.frame,x,y,xCenter[i]+unit.frame.getRegionWidth()/2,
					yCenter[i]+unit.frame.getRegionHeight()/2,.1f,rotation); 
		}
	}
	public void render(SpriteBatch batch, boolean flipX)
	{
		AnimationUnit unit;
		for(int i = 0; i < units.length;i++)
		{
			unit = units[i];	
			Graphics.draw(batch,unit.frame,x,y,xCenter[i]+unit.frame.getRegionWidth()/2,
					yCenter[i]+unit.frame.getRegionHeight()/2,((flipX)?-1:1)*.1f, .1f,rotation); 
		}
	}

}
