package com.benjaminlanders.sloth.model;

public class Player 
{
	private static final float RUN_SPEED = .01f;
	private static final float SLOW_THRESHOLD = .009f;
	public float x,y;
	public boolean left, walking, climbing;
	public void playerUpdate(float deltaX, float deltaY, boolean walking, boolean climbing)
	{
		left = (walking)?((deltaX > 0)?false:true):left;
		x += (walking)?((Math.abs(deltaX) < RUN_SPEED)?((Math.abs(deltaX) > SLOW_THRESHOLD)?deltaX:0):RUN_SPEED*((deltaX < 0)?-1:1)) : 0;
		y += deltaY;
		this.walking = walking;
		this.climbing = climbing;
		
	}
}
