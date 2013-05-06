package com.benjaminlanders.sloth.model;

public class Apple 
{
	public float x,y;
	public static final float width = .05f, height = .065f;
	public Apple(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	public Apple(String[] parts)
	{
		this(Float.parseFloat(parts[0]),Float.parseFloat(parts[1]));
	}
}
