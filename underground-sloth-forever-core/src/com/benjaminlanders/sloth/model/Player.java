package com.benjaminlanders.sloth.model;

public class Player 
{
	private static final float RUN_SPEED = .005f;
	private static final float SLOW_THRESHOLD = .04f;
	public float x,y;
	public boolean left, walking, climbing, moving;
	public void playerUpdate(float deltaX, float deltaY, boolean walking, boolean climbing)
	{
		left = (walking|climbing)?(deltaX < 0):left;
		x += (walking)?((Math.abs(deltaX) < RUN_SPEED)?((Math.abs(deltaX)*10> SLOW_THRESHOLD)?deltaX:0):RUN_SPEED*((deltaX < 0)?-1:1)) : 0;
		y += deltaY;
		if(y < -2)
		{
			y = 1f;
			x = .1f;
		}
		this.walking = walking;
		this.climbing = climbing;
		moving = (Math.abs(deltaX) < RUN_SPEED);		
	}
}
